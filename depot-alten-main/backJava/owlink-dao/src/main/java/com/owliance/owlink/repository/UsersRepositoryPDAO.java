/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.repository;


import com.owliance.owlink.vo.UsersVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Description of the class UsersRepositoryPDAO.java
 *
 * @author hbenizid
 * @see com.owliance.owlink.repository
 *
 * <p>
 * Created : 12 janv. 2017
 * <p>
 * Updated : 12 janv. 2017 by hbenizid (version 0.3.3-Alpha)
 *
 * <p>
 * Updated : 13 mars 2018 by aabdennabi (version 0.6.6-Alpha)
 * @since 0.3.3-Alpha
 */
@Repository
public interface UsersRepositoryPDAO extends org.springframework.data.repository.Repository<UsersVO, Long> {

    /**
     * Retourne le menu si l'utilisateur a le droit d'y accéder.
     *
     * @param userName le nom de l'utilisateur
     * @param idMenu l'id du menu
     * @return l'id du menu
     */
    @Query(nativeQuery = true, value = "select ID_MENU from V_DROIT_MENU where USER_NOM = :userName"
            + " and ID_MENU = :idMenu")
    Integer findIdMenuExistForUser(@Param("userName") String userName, @Param("idMenu") Integer idMenu);

    /**
     * Find Privilege from table PARAM_HABILITATION by ID.
     *
     * @param idHabilitation the id habilitation
     * @return {@link Long} 15:54:12 by hbenizid
     */
    @Query(value = "SELECT count(ID_HABILIT) FROM PARAM_HABILITATION WHERE ID_HABILIT = :idHabilitation ",
            nativeQuery = true)
    Long findHabilitationById(@Param("idHabilitation") Integer idHabilitation);

    /**
     * find F_Droit_Habilit from Dual by params.
     *
     * @param idHabilitation the id habilitation
     * @param idOrganisme    the id organisme
     * @param idUser         the id user
     * @param useNewHabil    0 pour prendre en compte l'ancien système d'habilitation 1 pour le nouveau
     * @return {@link Long} 16:05:28 by hbenizid
     */
    @Query(value = "SELECT f_droit_habilit (:idHabilitation,:idOrganisme, :idUser, :useNewHabil) from dual ", nativeQuery = true)
    Long findFDroitHabilitByParms(@Param("idHabilitation") Integer idHabilitation, @Param("idOrganisme") Integer idOrganisme,
                                  @Param("idUser") Long idUser, @Param("useNewHabil") Integer useNewHabil);

    /**
     * Create User
     *
     * @param nom            the nom
     * @param motDePasse     the mot de passe
     * @param listeOrganisme the liste organisme
     *                       <p>
     *                       26 mars 2018 - 17:57:16 by mbhouas
     */
    @Procedure(name = "Create_User")
    void CreateUser(@Param("Nom") String nom, @Param("MDP") String motDePasse,
                    @Param("liste_org") String listeOrganisme);

    /**
     * Find MAX ID_USER
     *
     * @return {@link Long}
     * <p>
     * 28 mars 2018 - 10:59:56 by mbhouas
     */
    // FIXME Chantier changement de nom de table ALL_USERS_APP
    @Query(value = "select MAX(ID_USER) from ALL_USERS_MUTIX", nativeQuery = true)
    Long findMaxId_User();

    /**
     * Alter User
     *
     * @param nom            the nom
     * @param listeOrganisme the listeOrganisme
     *                       <p>
     *                       28 mars 2018 - 15:25:24 by mbhouas
     */
    @Procedure(name = "Alter_User")
    void AlterUser(@Param("Nom") String nom, @Param("liste_org") String listeOrganisme);

    /**
     * Drop user.
     *
     * @param nom the nom
     *            <p>
     *            28 mars 2018 - 15:52:29 by mbhouas
     */
    @Procedure(name = "Drop_User")
    void DropUser(@Param("Nom") String nom);

