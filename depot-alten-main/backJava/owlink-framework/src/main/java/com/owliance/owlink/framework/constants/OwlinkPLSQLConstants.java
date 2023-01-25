package com.owliance.owlink.framework.constants;

import java.io.Serializable;

/**
 * Classe contenant toutes les constante de PLSQL
 * (Nom des packages, fonctions et paramètres des procédures)
 *
 * @author crano
 * Created : 21 jan 2021
 */
public class OwlinkPLSQLConstants implements Serializable {

    /**
     * La constante SerialVersionId générée automatiquement.
     */
    private static final long serialVersionUID = -6160765310118818384L;

    /*** PACKAGES COMMISSION ***/

    /**
     * Nom du package de la procédure qui gère les valeurs par défaut du paramètre du commissionnement
     */
    public static final String PCK_COMMISSION_PARAM = "PCK_COMMISSION_PARAM";

    /**
     * Nom de la procédure qui remplit automatiquement les structeres Valeurs et Partenariat
     */
    public static final String P_GENERER_COMM_COMP = "P_GENERER_COMM_COMP";

    /**
     * Nom de la fonction PLSQL qui récupère les paramètres
     * Dépend du package PCK_COMMISSION_PARAM
     */
    public static final String F_GET_PARAM = "F_GET_PARAM";

    /**
     * Nom de la fonction PLSQL qui récupère les paramètres en Id
     * Dépend du package PCK_COMMISSION_PARAM
     */
    public static final String F_GET_PARAM_ID = "F_GET_PARAM_ID";

    /**
     * L'Id GProd qui est l'identifiant du Groupe/Produit/Collège
     * A partir de la fonction F_GET_PARAM et F_GET_NEW_CODE_TARIF_FOR_AVENANT
     */
    public static final String P_ID_GPROD = "P_ID_GPROD";

    /**
     * L'id du flux qui vient d'être créé.
     */
    public static final String P_ID_COMM_PARAM_FLUXFP_MOD = "P_ID_COMM_PARAM_FLUXFP_MOD";

    /**
     * Nom de la table de paramètrage à récupérer
     * Pour la fonction F_GET_PARAM
     */
    public static final String P_PARAM_TABLE = "P_PARAM_TABLE";

    /**
     * Nom du paramètre à récupérer
     * Pour la fonction F_GET_PARAM
     */
    public static final String P_PARAM_NAME = "P_PARAM_NAME";

    /**
     * Nom du paramètre optionnel pour savoir sur quel flux on se trouve
     * Pour la fonction F_GET_PARAM
     */
    public static final String P_PARAM_AUXILIAIRE = "P_PARAM_AUXILIAIRE";

    /*** PARAMETRES PARTENAIRES ***/

    /**
     * Nom de la table pour les paramètre Partenaire
     */
    public static final String COM_PARAM_PARTENAIRE = "COM_PARAM_PARTENAIRE";

    /**
     * Nom du paramètre utilisé pour récupérer le numéro de contrat
     * A partir de la table Partenaire et la fonction F_GET_PARAM
     */
    public static final String NUMERO_CONTRAT = "NUMERO_CONTRAT";

    /**
     * Nom du paramètre utilisé pour récupérer le numéro externe
     * A partir de la table Partenaire et la fonction F_GET_PARAM
     */
    public static final String NUMERO_EXTERNE = "NUMERO_EXTERNE";

    /**
     * Nom du paramètre utilisé pour récupérer le numéro sous externe
     * A partir de la table Partenaire et la fonction F_GET_PARAM
     */
    public static final String NUMERO_SOUS_EXTERNE = "NUMERO_SOUS_EXTERNE";

    /*** PARAMETRES MODELE ***/

    /**
     * Nom de la table pour les paramètre Modèle
     */
    public static final String COM_PARAM_MODELE = "COM_PARAM_MODELE";

    /**
     * Nom du paramètre utilisé pour récupérer le libellé du modèle
     * A partir de la table Modèle et la fonction F_GET_PARAM
     */
    public static final String MODELE_LIBELLE = "LIBELLE";

    /*** PARAMETRES FLUX ***/

    /**
     * Nom de la table pour les paramètre Flux
     */
    public static final String COM_PARAM_FLUX = "COM_PARAM_FLUX";

