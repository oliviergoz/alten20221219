/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.security;

import com.google.common.base.Preconditions;
import com.owliance.owlink.framework.constants.OwlinkMessages;
import com.owliance.owlink.repository.UsersRepositoryDAO;
import com.owliance.owlink.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.owliance.owlink.repository.UsersRepositoryPDAO;

import java.util.Properties;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 * Description of the class OwlinkWebUserDetailService.java
 *
 * @author hbenizid
 * @see com.owliance.owlink.configuration.security
 *
 * <p>
 * Created : 21 nov. 2016
 * <p>
 * Updated : 28 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 * @since 0.3.1 -Alpha
 */
public class OwlinkWebUserDetailService implements UserDetailsService {

    /**
     * The Constant L.
     */
    public static final Logger logger = LoggerFactory.getLogger(OwlinkWebUserDetailService.class);

    /**
     * The users repository DAO.
     */
    @Resource
    private UsersRepositoryDAO usersRepositoryDAO;

    @Resource
    private UsersRepositoryPDAO UsersRepositoryPDAO;
    private DirContext connection;
    private DirContext connectionP;
    private String LDAPurl = "ldap://tessiassurance.local:389";
    private String base = "CN=Killian MILOT,OU=Dev,OU=Users,OU=IT,OU=Muret,OU=Users,OU=Accounts,OU=000 - Global,OU=Clients,OU=TessiAssurance,DC=tessiassurance,DC=local";
    private String chemin_recherche = "OU=Clients,OU=TessiAssurance,DC=tessiassurance,DC=local";
    private String MDP = "Roucoutou31#";
    private boolean userExiste;

    /**
     * the the user name
     *
     * @param userName the user name
     * @return the User name details
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {

        String MC = UsersRepositoryPDAO.moyenConnexion(userName);
        logger.info("recherche = " + MC);

        if (MC == null) {
            MC = "NULL";
        }

        if (MC.equals("LDA")) {
            OwlinkWebUserDetailService app = new OwlinkWebUserDetailService();
            app.newConnection();
            try {
                app.searchUsers(userName);
                if (app.userExiste) {
                    logger.info("Profil trouver dans le LDAP");
                }
            } catch (NamingException ex) {
                logger.info(ex.getMessage());
            }
        }

        if (MC.equals("ORA")) {
            // connexion oracle
        }

        Preconditions.checkArgument(userName != null);
        logger.info("Retriving user by UserName (UpperCase) = [{}]", userName);
        UsersVO userVO = usersRepositoryDAO.findByUserNom(userName.toUpperCase());

        if (userVO == null) {
            logger.info(OwlinkMessages.USER_NOT_FOUND_OR_BAD_CREDENTIAL);
            throw new UsernameNotFoundException(OwlinkMessages.USER_NOT_FOUND_OR_BAD_CREDENTIAL);
        }

        if (userVO.getUserDisabled()) {
            throw new DisabledException(OwlinkMessages.USER_DISABLED);
        }

        /*
         * Returning UserDetails (in order)
         *
         * 1) username
         *
         * 2) password
         *
         * 3) boolean enabled
         *
         * 4) boolean accountNonExpired
         *
         * 5) boolean credentialsNonExpired
         *
         * 6) boolean accountNonLocked
         *
         * 7) Collection<? extends GrantedAuthority> authorities
         *
         */
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(userVO.getUserNom().toUpperCase(), "", true,
                true, true, true, getGrantedAuthorities(userVO));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userDetails;
    }

    /**
     * Gets the granted authorities.
     *
     * @param userVO the user VO
     * @return the granted authorities
     */
    private List<GrantedAuthority> getGrantedAuthorities(UsersVO userVO) {

        logger.info("GetAuthorities for user [{}]", userVO.getUserNom());
        GrantedAuthority roleUser = new SimpleGrantedAuthority(Authorities.ROLE_USER.name());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(roleUser);
        authorities.add(new SimpleGrantedAuthority("USER"));

        logger.info("Returning list of Authority");

        return authorities;
    }

    /**
     *  créer une connexion au LDAP
     */
    public void newConnection() {

        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAPurl);
        env.put(Context.SECURITY_PRINCIPAL, base);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_CREDENTIALS, MDP);
        try {
            connection = new InitialDirContext(env);
            logger.info("Connexion au compte generique reussi");
        } catch (AuthenticationException ex) {
            logger.info(ex.getMessage());
        } catch (NamingException ex) {
            logger.info(ex.getExplanation());
        }
    }

    /**
     * cherche un utilisateur
     * @param usercherche nom de l'utilisateur recherché
     * @throws NamingException lève une exception si aucun utilisateur trouve
     */
    public void searchUsers(String usercherche) throws NamingException {

        userExiste = false;
        String searchFilter = "givenName=" + usercherche;
        String[] reqAtt = {"givenName"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);

        NamingEnumeration users = connection.search(chemin_recherche, searchFilter, controls);

        SearchResult result = null;
        if (users.hasMore()) {
            result = (SearchResult) users.next();
            Attributes attr = result.getAttributes();
            logger.info(attr.get("givenName").get(0).toString());
            if (result != null) {
                userExiste = true;
            }
        }
    }
}