    /**
     * get blocked users
     *
     * @return {@link String}
     * <p>
     * 25 avr. 2018 - 17:20:02 by asus
     */
    @Query(value = "select username from dba_users where lock_date is not null", nativeQuery = true)
    List<String> getBlockedUsers();

    /**
     * Gets usernames for the open Status
     *
     * @return {@link String}
     */
    @Query(value = "select username from dba_users where account_status ='OPEN' ", nativeQuery = true)
    List<String> getUnBlockedUsers();

    /**
     * get Connected users
     *
     * @return {@link String}
     * <p>
     * 25 avr. 2018 - 17:20:02 by asus
     */
    // FIXME Chantier de changement de nom de la table ALL_USERS_APP
    @Query(value = "select username from v$session, all_users_mutix where username = USER_NOM", nativeQuery = true)
    List<String> getConnectedUsers();


    /**
     * get  date modification paswword.
     *
     * @param userNom      the  user nom
     * @param userPassword the user password
     * @return {@link Date}
     */
    // FIXME Chantier de changement de nom de la table ALL_USERS_APP
    @Query(value = "SELECT USER_LAST_CON FROM all_users_mutix  WHERE USER_NOM = :userNom AND USER_PWD = :userPassword", nativeQuery = true)
    Date getDateLastConnection(@Param("userNom") String userNom, @Param("userPassword") String userPassword);

    /**
     * get  All Ancienne Valeur Admin
     *
     * @return {@link String}
     */
    @Query(value = "SELECT Ancienne_Valeur_Admin FROM  HEVEN_ADMIN", nativeQuery = true)
    List<String> getAllAncienneValeurAdmin();

    /**
     * get  date modification paswword.
     *
     * @param userNom      the  user nom
     * @param userPassword the user password
     * @return {@link Date}
     */
    // FIXME Chantier de changement de nom de la table ALL_USERS_APP
    @Query(value = "SELECT USER_DATE_MOD_PWD FROM all_users_mutix u WHERE USER_NOM = :userNom AND USER_PWD = :userPassword", nativeQuery = true)
    Date getDateModifPwd(@Param("userNom") String userNom, @Param("userPassword") String userPassword);

    /**
     * update expired user password.
     * @param userNom      the user name
     */
    @Modifying
    // FIXME Chantier de changement de nom de la table ALL_USERS_APP
    @Query(value = "UPDATE all_users_mutix SET USER_DATE_MOD_PWD = SYSDATE WHERE USER_NOM = :userNom", nativeQuery = true)
    void updatePwd(@Param("userNom") String userNom);

    /**
     * get password delay
     *
     * @param libelle the client commentaire
     * @return {@link int}
     */
    @Query(value = "SELECT VALEUR from client  WHERE  CLIENT_COMMENTAIRE = :libelle", nativeQuery = true)
    int getValidity(@Param("libelle") String libelle);


    /**
     * get last_date_modif_admin
     *
     * @param libelle ancienne valeur admin
     * @return {@link Date}
     */
    @Query(value = "SELECT max (HEVEN_ADMIN_DATE) from HEVEN_ADMIN  WHERE  ANCIENNE_VALEUR_ADMIN like :libelle||'%'", nativeQuery = true)
    Date getLastDateModifAdmin(@Param("libelle") String libelle);

    /**
     * get last_date_modif_user
     *
     * @param libelle heven admin libelle
     * @return {@link Date}
     */
    @Query(value = "SELECT max (HEVEN_ADMIN_DATE) from HEVEN_ADMIN  WHERE HEVEN_ADMIN_LIB = :libelle", nativeQuery = true)
    Date getLastDateModifUser(@Param("libelle") String libelle);

    /**
     * update table droit agence with the new userName
     *
     * @param oldUserNom the oldUserNom
     * @param userNom    the new UserNom
     */
    @Query(value = "update DROITAGENCE set USER_NOM = :userNom where  USER_NOM = :oldUserNom", nativeQuery = true)
    void updateDroitAgence(@Param("oldUserNom") String oldUserNom, @Param("userNom") String userNom);


