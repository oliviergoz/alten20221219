/*
 * Copyright Owliance © 2016 - 2018 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.constants;

/**
 * Classe contenant toutes les constantes pour les URLs
 */
public class OwlinkURLConstants {

    /**
     * Authentification.
     */
    public static final String LOGOUT_URL = "/api/oauth/revoke-token";

    /**
     * Endpoint racine de l'api
     */
    public static final String ROOT_ENDPOINT = "/api";

    /**
     * URL racine Acte remboursement
     */
    public static final String ACTE_REMBOURSEMENT_ENDPOINT_ROOT = "/api/acteRemboursement";

    /**
     * URL du service permettant de récupérer les formules pour le sinistre salaire
     */
    public static final String ACTE_REMBOURSEMENT_ENDPOINT_GET_FORMULES_FOR_SINISTRE_SALAIRE = "/getFormulesForSinistreSalaire";

    /**
     * URL du service permettant de récupérer l'acte de remboursement
     */
    public static final String ACTE_REMBOURSEMENT_ENDPOINT_GET_ACTRBT_BY_ACTE_AND_RISQUE = "/getActRbtByActeAndRisque";

    /**
     * URL du service permettant de récupérer l'acte de remboursement selon l'organisme, le produit, l'option, et l'acte
     */
    public static final String ACTE_REMBOURSEMENT_ENDPOINT_GET_ACTRBT_BY_ACTE_AND_OPTION = "/getActRbtByActeAndOption";
}
