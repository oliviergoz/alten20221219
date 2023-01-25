/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.constants;

/**
 * Java 5 enumeration of Owlink error codes.
 *
 * @author hbouslah
 * @see com.owliance.owlink.framework.constants
 *
 * <p>
 * Created : 11 août 2016
 * <p>
 * Updated : 11 août 2016 by hbouslah (version 0.1.6-Alpha)
 * <p>
 * Updated : 22 août 2016 by hbenizid (version 0.2.0-Alpha)
 * @since 0.1.6-Alpha
 */
public enum OwlinkError {

    /**
     * ***************************************** Technical Errors
     * *****************************************.
     */

    /**
     * {@code OW10001 Invalid Parameter}.
     */
    INVALID_PARAMETER("OW10001", "Invalid Parameter"),

    /**
     * {@code OW10002 Invalid URL}.
     */
    INVALID_URL("OW10002", "Invalid URL"),

    /**
     * {@code OW10003 Invalid Data}.
     */
    INVALID_DATA("OW10003", "Invalid Data"),

    /**
     * {@code OW10004 Data not found}.
     */
    DATA_NOT_FOUND("OW10004", "Data not found"),

    /**
     * {@code OW10005 Data Integrity violated}.
     */
    DATA_INTEGRITY_VIOLATED("OW10005", "Data Integrity violated"),

    /**
     * {@code OW10006 Wrong or missed Parameter}.
     */
    WRONG_MISSED_PARAMETER("OW10006", "Wrong or missed Parameter"),

    /**
     * {@code OW10007 Parameter Type Mismatch}.
     */
    PARAMETER_TYPE_MISMATCH("OW10007", "Parameter Type Mismatch"),

    /**
     * {@code OW10008 Parameter Type Mismatch}.
     */
    CREATION_ERROR("OW10008", "Error Occured While Creation"),

    /**
     * {@code OW10009 Parameter Type Mismatch}.
     */
    UPDATE_ERROR("OW10009", "Error Occured While Update"),

    /**
     * {@code OW10010 Parameter Type Mismatch}.
     */
    DELETE_ERROR("OW10010", "Error Occured While Delete"),

    /**
     * {@code OW10011 Parameter Type Mismatch}.
     */
    SQL_ERROR_OCCURED("OW10011", "SQL Exception occured .."),

    /**
     * {@code OW10012 Parameter security}.
     */
    USER_NOT_ALLOWED("OW10012", "User is not allowed to "),

    /**
     * {@code OW10013 Parameter security}.
     */
    UPDATE_RATTACHEMENT_ANO_COTIS("OW10013", "La mise à jour de l'affichage des individus en anomalie n'a pas fonctionnée. Vos modifications sont annulées."),
    /**
     * {@code OW10014 Parameter Type Mismatch}.
     */
    DELETE_PARTENAIRE_ERROR("OW10014", "Suppression impossible, ce partenaire est assimilé à un chargement"),

    /**
     * {@code OW10015 Parameter Type Mismatch}.
     */
    DELETE_TIERS_ERROR("OW10015", "Suppression impossible, ce tiers est utilisé dans un traitement"),

    /**
     * {@code 28000 Parameter Type Mismatch}.
     */
    LOCK_ACCOUNT_ERROR("28000", "Compte verrouille"),

    /**
     * ***************************************** Functional Errors
     * *****************************************.
     */

    /**
     * {@code OW20001 Existing Bank Reference}.
     */
    EXISTING_BANK_REFERENCE("OW20001", "Bank Reference Already Exists"),

    /**
     * {@code OW20002 Existing Produit for Groupe and College}.
     */
    EXISTING_PRODUIT_FOR_GROUPE_COLLEGE("OW20002", "Produit Already Exists for Groupe/College"),

    /**
     * {@code OW20003 Existing Certification}.
     */
    EXISTING_CERTIFICATION_AY("OW20003", "Certification Already Exists"),

    /**
     * {@code OW20004 Existing ProduitImpossible to delete Produit, one or more remise Commerciale are affected to this
     * Produit} .
     */
    DELETE_PRODUIT_ERROR1("OW20004", "Impossible to delete Produit, one or more remise Commerciale are affected to this Produit"),

    /**
     * {@code OW20005 Impossible to generate automatically Famille code, ,no dep is configured} .
     */
    ENABLE_TO_AUTOGENERATE_FAMILLE_CODE("OW20005", "Impossible to generate automatically Famille code, ,no dep is configured"),

    /**
     * {@code OW20006 Could not create or update an event of type Marketing in management} .
     */
    IMPOSSIBLE_TO_MANAGE_MARKETING_EVENT("OW20006", "Could not create or update an event of type Marketing in management"),

    /**
     * {@code OW20007 Input date is invalid} .
     */
    INVALID_DATE("OW20007", "Invalid Date"),