    /**
     * getUserByUserName
     * @param userName userName
     * @return {@link String}
     */
    @Query(value = "select ACCOUNT_STATUS from dba_users where dba_users.USERNAME LIKE  ?1 ", nativeQuery = true)
    String getUserByUserName(String userName);


    /**
     * get lock date by user name
     * @param userName the username
     * @return lock date
     */
    @Query(value = "select lock_date from dba_users where dba_users.USERNAME = :userName", nativeQuery = true)
    Date getLockDateByUserName(@Param("userName") String userName);

    /**
     * fill Table User Requete
     * @param selection the type of user selected
     */
    @Modifying
    @Query(value = "insert into USER_REQUETE (id_requete, user_nom) select distinct GR.id_requete, U.user_nom from GROUPE_REQUETE GR, GROUPE_UTILISATEUR GU," +
            " ALL_USERS_MUTIX U, dba_users where GR.id_liste_groupe_utilisateur = GU.id_liste_groupe_utilisateur and GU.id_user = U.id_user and U.user_nom <> 'MUTIX'" +
            " and UPPER(username) = UPPER(USER_NOM) and ((ACCOUNT_STATUS='OPEN' and :selection in (1,2)) or (ACCOUNT_STATUS<>'OPEN' and :selection in (1,3))) " +
            "and (U.USER_MODELE = 1 OR ((U.USER_MODELE = 0 or U.USER_MODELE is null) and U.ID_USER_MODELE is null)) order by U.user_nom", nativeQuery = true)
    void fillTableUserRequete(@Param("selection") Integer selection);

    /**
     * fill Table User Menu
     *
     * @param selection the type of user selected
     */
    @Modifying
    @Query(value = "insert into USER_MENU (id_menu, user_nom) select distinct gm.id_menu, U.user_nom " +
            " from MUTIX.GM_GROUPE_UTILISATEUR gmgp ,MUTIX.GROUPE_METIER gp , MUTIX.GM_MENU gm, GROUPE_UTILISATEUR GU, ALL_USERS_MUTIX U, dba_users" +
            " where gmgp.id_groupe_metier = gp.id_groupe_metier " +
            " and gp.id_groupe_metier = gm.id_groupe_metier " +
            " and  gmgp.id_liste_groupe_utilisateur = GU.id_liste_groupe_utilisateur " +
            " and GU.id_user = U.id_user and U.user_nom <> 'MUTIX'" +
            " and UPPER(username) = UPPER(USER_NOM) and ((ACCOUNT_STATUS='OPEN' and :selection in (1,2)) or (ACCOUNT_STATUS<>'OPEN' and :selection in (1,3))) " +
            " and (U.USER_MODELE = 1 OR ((U.USER_MODELE = 0 or U.USER_MODELE is null) and U.ID_USER_MODELE is null)) order by U.user_nom", nativeQuery = true)
    void fillTableUserMenu(@Param("selection") Integer selection);

    /**
     * Recuperate libelle menu string.
     *
     * @param separator the separator
     * @param val   the value of line of code
     * @param libelle   the libelle
     * @return the string
     */
    @Query(value = "select lpad(:val, 4, '0') || :separator || replace(:libelle,'~','') from dual", nativeQuery = true)
    String recuperateLibelleMenu(@Param("val") Integer val, @Param("separator") String separator, @Param("libelle") String libelle);

