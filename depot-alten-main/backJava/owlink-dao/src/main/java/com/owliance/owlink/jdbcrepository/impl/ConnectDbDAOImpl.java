package com.owliance.owlink.jdbcrepository.impl;

import com.owliance.owlink.framework.utils.DateUtil;
import com.owliance.owlink.jdbcrepository.ConnectDbDAO;
import com.owliance.owlink.jdbcrepository.UsersJdbcDAO;
import com.owliance.owlink.repository.UsersRepositoryDAO;
import com.owliance.owlink.repository.UsersRepositoryPDAO;
import com.owliance.owlink.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;


/**
 * Description of the class ConnectDbDAO.java
 *
 * @author dabida
 * @see com.owliance.owlink.jdbcrepository
 *
 * <p>
 * Created : 03 Aout. 2021
 */
@Repository
public class ConnectDbDAOImpl implements ConnectDbDAO {

    /**
     * The Client id.
     */
    @Value(value = "${oracle.url}")
    private String urlDB;

    /**
     * Logger class for ConnectDbDAOImpl, Default Mode is INFO.
     */
    private static final Logger logger = LoggerFactory.getLogger(ConnectDbDAOImpl.class);

    @Resource
    private UsersRepositoryDAO usersRepositoryDAO;

    @Resource
    private UsersRepositoryPDAO usersRepositoryPDAO;

    @Resource
    private UsersJdbcDAO usersJdbcDAO;

    private DirContext connection = null;
    private DirContext connectionP;
    private String LDAPurl = "ldap://tessiassurance.local:389";
    private String base = "CN=Killian MILOT,OU=Dev,OU=Users,OU=IT,OU=Muret,OU=Users,OU=Accounts,OU=000 - Global,OU=Clients,OU=TessiAssurance,DC=tessiassurance,DC=local";
    private String chemin_recherche_P = "OU=Clients,OU=TessiAssurance,DC=tessiassurance,DC=local";
    private String MDP = "Roucoutou31#";

    /**
     * @see ConnectDbDAO#connectJdbcOracle(String, String)
     */
    @Override
    public boolean connectJdbcOracle(String password, String username) throws SQLException {

        ConnectDbDAOImpl app2 = new ConnectDbDAOImpl();
        app2.newConnection();

        String MC = usersRepositoryPDAO.moyenConnexion(username);
        logger.info("recherche = " + MC);

        if (MC == null) {
            MC = "NULL";
        }

        if (MC.equals("LDA")) {
            ConnectDbDAOImpl app = new ConnectDbDAOImpl();
            app.newConnection();
            try {
                app2.searchUsers(username, password);
                if (app2.connectionP != null) {
                    if (username.equals("OWEB")) {
                        password = "RJ47DCSQOK";
                    }
                    if (username.equals("MWEB")) {
                        password = "TEMPORAI12";
                    }
                }
            } catch (NamingException ex) {
                ex.getExplanation();
            }
        }

        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(urlDB, username, password);
            logger.info("Connected with connection");
            UsersVO userVO = usersRepositoryDAO.findByUserNom(username.toUpperCase());
            Date dateBlocage = null;
            if ((dateBlocage == null || DateUtil.compareDate(new Date(), dateBlocage) < 0) && userVO != null) {
                userVO.setUserLastCon(new Date());
                logger.info("Update last connection date");
                usersRepositoryDAO.saveAndFlush(userVO);
            }
            return true;
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * créer une connexion au LDAP
     */
    public void newConnection() {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAPurl);
        env.put(Context.SECURITY_PRINCIPAL, base);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_CREDENTIALS, MDP);
        try {
            this.connection = new InitialDirContext(env);
            logger.info("Connexion au compte generique reussi");
        } catch (AuthenticationException ex) {
            logger.info(ex.getMessage());
        } catch (NamingException ex) {
            logger.info(ex.getExplanation());
        }
    }

    /**
     * cherche et connecte un utilisateur
     * @param usercherche nom de l'utilisateur
     * @param pass mot de passe de l'utilisateur
     * @throws NamingException lève une exception en cas d'échec de la connexion
     */
    public void searchUsers(String usercherche, String pass) throws NamingException {

        String searchFilter = "givenName=" + usercherche;
        String[] reqAtt = {"givenName"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);

        NamingEnumeration users = connection.search(chemin_recherche_P, searchFilter, controls);

        SearchResult result = null;
        if (users.hasMore()) {
            result = (SearchResult) users.next();
            String distinguishedName = result.getNameInNamespace();

            Properties authEnv = new Properties();
            authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            authEnv.put(Context.PROVIDER_URL, LDAPurl);
            authEnv.put(Context.SECURITY_PRINCIPAL, distinguishedName);
            authEnv.put(Context.SECURITY_CREDENTIALS, pass);
            new InitialDirContext(authEnv);
            try {
                connectionP = new InitialDirContext(authEnv);
                logger.info("Connexion au compte utilisateur reussi");
            } catch (AuthenticationException ex) {
                logger.info(ex.getMessage());
            } catch (NamingException ex) {
                logger.info(ex.getExplanation());
            }
        }
    }
}