    /**
     * {@code OW20008 Could not update Produit Famille} .
     */
    IMPOSSIBLE_TO_UPDATE_PRODUIT_FAMILLE("OW20008", "Could not update Produit Famille"),
    /**
     * {@code OW20009 Could not Delete Mouvement guichet} .
     */
    IMPOSSIBLE_TO_DELETE_MOUVEMENT_GUICHET("OW20009", "Could not Delete Mouvement guichet"),

    /**
     * {@code OW20010 Chosen Ayant droit is not principal} .
     */
    AYANT_DROIT_IS_NOT_PRINCIPAL("OW20010", "Chosen Ayant droit is not principal"),

    /**
     * {@code OW20011 Ayant droit is not allowed to noemie 408} .
     */
    AYANT_DROIT_IS_ALLOWED_TO_NOEMIE_408("OW20011", "Ayant droit is not allowed to noemie 408"),

    /**
     * {@code OW20012 Existing Bank Reference}.
     */
    EXISTING_AYRP_REFERENCE("OW20012", "Ayant droit RP Already Exists"),

    /**
     * {@code OW20013 Existing Bank Reference}.
     */
    INVALID_PERIOD_RO("OW20013", "Period Ro are not valid"),

    /**
     * {@code OW20014 Existing Bank Reference}.
     */
    MOUVEMENT408_ALREADY_CANCELED("OW20014", "Could not update canceled Mouvement408"),
    /**
     * {@code OW20015 Existing Bank Reference}.
     */
    NO_ASSOCIATED_MOUVEMENT408_FOUND("OW20015", "There is no mouvement408 associated to selected Ayant Droit"),

    /**
     * {@code OW20016 Existing Bank Reference}.
     */
    MOUVEMENT408_IS_NOT_THELAST("OW20016", "Chosen Mouvement408 is not the last one for the selected Ayant Droit"),

    /**
     * {@code OW20017 Existing Bank Reference}.
     */
    INVALID_ASSURE_AND_AYANT_DROIT("OW20017", "Passed list ayant droits are not valid, need to pass an Assure Principal and an ayant Droit that correspond to it"),

    /**
     * {@code OW20018 Existing Bank Reference}.
     */
    INVALID_CODE_FORCAGE("OW20018", "The new movement408 Code should be different to the original one to proceed the forcage"),

    /**
     * {@code OW20019 Period Regime Obligatoire AYANT DROIT are not valid} .
     */
    INVALID_PERIOD_RO_AYANT_DROIT("OW20019", "Period RO AYANT DROIT are not valid"),

    /**
     * {@code OW20020 Could not Delete RO} .
     */
    IMPOSSIBLE_TO_DELETE_AYANTDROIT_RO("OW20020", "Could not Delete Ayant Droit RO , nbr is less than 1"),

    /**
     * {@code OW20021} while deleting option produit
     */
    OPTION_PRODUIT_ERROR_DELETE_EXIST_LABELISATION("OW20021", "Labelisation exist for option produit"),


    /**
     * {@code OW20700} create GPROD_REGLT
     */
    GPROD_REGLT_PRL_MANDAT_EXISTANT("OW20700", "Le mandat existe déja pour le produit et l'IBAN"),
    /**
     * {@code OW20705} create GPROD_REGLT
     */

    GPROD_REGLT_PRL_MANDAT_EXISTANT_NON_VALIDE("OW20705", "Le mandat existe déja pour le produit et l'IBAN mais non valide"),
    /**
     * GPROD_REGLT_NO_MANDAT
     */
    GPROD_REGLT_NO_MANDAT("OW20704", "Aucun mandat n'existe pour le groupe, le produit SANTE et l'IBAN"),

    /**
     * INSEE_SERVICE_OFFLINE
     */
    INSEE_SERVICE_OFFLINE("OW20706", "Impossible de se connecter au service INSEE "),

    /**
     * INSEE_SIRET_NOT_FOUND
     */
    INSEE_ELEMENT_NOT_FOUND("OW20707", "Erreur indiquée par le service INSEE"),
    /**
     * RESILIATION_NO_RADIATION_AUTO_FOUNDED
     */
    RESILIATION_NO_RADIATION_AUTO_FOUNDED("OW20708", "Aucun Radiation AUTO  avec cet ID"),
    /**
     * RESILIATION_P_AUTO_RADIER_EXEC_ERROR
     */
    RESILIATION_P_AUTO_RADIER_EXEC_ERROR("OW20709", "ERROR occured while executing PCK p_auto_radier"),
    /**
     * {@code OW10016 Parameter Type Mismatch}.
     */
    DELETE_TIERS_NOE_ERROR("OW10016", "Suppression impossible, impossible de supprimer ce tiers noe"),

    /**
     * RGPD_FILE_NOT_FOUND
     */
    RGPD_FILE_NOT_FOUND("OW20710", "Le fichier est introuvable");
    /**
     * The code.
     */
    private final String code;

    /**
     * The reason.
     */
    private final String reason;

    /**
     * intiate a new OwlinkError
     *
     * @param code   the code
     * @param reason the reason
     */
    OwlinkError(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {

        return code;
    }

    /**
     * Gets the reason.
     *
     * @return the reason
     */
    public String getReason() {

        return reason;
    }

}