    /**
     * Get data for agence tab
     * @param listUserName list users
     * @return Get data for agence tab
     */
    @Query(value = "select A.user_nom    ,  B.ID_ORG || '-' || B.ID_AGC  , '0' from all_users_mutix  A , agence B " +
            "where not EXISTS (select 1 from DROITAGENCE  " +
            "where  A.USER_NOM  = DROITAGENCE.USER_NOM  and B.ID_AGC = DROITAGENCE.ID_AGC) " +
            "and A.user_nom in :listUserName " +
            "Union  " +
            "select A.user_nom    , B.ID_ORG || '-' || B.ID_AGC  , '1' from all_users_mutix  A , agence B " +
            "where   EXISTS (select 1 from DROITAGENCE  " +
            "where  A.USER_NOM  = DROITAGENCE.USER_NOM  and B.ID_AGC = DROITAGENCE.ID_AGC) " +
            "and A.user_nom in :listUserName order by 2 ,1 ", nativeQuery = true)
    List<Object> getAllrecordsDroitAgence(@Param("listUserName") List<String> listUserName);

    /**
     * get details groupe for all users
     * @param listUserName list user_nom
     * @return details groupe for all users
     */
    @Query(value = " select A.user_nom , B.ID_ORG || '-' || B.id_GRP , '1' from all_users_mutix A , grp B " +
            "where   EXISTS (select 1 from droitGroupe " +
            "where A.USER_NOM = droitGroupe.USER_NOM and B.id_GRP = droitGroupe. GRP) " +
            "and A.user_nom in :listUserName Union " +
            "select A.user_nom , B.ID_ORG || '-' || B.id_GRP , '0' from all_users_mutix A , grp B  " +
            "where  not EXISTS (select 1 from droitGroupe " +
            "where A.USER_NOM = droitGroupe.USER_NOM and B.id_GRP = droitGroupe.GRP) " +
            "and not EXISTS (select 1 from droitGroupe_exclus " +
            "where A.USER_NOM = droitGroupe_exclus.USER_NOM and B.id_GRP = droitGroupe_exclus.GRP) " +
            "and A.user_nom in :listUserName union " +
            "select A.user_nom , B.ID_ORG || '-' || B.id_GRP , 'exclue' from all_users_mutix A , grp B  " +
            "where   EXISTS (select 1 from droitGroupe_exclus " +
            "where A.USER_NOM = droitGroupe_exclus.USER_NOM and B.id_GRP = droitGroupe_exclus.GRP) " +
            "and A.user_nom in :listUserName " +
            "order by 2 ,1", nativeQuery = true)
    List<Object> getAllrecordsDroitGroupe(@Param("listUserName") List<String> listUserName);

    /**
     * get details decompteuse for all users
     * @param listUserName list user_nom
     * @return details decompteuse for all users
     */
    @Query(value = "select A.USER_NOM, O.ID_ORG, D.ID_DCSE || ' ' || D.DCSE_NOM , '0' from all_users_mutix A, DCSE D, ORG_DCSE O " +
            "where D.ID_DCSE = O.ID_DCSE and not EXISTS (select 1 from ALL_USERS_MUTIX_ORG_DCSE where A.ID_USER = ALL_USERS_MUTIX_ORG_DCSE.ID_USER and O.ID_ORG = ALL_USERS_MUTIX_ORG_DCSE.ID_ORG " +
            "and (ALL_USERS_MUTIX_ORG_DCSE.id_dcse = D.id_dcse or  ALL_USERS_MUTIX_ORG_DCSE.id_dcse = 'ALL')) " +
            "and A.user_nom in :listUserName " +
            "Union " +
            "select A.USER_NOM, O.ID_ORG, D.ID_DCSE || ' ' || D.DCSE_NOM , '1' from all_users_mutix A , DCSE D, ORG_DCSE O " +
            "where D.ID_DCSE = O.ID_DCSE and EXISTS (select 1 from ALL_USERS_MUTIX_ORG_DCSE where  A.ID_USER = ALL_USERS_MUTIX_ORG_DCSE.ID_USER and  O.ID_ORG = ALL_USERS_MUTIX_ORG_DCSE.ID_ORG and " +
            "(ALL_USERS_MUTIX_ORG_DCSE.id_dcse = D.id_dcse  or  ALL_USERS_MUTIX_ORG_DCSE.id_dcse = 'ALL')) " +
            "and A.user_nom in :listUserName order by 2,3,1", nativeQuery = true)
    List<Object> getAllRecordsDroitDecompteuse(@Param("listUserName") List<String> listUserName);