    /**
     * Nom du paramètre utilisé pour récupérer le libellé du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String FLUX_LIBELLE = "LIBELLE";

    /**
     * Nom du paramètre utilisé pour récupérer la date de début du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String DATE_DEBUT = "DATE_DEBUT";

    /**
     * Nom du paramètre utilisé pour récupérer le produit du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String PRODUIT = "PRODUIT";

    /**
     * Nom du paramètre utilisé pour récupérer la part du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String PART = "PART";

    /**
     * Nom du paramètre utilisé pour récupérer
     * le niveau de garantie du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String NIV_GARANTIE = "NIV_GARANTIE";

    /**
     * Nom du paramètre utilisé pour récupérer la garantie du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String GARANTIE = "GARANTIE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * la valeur linéaire du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String LINEAIRE = "LINEAIRE";

    /**
     * Nom du paramètre utilisé pour récupérer  du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String PRECOMPTE = "PRECOMPTE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * la valeur du précompte du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String REP_PRECOMPTE = "REP_PRECOMPTE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * la reprise linéaire du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String REP_LINEAIRE = "REP_LINEAIRE";

    /**
     * Nom du paramètre utilisé pour récupérer le type d'âge du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String TYPE_AGE = "TYPE_AGE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * le type d'âge chute du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String TYPE_AGE_CHUTE = "TYPE_AGE_CHUTE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * le type d'amorçage du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String TYPE_AMORT = "TYPE_AMORT";

    /**
     * Nom du paramètre utilisé pour récupérer
     * le type date partenaire du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String TYPE_DATE_PARTENAIRE = "TYPE_DATE_PARTENAIRE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * l'assistance incluse du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String ASSIS_INCLUS = "ASSIS_INCLUS";

    /**
     * Nom du paramètre utilisé pour récupérer les frais inclus du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String FRAIS_INCLUS = "FRAIS_INCLUS";

    /**
     * Nom du paramètre utilisé pour récupérer les taxes incluses  du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String TAXE_INCLUS = "TAXE_INCLUS";

    /**
     * Nom du paramètre utilisé pour récupérer
     * les règles de gestion exclues du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String REG_GEST_EXCLUE = "REG_GEST_EXCLUE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * la valeur de forçage du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String FORC_AFFAIRE_NOUVELLE = "FORC_AFFAIRE_NOUVELLE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * le calcul après reprises du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String CALC_AP_REPRISE = "CALC_AP_REPRISE";

    /**
     * Nom du paramètre utilisé pour récupérer
     * les commissions fixes au prorata du flux
     * A partir de la table Flux et la fonction F_GET_PARAM
     */
    public static final String COMM_FIXE_PRORATA = "COMM_FIXE_PRORATA";

    /*** PACKAGE CONTROLE PARAMETRAGE GPROD ***/

    /**
     * Package qui gère les contrôles associés au paramètrage du Gprod
     */
    public static final String PCK_CONTROLE_GPROD = "PCK_CONTROLE_GPROD";

    /*** PACKAGE META MODELE ***/

    /** Nom du package qui gère les meta données. */
    public static final String PCK_META_MODELE = "PCK_META_MODELE";

    /** Nom de la procédure permettant de récupérer les meta acces */
    public static final String P_GET_META_ACCES = "P_GET_META_ACCES";

    /** Nom de la variable pour l'identifiant de la fenêtre */
    public static final String P_ID_FEN = "P_ID_FEN";

    /** Nom de la variable pour l'identifiant unique de la table maître */
    public static final String P_ID_UNIQUE = "P_ID_UNIQUE";

    /** Nom de la variable de retour de la procédure P_GET_META_ACCES */
    public static final String P_META_ACCES = "P_META_ACCES";

    /** Nom de la variable en cas d'erreur renvoyé par la procédure. */
    public static final String P_MSG_ERR = "P_MSG_ERR";

    /** Nom du type custom sql META_ACCES */
    public static final String T_META_ACCES_TAB = "T_META_ACCES_TAB";

    /** Nom de la procédure permettant de récupérer les meta groupes */
    public static final String P_GET_META_GROUPES = "P_GET_META_GROUPES";

    /** Nom de la variable pour l'identifiant du meta acces */
    public static final String P_ID_ACCES = "P_ID_ACCES";

    /** Nom de la variable de retour de la procédure P_GET_META_GROUPES */
    public static final String P_META_GROUPES = "P_META_GROUPES";

    /** Nom du type custom sql du META_GROUPE*/
    public static final String T_META_GROUPE_TAB = "T_META_GROUPE_TAB";

    /** Nom de la procédure permettant de récupérer les meta données */
    public static final String P_GET_METADATA = "P_GET_METADATA";

    /** Nom de la procédure permettant de mettre à jour les meta données */
    public static final String P_SET_META_DATA_FROM_OWLINK_WEB = "P_SET_META_DATA_FROM_OWLINK_WEB";