    /**
     * get details courrier for all users
     * @param listUserName list user_nom
     * @return details courrier for all users
     */
    @Query(value = "select  a.user_nom , nvl(COUR_DEST , '' ) || ' - ' || COUR_NOM  , '1'  , ID_COUR  " +
            "from  all_users_mutix a , cour " +
            "where exists ( select 1 from  GROUPE_UTILISATEUR gu ,  GROUPE_COUR gc " +
            "where gu.ID_USER = a.ID_USER and gu.ID_LISTE_GROUPE_UTILISATEUR = gc.ID_LISTE_GROUPE_UTILISATEUR  and gc.ID_COUR = cour.ID_COUR) and A.user_nom in :listUserName union " +
            "select  a.user_nom    , nvl(COUR_DEST , '' ) || ' - ' || COUR_NOM  , '0' , ID_COUR " +
            "from  all_users_mutix a , cour " +
            "where not exists ( select 1 from  GROUPE_UTILISATEUR gu ,  GROUPE_COUR gc " +
            "where gu.ID_USER = a.ID_USER and gu.ID_LISTE_GROUPE_UTILISATEUR = gc.ID_LISTE_GROUPE_UTILISATEUR  and gc.ID_COUR = cour.ID_COUR) and A.user_nom in :listUserName  union " +
            "select  a.user_nom    , nvl(COUR_DEST , '' ) || ' - ' || COUR_NOM  , '0' , ID_COUR " +
            "from  all_users_mutix a , cour " +
            "where cour.ID_COUR not in  ( select distinct ID_COUR  from  GROUPE_COUR) and A.user_nom in :listUserName  order by 2, 1", nativeQuery = true)
    List<Object> getAllRecordsDroitCourrier(@Param("listUserName") List<String> listUserName);

    /**
     * get details Requete for all users
     *
     * @param listUserName list user_nom
     * @return details Requete for all users
     */
    @Query(value = "select A.user_nom , B. REQ_LIBELLE , '0' from all_users_mutix  A , LISTE_REQUETE B  " +
            "where not EXISTS (select 1 from USER_REQUETE  " +
            "where  A.USER_NOM  = USER_REQUETE.USER_NOM  and B.ID_REQUETE = USER_REQUETE.ID_REQUETE) and  A.user_nom in :listUserName  Union  " +
            "select A.user_nom , B. REQ_LIBELLE   , '1' from all_users_mutix  A , LISTE_REQUETE B " +
            "where   EXISTS (select 1 from USER_REQUETE " +
            "where  A.USER_NOM  = USER_REQUETE.USER_NOM  and B.ID_REQUETE = USER_REQUETE.ID_REQUETE)  " +
            "and  A.user_nom in :listUserName order by 2 ,1 ", nativeQuery = true)
    List<Object> getAllRecordsDroitRequete(@Param("listUserName") List<String> listUserName);

    /**
     * Gets all default Habilitation.
     *
     * @param listUserName the list user name
     * @return the all default Habilitation
     */
    @Query(value = "SELECT a.USER_NOM as USER_NOM , 'DEFAUT - '|| ph.LIBELLE as LIBELLE, max(g.VALEUR) as VALEUR " +
            "FROM ALL_USERS_MUTIX a, GROUPE_UTILISATEUR gu, LISTE_GROUPE_UTILISATEUR lgu, GROUPE_HABILITATION g, PARAM_HABILITATION ph " +
            "WHERE g.ID_ORG = 0 and a.user_nom in :listUserName and a.ID_USER = gu.ID_USER and ph.ID_HABILIT = g.ID_HABILIT " +
            "and gu.ID_LISTE_GROUPE_UTILISATEUR = lgu.ID_LISTE_GROUPE_UTILISATEUR and lgu.ID_LISTE_GROUPE_UTILISATEUR = g.ID_LISTE_GROUPE_UTILISATEUR " +
            "GROUP BY a.USER_NOM, ph.LIBELLE " +
            "UNION " +
            "SELECT a.USER_NOM as USER_NOM , 'DEFAUT - '|| ph.LIBELLE as LIBELLE , '0' " +
            "FROM ALL_USERS_MUTIX a,  PARAM_HABILITATION ph " +
            "WHERE NOT EXISTS (select 1  from GROUPE_UTILISATEUR " +
            "WHERE GROUPE_UTILISATEUR.ID_LISTE_GROUPE_UTILISATEUR in (select distinct  ID_LISTE_GROUPE_UTILISATEUR from groupe_habilitation ) " +
            "and a.ID_USER = GROUPE_UTILISATEUR.ID_USER) " +
            "and a.USER_NOM in :listUserName ORDER BY 2, 1 ", nativeQuery = true)
    List<Object> getAllDefaultHabilitation(@Param("listUserName") List<String> listUserName);

    /**
     * Gets all Habilitation related to org.
     *
     * @param listUserName the list user name
     * @param idOrg the id of organisme
     * @return the all Habilitation related to org
     */
    @Query(value = "SELECT a.USER_NOM as USER_NOM, ph.LIBELLE as LIBELLE, max(g.VALEUR) as VALEUR " +
            "FROM ALL_USERS_MUTIX a, GROUPE_UTILISATEUR gu, LISTE_GROUPE_UTILISATEUR lgu, GROUPE_HABILITATION g, PARAM_HABILITATION ph " +
            "WHERE g.ID_ORG = :idOrg and a.USER_NOM in :listUserName and a.ID_USER = gu.ID_USER and ph.ID_HABILIT = g.ID_HABILIT " +
            "and gu.ID_LISTE_GROUPE_UTILISATEUR = lgu.ID_LISTE_GROUPE_UTILISATEUR and lgu.ID_LISTE_GROUPE_UTILISATEUR = g.ID_LISTE_GROUPE_UTILISATEUR " +
            "and  ph.org = 1 GROUP BY a.USER_NOM, ph.LIBELLE " +
            "UNION " +
            "SELECT a.USER_NOM, PARAM_HABILITATION.LIBELLE, '  ' FROM ALL_USERS_MUTIX a, PARAM_HABILITATION " +
            "WHERE a.USER_NOM in :listUserName and PARAM_HABILITATION.org = 1 " +
            "ORDER BY 2, 1 ", nativeQuery = true)
    List<Object> getAllHabilitationRelatedToOrg(@Param("listUserName") List<String> listUserName, @Param("idOrg") Integer idOrg);

    /**
     * Permet de savoir si l'utilisateur est habilité à la prévoyance
     * @param username {@link String} Le nom de l'utilisateur à vérifier
     * @return {@link Boolean} true si l'utilisateur est habilité
     */
    @Query(value = "SELECT CASE WHEN count(u) > 0 THEN true ELSE false END FROM UsersVO u WHERE u.userNom = :username AND u.habilitationPrev = true")
    Boolean isHabiliteForPrev(@Param("username") String username);

    /**
     * Retourne le nombre de tentatives de connexion en échec d'un utilisateur.
     * Valeur remise à 0 après que l'utilisateur se soit connecté avec le bon login et mot de passe.
     * @param username le nom d'utilisateur
     * @return le nombre de tentatives de connexion en echec
     */
    @Query(value = "select lcount from SYS.USER$ where name=:username", nativeQuery = true)
    Integer getNumberOfInvalidLoginAttempts(@Param("username") String username);

    /**
     * Permets de savoir avec quel moyen de connexion l'utilisateur souhaite se connecter
     * @param username {@link String} Le nom de l'utilisateur à rechercher
     * @return {@link String} Le moyen de connexion
     */
    @Query(value = "SELECT TYPE_CONNEXION From ALL_USERS_MUTIX where USER_NOM like :username", nativeQuery = true)
    String moyenConnexion(@Param("username") String username);
}