    /** Nom de la variable pour l'identifiant du meta groupe */
    public static final String P_ID_GROUPE = "P_ID_GROUPE";

    /** Nom de la variable de retour de la procédure P_GET_METADATA */
    public static final String P_META_DATA = "P_META_DATA";

    /** Nom du type custom sql du META_DATA*/
    public static final String T_META_DATA_TAB = "T_META_DATA_TAB";

    /** Nom du type custom T_META_DATA_REC*/
    public static final String T_META_DATA_REC = "T_META_DATA_REC";

    /** Nom du paramètre custom sql du P_META_DATA_TAB*/
    public static final String P_META_DATA_TAB = "P_META_DATA_TAB";

    /** Nom de la variable pour l'identifiant de groupe option */
    public static final String P_ID_GRPOPT = "P_ID_GRPOPT";

    /**
     * Nom de la fonction PLSQL qui controle les options
     * Exist dans le package PCK_CONTROLE_GPROD
     */
    public static final String F_CONTROLE_OPTION = "F_CONTROLE_OPTION";

    /**
     * Nom du package PCK_AVN_TARIFAIRE
     */
    public static final String PCK_AVN_TARIFAIRE = "PCK_AVN_TARIFAIRE";

    /**
     * Nom de la fonction PLSQL qui calcule le nouveau code tarif pour les avenants tarifaires
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String F_AVN_TARIFAIRE_NOM_TARIF = "F_AVN_TARIFAIRE_NOM_TARIF";

    /**
     * L'Id Tarif qui est l'identifiant du tarif
     * A partir de la fonction F_GET_NEW_CODE_TARIF_FOR_AVENANT
     */
    public static final String P_ID_TARIF = "P_ID_TARIF";

    /**
     * L'Id Tarif qui est l'identifiant du tarif
     * A partir de la fonction P_VENTILATION_TARIF_ADC
     */
    public static final String P_ID_TARIF_CREER = "p_id_tarif_creer";

    /**
     * Nom de la fonction PLSQL qui récupère le dernier tarif pour un grpopt
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String F_TROUVER_DERNIER_TARIF = "F_TROUVER_DERNIER_TARIF";

    /**
     * Nom de la procédure PLSQL qui ventile un avenant tarifaire sur les ADC
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String P_VENTILATION_TARIF_ADC = "P_VENTILATION_TARIF_ADC";

    /**
     * Nom de la procédure PLSQL qui supprime un avenant tarifaire
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String P_SUPP_AVN_TARIFAIRE = "P_SUPP_AVN_TARIFAIRE";

    /**
     * L'Id Tarif qui est l'identifiant du tarif
     * A partir de la fonction F_GET_NEW_CODE_TARIF_FOR_AVENANT
     */
    public static final String P_ID_DATTAR = "p_id_dattar";

    /**
     * L'Id Tarif qui est l'identifiant du tarif
     * A partir de la fonction F_GET_NEW_CODE_TARIF_FOR_AVENANT
     */
    public static final String P_COEFF_APPLI = "p_coeff_appli";

    /**
     * Coefficient précédent
     */
    public static final String P_COEFF_PREC = "p_coeff_prec";

    /**
     * Nom de la procédure PLSQL qui modifie un avenant tarifaire
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String P_MODIF_AVN_TARIFAIRE = "P_MODIF_AVN_TARIFAIRE";

    /**
     * Nom de la procédure PLSQL qui crée un avenant tarifaire
     * Dépend du package PCK_AVN_TARIFAIRE
     */
    public static final String P_CREER_AVN_TARIFAIRE = "P_CREER_AVN_TARIFAIRE";

    /**
     * L'identifiant du date tarif initial
     * A partir de la procédure P_CREER_AVN_TARIFAIRE
     */
    public static final String P_ID_DATTAR_INI = "p_id_dattar_ini";

    /**
     * Le code du nouveau tarif
     * A partir de la procédure P_CREER_AVN_TARIFAIRE
     */
    public static final String P_NOM_TARIF = "p_nom_tarif";

    /**
     * La date d'effet de l'avenant tarifaire
     * A partir de la procédure P_CREER_AVN_TARIFAIRE
     */
    public static final String P_DATE_EFFET = "p_date_effet";

    /**
     * L'identifiant de la cause de l'avenant tarifaire
     * A partir de la procédure P_CREER_AVN_TARIFAIRE
     */
    public static final String P_ID_CAUSES_AVN_TARIF = "p_id_causes_avn_tarif";

}
