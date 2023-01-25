/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.constants;

/**
 * Static Class contains Owlink Messages.
 * @author hbouslah
 * @see com.owliance.owlink.framework.common
 *
 * <p>
 * Created : 19 août 2016
 * <p>
 * Updated : 22 août 2016 by hbouslah (version 0.1.6-Alpha)
 * <p>
 * Updated : 22 août 2016 by hbenizid (version 0.2.0-Alpha)
 * <p>
 * Updated : 22 Oct. 2016 by lneji (version 0.2.2-Alpha)
 * <p>
 * Updated : 21 déc. 2016 by abayoudh (version 0.3.2-Alpha)
 * @since 0.1.6-Alpha
 */
public final class OwlinkMessages {

    /**
     * private constructor
     */
    private OwlinkMessages() {
        throw new IllegalStateException("OwlinkMessages class");
    }

    /**
     * Retrieving Element From DB.
     */
    public static final String RETRIEVING_ELEMENT_FROM_DB = "Retrieving Element(s) From DB";

    /**
     *
     */
    public static final String USER_NOT_FOUND_OR_BAD_CREDENTIAL = "User not found Or Bad Credentials";
    /**
     *
     */
    public static final String USER_BLOCKED = "ORA-28000: Compte verrouillé.\n";

    /**
     * Indique que l'utilisateur n'est pas autorisé à se connecter à l'application
     */
    public static final String USER_DISABLED = "User disabled";

    /**
     * No Object has been found used for Logging.
     */
    public static final String NOT_FOUND_OBJECT = "No {} has been found ";

    /**
     * No security number has been found.
     */
    public static final String NOT_FOUND_NUM_SS = "No SS number has been found for identifier {} ";

    /**
     *  The lien personne parameter is not active for the organisme tested.
     */
    public static final String LIEN_PERSONNE_INACTIVE = "The lien personne parameter is not active for the beneficiare {} ";

    /**
     * Object already exists.
     */
    public static final String OBJECT_ALREADY_EXISTS = "Element {} already exists.";

    /**
     * Vérifie si l'objet existe avec 1 paramètre.
     */
    public static final String CHECK_OBJECT_EXISTS_IDENTIFIER1 = "Check if {} exists with identifier [{} = {}]";

    /**
     * No Object has been found with identifier [{}] used for Logging.
     */
    public static final String NOT_FOUND_OBJECT_IDENTIFIER1 = "No {} has been found with identifier [{}={}] ";

    /**
     * Date décompte must be greater than date PE
     */
    public static final String DATE_DECOMPTE_INF_DATE_PEC = "Date décompte must be greater than date PEC";

    /**
     * Date décompte must be greater than date PE
     */
    public static final String DECOMPTEUSE_REQUIRED = "Decompteuse required to validate transformation pec devis";

    /**
     * error transforme pec payée
     */
    public static final String ERROR_TRANSFORME = "Error while transforme PEC/DEVIS - ETAT: payé";

    /**
     * error while update borderau
     */
    public static final String ERROR_UPDATE_BORDERAU = "error while updating borderau";

    /**
     * No Object has been found with identifier [{}] used for Logging.
     */
    public static final String NOT_FOUND_OBJECT_IDENTIFIER2 = "No {} has been found with identifiers [{}={}, {}={}] ";

    /**
     * No Object has been found with identifier [{}] used for Logging.
     */
    public static final String NOT_FOUND_OBJECT_IDENTIFIER3 = "No {} has been found with identifiers [{}={}, {}={}, {}={}] ";

    /**
     * Controller Message to be displayed after delete request.
     */
    public static final String RECEIVING_DELETE_REQUEST = "Receiving Delete Request of {}";

    /**
     * Receive request for radiation
     */
    public static final String RECEIVING_RADIATION_REQUEST = "Receiving radiation Request of {} with ID {}";

    /**
     * Controller Message to be displayed after delete request.
     */
    public static final String RECEIVING_DELETE_REQUEST_IDENTIFIER = "Receiving Delete Request of {} , id = [{}]";

    /**
     * Controller Message REQUEST_IDENTIFIER_VENDEUR.
     */
    public static final String REQUEST_IDENTIFIER_VENDEUR = "VENDEUR";

    /**
     * Controller Message REQUEST_VENDEUR_ID_COURTIER.
     */
    public static final String REQUEST_VENDEUR_ID_COURTIER = "idCourtier";

    /**
     * Controller Message REQUEST_VENDEUR_START_MAPPING_DATA.
     */
    public static final String REQUEST_VENDEUR_START_MAPPING_DATA = "Start Mapping data ";

    /**
     * Controller Message REQUEST_VENDEUR_CAUSE_GET_VENDEUR.
     */
    public static final String REQUEST_VENDEUR_CAUSE_GET_VENDEUR = "msg.cause.get.vendeur";

    /**
     * Controller Message MSG_VENDEUR_CAUSE_GET_VENDEUR_BY_ID_VEND_ID_COURTIER.
     */
    public static final String MSG_VENDEUR_CAUSE_GET_VENDEUR_BY_ID_VEND_ID_COURTIER = "msg.cause.get.vendeur.byIdVend.idCourtier";

    /**
     * Controller Message MSG_CAUSE_GET_VENDEUR_BY_ID_COURTIER.
     */
    public static final String MSG_CAUSE_GET_VENDEUR_BY_ID_COURTIER = "msg.cause.get.vendeur.byIdCourtier";

    /**
     * Controller Message to be displayed after delete request.
     */
    public static final String RECEIVING_DELETE_REQUEST_OF_BY_IDENTIFIER = "Receiving Delete Request of {} by id {}, id = [{}]";

    /**
     * Controller Message to be displayed after delete request.
     */
    public static final String RECEIVING_REST_DELETE_REQUEST_IDENTIFIER = "Receiving Rest Delete Request of {} , id = [{}]";

    /**
     * Controller Message to be displayed after update request.
     */
    public static final String RECEIVING_UPDATE_REQUEST = "Receiving Update Request of {}";

    /**
     * Controller Message to be displayed after update request.
     */
    public static final String RECEIVING_REST_UPDATE_REQUEST = "Receiving Rest Update Request of {}";

    /**
     * Controller Message to be displayed after check request.
     */
    public static final String RECEIVING_CHECK_REQUEST = "Receiving Check Request of {}";

    /**
     * Controller Message to be displayed after creation request.
     */
    public static final String RECEIVING_CREATION_REQUEST = "Receiving Creation Request of {}";

    /**
     * Controller Message to be displayed after getting list of ACTEVO BY IDORG
     */
    public static final String RECEIVING_REQUEST_LIST_ACTEVO_BY_IDORG = "Receiving request to get list ActeVO by idOrganisme : [{}]";

    /**
     * ontroller Message to be displayed after getting list of ACTEVO BY IDORG AND IDPROD
     */
    public static final String RECEIVING_REQUEST_LIST_ACTEVO_BY_IDORG_AND_IDPROD = "Receiving request to get list ActeVO by idOrganisme : [{}] and idProduit : [{}]";

    /**
     * The constatnt ID_AYANT_DROIT.
     */
    public static final String ID_AYANT_DROIT = "id Ayant Droit";

    /**
     * The constatnt GROUPE_TABLE.
     */
    public static final String GROUPE_TABLE = "GROUPE TABLE";

    /**
     * Controller Message to be displayed after creation request.
     */
    public static final String RECEIVING_REST_CREATION_REQUEST = "Receiving Rest Creation Request of {}";

    /**
     * Controller Message to be displayed after clone request.
     */
    public static final String RECEIVING_REST_CLONE_REQUEST = "Receiving Rest Clone Request of {}";

    /**
     * Controller Message to be displayed after changing state sinistre request.
     */
    public static final String RECEIVING_REST_CHANGE_STATE_REQUEST = "Receiving Rest Change State Sinistre Request of {}";

    /**
     * Controller Message to be displayed after stored procedure execution request.
     */
    public static final String RECEIVING_EXECUTION_REQUEST = "Receiving Execution Request of {}";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_ALL_REQUEST = "Requesting all elements of {} from Server";

    /**
     * Controller Message to be displayed after a checkIfIsPeriodClosed request using two Parameters.
     */
    public static final String CHECK_IF_PERIOD_CLOSED = "Checking if the period {} is closed";

    /**
     * Controller Message to be displayed after a getDatesEcheance request using two Parameters.
     */
    public static final String GET_DATES_ECHEANCE = "Getting dates echéance from Server";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_ID_MENU_BY_USER_NAME = "Requesting id menu by username";

    /**
     * Controller Message to be displayed before requesting id menu with the old habilitation system
     */
    public static final String RECEIVING_ID_MENU_BY_USER_NAME_WITH_OLD_HABIL_SYSTEM = "Retreiving id menu with the old habilitation system";

    /**
     * Controller Message to be displayed before requesting id menu with the new habilitation system
     */
    public static final String RECEIVING_ID_MENU_BY_USER_NAME_WITH_NEW_HABIL_SYSTEM = "Retreiving id menu with the new habilitation system";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_BY_ID_ORGANISME_REQUEST = "Requesting elements of {} from Server using idOrg";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_LIST_REQUEST_PARAMETER1 = "Requesting list of {} from Server using Parameter : [{}={}]";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_LIST_REQUEST_PARAMETER2 = "Requesting list of {} from Server using Parameters : [{}={}, {}={}]";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_LIST_REQUEST_PARAMETER3 = "Requesting list of {} from Server using Parameters : [{}={}, {}={}, {}={}]";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_LIST_REQUEST_PARAMETER4 = "Requesting list of {} from Server using Parameters : [{}={}, {}={}, {}={}, {}={}]";

    /**
     * Controller Message to be displayed after a get request using five Parameter.
     */
    public static final String RECEIVING_GET_LIST_REQUEST_PARAMETER5 = "Requesting list of {} from Server using Parameters : [{}={}, {}={}, {}={}, {}={}, {}={}]";

    /**
     * receive request radiation option produit
     */
    public static final String RECEIVING_REQUEST_POST_RADIER_OPTION = "Request radiation option produit {}";

    /**
     * Reception d'une requête de recherche avec filtre.
     */
    public static final String RECEIVING_FIND_FILTER_REQUEST = "Receiving find request for {} with filter";

    /**
     * error while radier option produit
     */
    public static final String ERROR_RADIATION_OPTION_PRODUIT_DATE_DEBUT_GREATER_THAN_DATE_RADIATION = "error while radiation option produit, date debut option greater than date radiation";

    /**
     * error while radier option produit
     */
    public static final String ERROR_RADIATION_DATE_DEBUT_OPTION_GREATER_THAN_DATE_RADIATION_PRODUIT = "error while radiation option produit, Date de début de l''option > Date de radiation du Produit";

    /**
     * error while radier option produit
     */
    public static final String ERROR_RADIATION_DATE_RADIATION_OPTION_GREATER_THAN_DATE_RADIATION_PRODUIT = "error while radiation option produit, Date de radiation de l''option > Date de radiation du Produit";

    /**
     * Controller Message to be displayed after a get request with no parameters.
     */
    public static final String RECEIVING_GET_REQUEST = "Requesting {} from Server";

    /**
     * The constant MSG_CAUSE_GET_ADRESSE
     */
    public static final String MSG_CAUSE_GET_ADRESSE = "msg.cause.get.adresse";

    /**
     * The constant MSG_CAUSE_GET_AGENCE_USERNAME
     */
    public static final String MSG_CAUSE_GET_AGENCE_USERNAME = "msg.cause.get.agence.userName";

    /**
     * The constant MSG_CAUSE_GET_AGENCE_BYORG
     */
    public static final String MSG_CAUSE_GET_AGENCE_BYORG = "msg.cause.get.agence.byOrg";

    /**
     * The constant MSG_CAUSE_GET_AGENCE
     */
    public static final String MSG_CAUSE_GET_AGENCE = "msg.cause.get.agence";

    /**
     * The constant MSG_CAUSE_GET_COLLEGE
     */
    public static final String MSG_CAUSE_GET_COLLEGE = "msg.cause.get.college";

    /**
     * The constant MSG_CAUSE_GET_DATE_LABELLISATION
     */
    public static final String MSG_CAUSE_GET_DATE_LABELLISATION = "msg.cause.get.dateLabellisation";

    /**
     * The constant MSG_CAUSE_RETURNING_VALEUR
     */
    public static final String MSG_CAUSE_RETURNING_VALEUR = "Returning Valeur : [{}]";

    /**
     * The constant MSG_CAUSE_CENTRE_COUNT
     */
    public static final String MSG_CAUSE_CENTRE_COUNT = "Centre  count :{} ";

    /**
     * The constant MSG_LIST_COMBINAISONS_COUNT
     */
    public static final String MSG_LIST_COMBINAISONS_COUNT = "List Combinaisons count :{} ";

    /**
     * The constant COMBINAISON_MSG_GET
     */
    public static final String COMBINAISON_MSG_GET = "COMBINAISON";


    /**
     * The Constant ORG_ORGANISME.
     */
    public static final String ORG_ORGANISME = "ORGANISME";

    /**
     * The Constant PAR_PARTENARIAT.
     */
    public static final String PAR_PARTENARIAT = "PARTENARIAT";

    /**
     * The Constant PROD_PRODUIT.
     */
    public static final String PROD_PRODUIT = "PRODUIT";

    /**
     * The Constant MSG_CAUSE_GET_OPTOIN.
     */
    public static final String MSG_CAUSE_GET_OPTOIN = "msg.cause.get.option";

    /**
     * The Constant MSG_CAUSE_GET_ALL_OPTOIN.
     */
    public static final String MSG_CAUSE_GET_ALL_OPTOIN = "msg.cause.get.all.option";

    /**
     * The Constant MSG_CAUSE_GET_BY_ID_OPTOIN_ID_ORG.
     */
    public static final String MSG_CAUSE_GET_BY_ID_OPTOIN_ID_ORG = "msg.cause.get.option.byIdProd.idOrg";

    /**
     * The Constant MSG_CAUSE_GET_DECOMPTEUSE.
     */
    public static final String MSG_CAUSE_GET_DECOMPTEUSE = "msg.cause.get.decompteuse";

    /**
     * The Constant MSG_CAUSE_GET_ALL_ORIGINE.
     */
    public static final String MSG_CAUSE_GET_ALL_ORIGINE = "msg.cause.get.all.origine";


    /**
     * The Constant MSG_CAUSE_GET_PARAM_HABILITATION.
     */
    public static final String MSG_CAUSE_GET_PARAM_HABILITATION = "msg.cause.get.param.habilitation";

    /**
     * The Constant MSG_CAUSE_GET_ALL_CHEMISE.
     */
    public static final String MSG_CAUSE_GET_ALL_CHEMISE = "msg.cause.get.all.chemise";

    /**
     * The Constant MSG_CAUSE_GET_ALL_TYPE_DOCUMENT.
     */
    public static final String MSG_CAUSE_GET_ALL_TYPE_DOCUMENT = "msg.cause.get.all.type.document";

    /**
     * The Constant MSG_CAUSE_GET_PERIODE.
     */
    public static final String MSG_CAUSE_GET_PERIODE = "msg.cause.get.periode";

    /**
     * The Constant MSG_CAUSE_GET_ALL_PERIODE.
     */
    public static final String MSG_CAUSE_GET_ALL_PERIODE = "msg.cause.get.all.periode";

    /**
     * The Constant MSG_CAUSE_GET_ALL_PERIODE_BY_DOMAINE.
     */
    public static final String MSG_CAUSE_GET_ALL_PERIODE_BY_DOMAINE = "msg.cause.get.all.periodeByDomaine";

    /**
     * The Constant MSG_CAUSE_GET_LPP.
     */
    public static final String MSG_CAUSE_ERROR_LPP = "msg.cause.error.lpp";

    /**
     * The Constant MSG_CAUSE_ERROR_TYPE_LPP.
     */
    public static final String MSG_CAUSE_ERROR_TYPE_LPP = "msg.cause.error.lpp.type.audio";

    /**
     * The Constant MSG_CAUSE_VALIDER_LIGNE_PRESTATION_COUNT_NBOPTION_PARAMETREE.
     */
    public static final String MSG_CAUSE_VALIDER_LIGNE_PRESTATION_COUNT_NBOPTION_PARAMETREE = "msg.cause.validerligneprestation.count.nboption.parametree";

    /**
     * The Constant MSG_CAUSE_ERROR_LPP_AUDIO.
     */
    public static final String MSG_CAUSE_ERROR_LPP_AUDIO = "msg.cause.error.lpp.audio";

    /**
     * The Constant MSG_CAUSE_GET_ALL_SOUS_CHEMISE.
     */
    public static final String MSG_CAUSE_GET_ALL_SOUS_CHEMISE = "msg.cause.get.all.sous.chemise";

    /**
     * The Constant ORG_ORIGINE.
     */
    public static final String ORG_ORIGINE = "ORIGINE";

    /**
     * The Constant GET_LIST_OF_OPTIONS_BY_ID_ORG.
     */
    public static final String GET_LIST_OF_OPTIONS_BY_ID_ORG = "get list of options by organisme [{}] and idProduit [{}] and idConventionCollective [{}]";

    /**
     * The Constant MSG_CAUSE_GETTING_OBJECTS.
     */
    public static final String MSG_CAUSE_GETTING_OBJECTS = "Getting [{}] objects ";

    /**
     * The Constant MSG_CAUSE_GET_ALL_OPTOIN_BY_ID_ORG_ID_GRO_ID_COLLEGE.
     */
    public static final String MSG_CAUSE_GET_ALL_OPTOIN_BY_ID_ORG_ID_GRO_ID_COLLEGE = "msg.cause.get.all.option.byIdOrg.idGro.idCollege";

    /**
     * The Constant PROD_ID_FAMILLE.
     */
    public static final String PROD_ID_FAMILLE = "idFamille";

    /**
     * The Constant SITUATION_CGC_HC_GC_ID_GPROD.
     */
    public static final String SITUATION_CGC_HC_GC_ID_GPROD = "idGprod";

    /**
     * The Constant OPTION_ID_OPTION.
     */
    public static final String OPTION_ID_OPTION = "idOption";

    /**
     * The Constant OPTION_ID_ORGANISME.
     */
    public static final String OPTION_ID_ORGANISME = "ID_ORGANISME";

    /**
     * The Constant OPTION_ID_PRODUIT.
     */
    public static final String OPTION_ID_PRODUIT = "ID_PRODUIT";

    /**
     * The Constant OPT_OPTION.
     */
    public static final String OPT_OPTION = "Option";

    /**
     * The Constant PROD_OPTION_PRODUIT.
     */
    public static final String PROD_OPTION_PRODUIT = "OPTION PRODUIT";


    /**
     * The constant MSG_CAUSE_GET_ALL_ADRESSE
     */
    public static final String MSG_CAUSE_GET_ALL_ADRESSE = "msg.cause.get.all.adresse";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_GET_REQUEST_PARAMETER1 = "Requesting {} from Server using Parameter : [{}={}]";

    /**
     * The constant REMISE_COMMERCIALE_AYANT_DROIT
     */
    public static final String REMISE_COMMERCIALE_AYANT_DROIT = "REMISE COMMERCIALE AYANT DROIT";

    /**
     * The constant TIERS_TIERS
     */
    public static final String TIERS_TIERS = "TIERS";

    /**
     * Controller Message to be displayed after a get request using one Parameter.
     */
    public static final String RECEIVING_REST_GET_REQUEST_PARAMETER1 = "Rest Request to get {} from Server using Parameter : [{}={}]";

    /**
     * Controller Message to be displayed after a get request using 2 Parameter.
     */
    public static final String RECEIVING_GET_REQUEST_PARAMETER2 = "Requesting {} from Server using Parameters : [{}={}, {}={}]";

    /**
     * Controller Message to be displayed after a get request using 3 Parameter.
     */
    public static final String RECEIVING_GET_REQUEST_PARAMETER3 = "Requesting {} from Server using Parameters : [{}={}, {}={}, {}={}]";

    /**
     * Controller Message to be displayed after a get request using 4 Parameter.
     */
    public static final String RECEIVING_GET_REQUEST_PARAMETER4 = "Requesting {} from Server using Parameters : [{}={}, {}={}, {}={} , {}={}]";

    /**
     * Controller message to be displayed after a count request using one parameter.
     */
    public static final String RECEIVING_COUNT_REQUEST_PARAMETER1 = "Count request from table {} using Parameters : [{}={}]";

    /**
     * Controller message to be displayed after a count request using two parameters.
     */
    public static final String RECEIVING_COUNT_REQUEST_PARAMETER2 = "Count request from table {} using Parameters : [{}={}, {}={}]";

    /**
     * radiation ayant droit
     */
    public static final String RECEIVING_REQUEST_RADIATION_AYANT_DROIT = "Requesting radiation ayant droit";

    /**
     * the responsable has date radiation less than ayant droit
     */
    public static final String AYANT_DROIT_NOT_RESPONSABLE = "l'ayant droit selectionné n'est pas un responsable";


    /**
     * Controller Message to be displayed after a get request using five Parameters.
     */
    public static final String RECEIVING_GET_REQUEST_PARAMETER5 = "Requesting {} from Server using Parameters : [{}={}, {}={}, {}={} , {}={}, {}={}]";

    /**
     * Response to be sent to Server.
     */
    public static final String RESPONSE_SENT_BY_SERVER = "Response to be sent by Server ...";

    /**
     * Created Object.
     */
    public static final String CREATED_OBJECT = "Created Object : {} ";

    /**
     * Updated Object.
     */
    public static final String UPDATED_OBJECT = "Updated Object : {} ";

    /**
     * Check si le frais param est déjà affecté.
     */
    public static final String CHECK_IF_IS_AFFECTED = "Check if Object id affected : {} ";

    /**
     * Performing Data integrity Check.
     */
    public static final String DATA_INTEGRITY_CHECK1 = "Performing Data integrity Check";

    /**
     * Performing integrity Check (checking if the returned value/list is null or Empty).
     */
    public static final String DATA_INTEGRITY_CHECK2 = "Performining integrity Check (checking if the returned value/list is null or Empty)";

    /**
     * Error while Saving.
     */
    public static final String ERROR_WHILE_SAVING = "Error while Saving : {} ";

    /**
     * Error while Updating.
     */
    public static final String ERROR_WHILE_UPDATING = "Error while Updating : {} ";

    /**
     * ERROR wile radiation
     */
    public static final String ERROR_WHILE_RADIATION = "Error while RADIATION : {} ";

    /**
     * ERROR while changement etat
     */
    public static final String ERROR_WHILE_CHANGE_ETAT = "Erreur changement Etat {}: {} ";

    /**
     * an Object has been found.
     */
    public static final String OBJECT_FOUND = "An Object has been found : {} ";

    /**
     * Objects List has been found.
     */
    public static final String OBJECTS_LIST_FOUND = "Objects List has been found : {} ";

    /**
     * Number of objects has been found.
     */
    public static final String NBR_OBJECTS_FOUND = "{} objects has been found";

    /**
     * Objects List has been found.
     */
    public static final String CHECKING_ARGUMENTS = "Checking arguments : {} ";

    /**
     * Persisting Object in DB.
     */
    public static final String PERSISTING_OBJECT = "Persisting {} object in DB";

    /**
     * Success persisting Object in DB.
     */
    public static final String SUCCESS_PERSISTING_OBJECT = "Success persisting {} object in DB with id= {}";

    /**
     * Error while Saving.
     */
    public static final String ERROR_WHILE_DELETING_IDENTIFIER1 = "Error while Deleting : {} with [{}={}]";

    /**
     * Error while deleting
     */
    public static final String ERROR_WHILE_DELETING = "Error while Deleting ";

    /**
     * Error while Saving.
     */
    public static final String PROCESS_DELETE = "Start delete process";

    /**
     * Start changing code tiers
     */
    public static final String PROCESS_CHANGE_CODE_TIERS = "Start changing code tiers";

    /**
     * Error while Saving.
     */
    public static final String SUCCESFULL_DELETE = "Object has been successfully removed from DB";

    /**
     * success radiation option
     */
    public static final String SUCCESSFUL_RADIATION = "success radiation";

    /**
     * success retrieving Date tarif
     */
    public static final String SUCCESSFUL_RETRIEVING_TARIF = "retrieving Date tarif by  id Groupe : [{}]";

    /**
     * Loading data.
     */
    public static final String LOAD_DATA = "Loading data ...";

    /**
     * check param against null.
     */
    public static final String CHECK_NULL_ERROR = "Check error : {} is null";

    /**
     * check param length.
     */
    public static final String CHECK_LENGTH_ERROR = "Check error : \"{}\" has a non valid length";

    /**
     * == null.
     */
    public static final String IS_NULL = " == null";

    /**
     * The Constant INCORRECT_KEY_RIB.
     */
    public static final String INCORRECT_KEY_RIB = "Incorrect RIB Key";

    /**
     * The Constant INCORRECT_IBAN.
     */
    public static final String INCORRECT_IBAN = "Incorrect IBAN";

    /**
     * duplicated data.
     */
    public static final String DUPLICATED_DATA = "Duplicated data.";

    /**
     * The  PRODUIT_ID_ORGANISME.
     */
    public static final String PRODUIT_ID_ORGANISME = "idOrganisme";

    /**
     * The  RETRIEVING_ELEMENT_FIND_GPROD_INFO_RUBRIQUE.
     */
    public static final String RETRIEVING_ELEMENT_FIND_GPROD_INFO_RUBRIQUE = "Retrieving Element findGprodInfoRubrique";

    /**
     * The  PRODUIT_ID_FAMILLE.
     */
    public static final String PRODUIT_ID_FAMILLE = "idFamille";

    /**
     * The  PRODUIT_ID_PRODUIT.
     */
    public static final String PRODUIT_ID_PRODUIT = "idProduit";

    /**
     * habilitation.
     */
    public static final String CHECKING_HABILITATION = "Checking Habilitation for User";

    /**
     * Suspension.
     */
    public static final String CHECKING_SUS_DECOMPTE_PAYE = "Checking unpaid accounts on {}";
    /**
     * The constant CHECKING_SUS_DATE_OVERLAP.
     */
    public static final String CHECKING_SUS_DATE_OVERLAP = "Checking overlap dates {}";
    /**
     * The constant NOT_AUTHORIZED_USER_TO_CREATE_PRESTATION.
     */
    public static final String NOT_AUTHORIZED_USER_TO_CREATE_PRESTATION = "Not authorized user to create  prestation";
    /**
     * The constant FAIL_CONTROLE_FAMILY_PRODUCT.
     */
    public static final String FAIL_CONTROLE_FAMILY_PRODUCT = "No famille - produit with this identifiers , idOrganisme :{} ,idFamille :{}, idProduit :{}  ";

    /**
     * The constant EREUR_CREATE_TRAITEMENT_ADMIN .
     */
    public static final String EREUR_CREATE_TRAITEMENT_ADMIN = "Error create traitement admin";

    /**
     * The constant RECEIVING_VERIFY_EXIST_AY_REQUEST .
     */
    public static final String RECEIVING_VERIFY_EXIST_AY_REQUEST = "Verify if Ay exist in same family";

    /**
     * The constant RECEIVING_VERIFY_EXIST_AY_REQUEST .
     */
    public static final String RECEIVING_VERIFY_EXIST_FAMILLE_REQUEST = "Verify if famille exist in the same Organisme";

    /**
     * The constant GET_LIST_ADC_BY_IDENTIFIER .
     */
    public static final String GET_LIST_ADC_BY_IDENTIFIER = "Get List ADC by Ay identifier {}";

    /**
     * Controller Message to be displayed after creation request.
     */
    public static final String RECEIVING_SET_DEFAULT_HABILITATION = "Receiving setting the default liste of habilitation {}";

    /**
     * Controller Message to be displayed after No update.
     */
    public static final String NO_ROW_UPDATED = "No Row has been updated";

    /**
     * Controller Message pass different.
     */
    public static final String PASS_DIFF = "Attention, mot de passe différent";

    /**
     * Validating bordereau prestation adherent.
     */
    public static final String VALIDATING_BORDEREAU_PRESTATION_ADHERENT = "Validating bordereau prestation adherent";
    /**
     * Logger REQUEST_EXISTENCE_RELANCE
     */
    public static final String REQUEST_EXISTENCE_RELANCE = " Verification de l'existance du relance pour Famille {} ";

    /**
     * Error while getting object from DB
     */
    public static final String ERROR_WHILE_GETTING_ELEMENTS_FROM_DB = "Error while getting element from data base";

    /**
     * The constant CHECKING_EXIST_PART_WITH_DIFFERENT_CP .
     */
    public static final String CHECKING_EXIST_PART_WITH_DIFFERENT_CP = "Checking exist partenaire with different CP value for idGpart = {} and topAmortCp = {}";

    /**
     * Error No JDBC was found
     */
    public static final String ERROR_NO_JDBC_WAS_FOUND = "No JDBC was found";

    /**
     * Error No JDBC was found
     */
    public static final String ERROR_NO_DATA_SOURCE_WAS_FOUND = "No data source was found";

    /**
     * Error SqlException Occured
     */
    public static final String ERROR_SQLEXCEPTION_OCCURED = "SQLException occured ...";

    /**
     * Error Code = {}
     */
    public static final String ERROR_CODE = "Error Code = {}";

    /**
     * Error MSG is : {}
     */
    public static final String ERROR_MSG = "Error MSG is : {}";

    /**
     * Info Close current callableStatement
     */
    public static final String INFO_CLOSE_CURRENT_CALLABLESTATEMENT = "close current callableStatement";

    /**
     * Error Closing current callableStatement
     */
    public static final String ERROR_CLOSING_CURRENT_CALLABLESTATEMENT = "Error closing callableStatement";

    /**
     * Check if jdbcTemplate is null
     */
    public static final String CHECK_JDBCTEMPLATE_IS_NULL = "Check jdbcTemplate if null";

    /**
     * START_MAPPING_SALARIE_REG
     */
    public static final String START_MAPPING_SALARIE_REG = "Start Mapping salarié data From DB";

    /**
     * START_MAPPING_EMP_REG
     */
    public static final String START_MAPPING_EMP_REG = "Start Mapping employer data From DB";

    /**
     * START_MAPPING_CE_REG
     */
    public static final String START_MAPPING_CE_REG = "Start Mapping CE data From DB";

    /**
     * Get GRP SIRET value
     */
    public static final String GET_GRPSIRET_BY_GRP_SIRET_FIELD_VALUE = "get GRPSIRET by GrpSiret field value";

    /**
     * Get  CHECKING_GRPSIRET_EXISTENCE_GRP_SIRET_SIREN_FIELD_VALUE value
     */
    public static final String CHECKING_GRPSIRET_EXISTENCE_GRP_SIRET_SIREN_FIELD_VALUE = "Checking the existence of {} as a num siret/siren";

    /**
     * Get ETABLISSEMENTS by IDGPROD and ID_ORG
     */
    public static final String GET_LIST_ETABLISSEMENTS_LIE_BY_ID_GRP_AND_ID_ORG = "get list etablissements lié by idGrp and idOrg ";
    /**
     * The constant  MSG_CAUSE_GET_FAMILLE_AUTH
     */
    public static final String MSG_CAUSE_GET_FAMILLE_AUTH = "msg.cause.get.famille.auth";

    /**
     * The constant  ARGUMENT_TEST_AGAINST_NULL
     */
    public static final String ARGUMENT_TEST_AGAINST_NULL = "Argument test against null";

    /**
     * The constant  MSG_CAUSE_GET_FAMILLE
     */
    public static final String MSG_CAUSE_GET_FAMILLE = "msg.cause.get.famille";

    /**
     * The constant  MSG_CAUSE_GET_ALL_FAMILLE
     */
    public static final String MSG_CAUSE_GET_ALL_FAMILLE = "msg.cause.get.all.famille";

    /**
     * The constant  MSG_CAUSE_GET_ALL_FAMILLE_CODE
     */
    public static final String MSG_CAUSE_GET_ALL_FAMILLE_CODE = "msg.cause.get.all.famille.code";

    /**
     * The constant  MSG_CAUSE_SEARCH_FAMILLE
     */
    public static final String MSG_CAUSE_SEARCH_FAMILLE = "msg.cause.search.famille";

    /**
     * TRYING DELETE SIRET
     */
    public static final String TRYING_TO_DELETE_SIRET = "Trying to delete Siret: ";
    /**
     *  MESSAGE_SENDER_WITH_AUTH
     */
    public static final String MESSAGE_SENDER_WITH_AUTH = "Basic ";

    /**
     * TRYING DELETE GROUPE FILIALE
     */
    public static final String TRYING_TO_DELETE_GROUPE_FILIALE = "Trying to delete Groupe Filiale: ";

    /**
     * MAPPING DATA START
     */
    public static final String START_MAPPING_DATA = "Start mapping data";

    /**
     * GET LIST PART
     */
    public static final String GET_LISTE_PART = "Get liste part";

    /**
     * GET LIST ECHEANCE
     */
    public static final String GET_LISTE_ECHEANCE = "Get liste echeance";
    /**
     * RADIATION GROUPE INFO
     */
    public static final String RADIATION_GROUPE_INFO = "Radiation Groupe Informations Complementaires {}";

    /**
     * RADIATION adc
     */
    public static final String RADIATION_ADC = "Radiation des ADC";

    /**
     * RECALCULE DROIT 408
     */
    public static final String RADIATION_DROIT_408 = "On effectue le recalcul des droits 408 de la personne";

    /**
     * RADIATION FAMILLE CPAM
     */
    public static final String RADIATION_FAMILLE_CPAM = "Radiation famille CPAM";

    /**
     * RADIATION FPROD
     */
    public static final String RADIATION_FPROD = "Radiation des FPROD";

    /**
     * RADIATION AY WHEN NO PRODUCT OPNED
     */
    public static final String RADIATION_AY_WHEN_NO_PRODUCT_OPNED = "Radiation des AY si aucun produit ouvert";

    /**
     * RECALCUL DROIT 408
     */
    public static final String RECALCUL_DROIT_408 = "On effectue le recalcul des droits 408 de la personne ";

    /**
     * Error failed to create AyQual
     */
    public static final String ERROR_FAIL_CREATION_AYQUAL = "Failed to create AyQual";

    /**
     * Error failed to delete AyQual
     */
    public static final String ERROR_FAIL_DELETE_AYQUAL = "Failed to delete AyQual";

    /**
     * Error pas d'adresse associée
     */
    public static final String ERROR_PAS_ADRESSE_ASSOCIEE = "Pas d'adresse associée au responsable !";

    /**
     * Info saved AyQual
     */
    public static final String CREATION_AY_QUAL = "Création impossible";

    /**
     * Number of returned elements
     */
    public static final String NUMBER_RETURNED_ELEMENTS = "Returned list of {} count = [{}]";

    /**
     * Count returned
     */
    public static final String COUNT_RETURNED = "Returning count = [{}]";

    /**
     * Error IllegalArgumentException
     */
    public static final String FIRING_ILLEGAL_ARGUMENT_EXCEPTION = "-- Firing IllegalArgumentException ";

    /**
     * Error Data integrity violation
     */
    public static final String DATA_INTEGRITY_VIOLATION = "Data integrity violation ...";

    /**
     * TRYING DELETE SINISTRE
     */
    public static final String TRYING_TO_DELETE_SINISTRE = "Trying to delete Sinistre: ";

    /**
     * Error failed to delete sinistre
     */
    public static final String ERROR_FAIL_DELETE_SINISTRE = "Failed to delete Sinistre";

    /**
     * The constant CHECKING_SINISTRE_HAS_DECOMPTE_TO_DELETE .
     */
    public static final String CHECKING_SINISTRE_HAS_DECOMPTE_TO_DELETE = "Checking if sinistre with id = {} has decompte to delete";

    /**
     * The constant CHECKING_SINISTRE_CREATING_HAS_CHEVAUCHEMENT .
     */
    public static final String CHECKING_SINISTRE_CREATING_HAS_CHEVAUCHEMENT = "Checking if sinistre creating has chevauchement";

    /**
     * The constant CHECKING_SINISTRE_CREATING_HAS_CHEVAUCHEMENT .
     */
    public static final String CHECKING_SINISTRE_CREATING_FAIT_GENERATEUR_HAVE_CHEVAUCHEMENT = "Checking if sinistres creating fait générateur have overlap";

    /**
     * The constant RECUPERATE_OP_AND_NB_ENFT_OF_SINISTRE .
     */
    public static final String RECUPERATE_OP_AND_NB_ENFT_OF_SINISTRE = "Recuperate option and nb enfant of the sinistre";

    /**
     * The constant RECUPERATE_NB_ENFT_OF_ADC .
     */
    public static final String RECUPERATE_NB_ENFT_OF_ADC = "Recuperate nb enfant from adc";

    /**
     * The constant RECUPERATE_SINISTRE_BY_ID .
     */
    public static final String RECUPERATE_SINISTRE_BY_ID = "Recuperate sinistre by id";

    /**
     * The constant RECUPERATE_DAT_DEB_FIN_OF_SINISTRE_AND_PERIOD_RENUM .
     */
    public static final String RECUPERATE_DAT_DEB_FIN_OF_SINISTRE_AND_PERIOD_RENUM = "Recuperate  datedeb et datefin of sinistre and period remun";

    /**
     * The constant GENERATE_PERIOD_RENUM .
     */
    public static final String GENERATE_PERIOD_RENUM = "Generate period of remuneration";

    /**
     * The constant VERIFY_VALIDATION_OF_ALL_PJO .
     */
    public static final String VERIFY_VALIDATION_OF_ALL_PJO = "verify if all PJO are validated";

    /**
     * The constant VERIFY_NUMBER_DEOMPTES_NON_PAYES .
     */
    public static final String VERIFY_NUMBER_DEOMPTES_NON_PAYES = "verify number of decomptes";

    /**
     * The constant VERIFY_NUMBER_DEOMPTES_NON_PAYES .
     */
    public static final String VERIFY_PAIEMENT_GLOBAL_GROUPE = "verify paiement globla";

    /**
     * The constant VERIFY_ETAT_DECOMPTE_SINISTRE .
     */
    public static final String VERIFY_ETAT_DECOMPTE_SINISTRE = "check if etat decompte should change";

    /**
     * The constant RECUPERATE_ID_TRT_DSN .
     */
    public static final String RECUPERATE_ID_TRT_DSN = "Recuperate the id trt dsn ";

    /**
     * TRYING DELETE SINISTRE
     */
    public static final String TRYING_TO_ADD_BENEF_EXTERNE = "Trying to add beneficiaire externe: ";

    /**
     * TRYING_TO_UPDATE_BENEF_EXTERNE
     */
    public static final String TRYING_TO_UPDATE_BENEF_EXTERNE = "Trying to update beneficiaire externe: ";

    /**
     * TRYING_TO_ADD_HEVEN
     */
    public static final String TRYING_TO_ADD_HEVEN = "Trying to add heven: ";

    /**
     * TRYING_TO_DELETE_BENEF_EXTERNE
     */
    public static final String TRYING_TO_DELETE_BENEF_EXTERNE = "Trying to delete beneficiaire externe: ";

    /**
     * TRYING_TO_DELETE_LIEN_BENEF
     */
    public static final String TRYING_TO_DELETE_LIEN_BENEF = "Trying to delete lien beneficiaire: ";

    /**
     * INFO_CALCUL_IBAN_KEY
     */
    public static final String INFO_CALCUL_IBAN_KEY = "Calcul iban key: ";

    /**
     * INFO_PERSIST_REFBQE
     */
    public static final String INFO_PERSIST_REFBQE = "Persisting RefbqeVO  Object in DB ";

    /**
     * INFO_PERSIST_REFBQE
     */
    public static final String INFO_PERSISTED_REFBQE = "RefbqeFVO has been persisted in DB";

    /**
     * INFO_FOUND_GUICHET
     */
    public static final String INFO_FOUND_GUICHET = "guichet has been found";

    /**
     * CHECKING_GUICHET_BUSY
     */
    public static final String CHECKING_GUICHET_BUSY = "Checking if guichet {} is busy";

    /**
     * UNLOCKED_GUICHET
     */
    public static final String UNLOCKED_GUICHET = "Guichet {} has been unlocked";

    /**
     * CHECKING_USER_HABILITATIONS_FOR_EACH_GUICHET
     */
    public static final String CHECKING_USER_HABILITATIONS_FOR_EACH_GUICHET = "Checking habilitations for each guichet for user {}";

    /**
     * CHECKING_ACCES_GROUPES_GUICHET
     */
    public static final String CHECKING_ACCES_GROUPES_GUICHET = "Checking access for each group of guichet {}";

    /**
     * CHECKING_NUM_BORDEREAU
     */
    public static final String CHECKING_NUM_BORDEREAU = "Checking that bordereau {} is unique";

    /**
     * PRINTING_ENCAISSEMENTS
     */
    public static final String PRINTING_ENCAISSEMENTS = "Printing {} encaissements";

    /**
     * RETRIEVING_ECLATEMENTS_BY_MONTANT_APPEL
     */
    public static final String RETRIEVING_ECLATEMENTS_BY_MONTANT_APPEL = "Retrieving eclatements by montant appel";

    /**
     * RETRIEVING_ECLATEMENTS_BY_MONTANT_COTISATIONS
     */
    public static final String RETRIEVING_ECLATEMENTS_BY_MONTANT_COTISATIONS = "Retrieving eclatements by montant cotisations";

    /**
     * Data integrity violation exception message
     */
    public static final String DATA_INTEGRITY_VIOLATION_EXCEPTION = "DATA_INTEGRITY_VIOLATION_EXCEPTION- {} ";

    /**
     * Retrieving Famille from DB message
     */
    public static final String RETRIEVING_FAMILLE_FROM_DB = "Retrieving Famille from DB";

    /**
     * Error failed to create Memo Bencap
     */
    public static final String ERROR_FAIL_CREATION_MEMO_BENCAP = "Failed to create Memo Bencap";

    /**
     * Error failed to delete Memo Bencap
     */
    public static final String ERROR_FAIL_DELETE_MEMO_BENCAP = "Failed to delete Memo Bencap";

    /**
     * TRYING_TO_ADD_AYANT_DROIT
     */
    public static final String TRYING_TO_ADD_AYANT_DROIT = "Trying to add ayant droit";
    /**
     * MAPPING_RESULT_OBJECT_DTO
     */
    public static final String MSG_CAUSE_ALL_PARTENAIRE = "msg.cause.get.all.partenaire";

    /**
     * MSG_CAUSE_GET_REFERENCE
     */
    public static final String MSG_CAUSE_GET_REFERENCE = "msg.cause.get.reference";

    /**
     * MAPPING_RESULT_OBJECT_DTO
     */
    public static final String MSG_CAUSE_ALL_TYPE_TIERS = "msg.cause.get.all.type.tiers";
    /**
     * MSG_CAUSE_ALL_PARTENAIRE
     */
    public static final String MAPPING_RESULT_OBJECT_DTO = "Mapping result Objects to DTO";

    /**
     * LIST_HAS_BEEN_MAPPED_ELEMENTS_TO_BE_SEND_CLIENT
     */
    public static final String LIST_HAS_BEEN_MAPPED_ELEMENTS_TO_BE_SEND_CLIENT = "List has been mapped. [{}] elements to be send to Client ...";

    /**
     * COMMISSIONNEMENTGLOBAL_CRITERE
     */
    public static final String COMMISSIONNEMENTGLOBAL_CRITERE = "commissionnementsGlobalCritere";

    /**
     * GET Prod param optique
     */
    public static final String PARAM_PROD_OPTIQ_SAISIE_GLOBALISE = "recuperate parametrage product optique";

    /**
     * GET Prod param optique
     */
    public static final String CHECK_IS_ACTE_OPTIQUE = "check if act is optique";
    /**
     * GET DELETE_ALL_TT_REPRISE
     */
    public static final String DELETE_ALL_TT_REPRISE = "Delete all from TT_REPRISE_REPRE";
    /**
     * GET DELETE_ALL_TT_REPRISE_ERR
     */
    public static final String DELETE_ALL_TT_REPRISE_ERR = "Delete all from TT_REPRISE_REPRE_ERR";

    /**
     * EXECUTE_STORED_PROC
     */
    public static final String EXECUTE_STORED_PROC = "Execute stored procedure :";

    /**
     * EXECUTE_INFO_DETAILS_PEC_ASSO_DEVIS
     */
    public static final String EXECUTE_STORED_FN = "Execute stored function";

    /**
     * RECUPERATE_ETAT_DEMANDE
     */
    public static final String RECUPERATE_ETAT_DEMANDE = "Reccuperate etat of adc of demande resiliation...";

    /**
     * RECUPERATE_SOLDE_DEMANDE
     */
    public static final String RECUPERATE_SOLDE_DEMANDE = "Reccuperate solde of demande resiliation...";

    /**
     * ANNULATE_DEMANDE_RESILIATION
     */
    public static final String ANNULATE_DEMANDE_RESILIATION = "Annulate demande resiliation...";

    /**
     * CONTROLE_COMBI_DEMANDE_RESILIATION
     */
    public static final String CONTROLE_COMBI_DEMANDE_RESILIATION = "Controle combi demande resiliation...";

    /**
     * RECUPERATE_RETOUR_RADIATION_OK
     */
    public static final String RECUPERATE_RETOUR_RADIATION_OK = "get retour of radaition_ok...";

    /**
     * GET_RIA_ADC_BY_ID_DEMANDE
     */
    public static final String GET_RIA_ADC_BY_ID_DEMANDE = "get RiaADC by id Demande = {}";
    /**
     * REJET_DEMANDE_RESILIATION
     */
    public static final String REJET_DEMANDE_RESILIATION = "Rejet demande resiliation...";

    /**
     * CREATE_DEMANDE_RESILIATION
     */
    public static final String CREATE_DEMANDE_RESILIATION = "Lancement de la creation de la demande resiliation...";

    /**
     * CREATE_OPTION_DEMANDE_RESILIATION
     */
    public static final String CREATE_OPTION_DEMANDE_RESILIATION = "Lancement de la creation de l'option'...";

    /**
     * CALCULE_DEMANDE_RESILIATION
     */
    public static final String CALCULE_DEMANDE_RESILIATION = "Lancement du calcule de la demande resiliation...";

    /**
     * SUPPRESSION_DEMANDE_RESILIATION
     */
    public static final String SUPPRESSION_DEMANDE_RESILIATION = "Suppression de la demande de resiliation en cours...";

    /**
     * RECUPERATE_PERIMETER_DEMANDE_RESILIATION
     */
    public static final String RECUPERATE_PERIMETER_DEMANDE_RESILIATION = "Récuperation de la liste des périmetre...";

    /**
     * EXECUTE_FUNCTION
     */
    public static final String EXECUTE_FUNCTION = "Executing function ...";

    /**
     * MSG_GENERAL_UNDEFINED
     */
    public static final String MSG_GENERAL_UNDEFINED = "msg.general.undefined";

    /**
     * The Constant MSG_CAUSE_REMISE_COMMERCIALE_CHEVAUCHEMENT_DATE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_CHEVAUCHEMENT_DATE = "msg.cause.remiseCommerciale.chevauchementDate";

    /**
     * The Constant MSG_CAUSE_REMISE_COMMERCIALE_INVALID_REMISE_OPTION_IDENTIFIER
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_INVALID_REMISE_OPTION_IDENTIFIER = "msg.cause.remiseCommerciale.invalidRemiseOptionIdentifier";

    /**
     * The Constant LOCALIZED_ENTITY_TYPE.
     */
    public static final String LOCALIZED_ENTITY_TYPE = "msg.error.type.remiseCommercialeAyantDroit";

    /**
     * The Constant MSG_CAUSE_DELETE_REMISE_COMMERCIALE_NOT_FOUND
     */
    public static final String MSG_CAUSE_DELETE_REMISE_COMMERCIALE_NOT_FOUND = "msg.cause.delete.remiseCommerciale.notFound";

    /**
     * The constant MSG_CAUSE_GET_REMISE_COMMERCIALE_BY_IDFAM
     */
    public static final String MSG_CAUSE_GET_REMISE_COMMERCIALE_BY_IDFAM = "msg.cause.get.remiseCommerciale.byIdFam";

    /**
     * The constant MSG_CAUSE_GET_REMISE_COMMERCIALE
     */
    public static final String MSG_CAUSE_GET_REMISE_COMMERCIALE = "msg.cause.get.remiseCommerciale";

    /**
     * The constant MSG_CAUSE_REMISE_COMMERCIALE_NO_COMBINAISON_OPTION_FOR_AYANT_DROIT
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_NO_COMBINAISON_OPTION_FOR_AYANT_DROIT = "msg.cause.remiseCommerciale.noCombinaisonOptionForAyantDroit";

    /**
     * The constant MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_FIN_MOIS_DATE_RADIATION_OPTION
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_FIN_MOIS_DATE_RADIATION_OPTION = "msg.cause.remiseCommerciale.date.debut.fin.mois.date.radiation.option";

    /**
     * The constant MSG_CAUSE_REMISE_COMMERCIALE_MODIFICATION_IMPOSSIBLE_ANNEE_CLOTURE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_MODIFICATION_IMPOSSIBLE_ANNEE_CLOTURE = "msg.cause.remiseCommerciale.modification.impossible.annee.cloture";

    /**
     * The constant MSG_CAUSE_REMISE_COMMERCIALE_PERIODE_NON_TROUVE_OPTION_COMBINAISON
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_PERIODE_NON_TROUVE_OPTION_COMBINAISON = "msg.cause.remiseCommerciale.periode.non.trouve.option.combinaison";

    /**
     * The constant MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_HORS_PERIODE_VALIDITE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_HORS_PERIODE_VALIDITE = "msg.cause.remiseCommerciale.date.Debut.hors.periode.valdité";

    /**
     * The constant  MSG_CAUSE_REMISE_COMMERCIALE_DATE_FIN_HORS_PERIODE_VALIDITE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_DATE_FIN_HORS_PERIODE_VALIDITE = "msg.cause.remiseCommerciale.date.Fin.hors.periode.valdité";

    /**
     * The constante MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_DEBUT_MOIS_DATE_ADHESION_OPTION
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_DATE_DEBUT_DEBUT_MOIS_DATE_ADHESION_OPTION = "msg.cause.remiseCommerciale.date.debut.debut.mois.date.adhésion.option";

    /**
     * The constante MSG_CAUSE_REMISE_COMMERCIALE_CREATED_TRYING_UPDATE_COTISATION_MODIFICATION
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_CREATED_TRYING_UPDATE_COTISATION_MODIFICATION = "remise Commerciale created and trying to update cotisation modification";

    /**
     * The constante MSG_CAUSE_REMISE_COMMERCIALE_CREATION_IMPOSSIBLE_ANNEE_CLOTURE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_CREATION_IMPOSSIBLE_ANNEE_CLOTURE = "msg.cause.remiseCommerciale.creation.impossible.annee.cloture";

    /**
     * The constante MSG_CAUSE_REMISE_COMMERCIALE_UTILISABLE_PERIODE_SELECTIONNE
     */
    public static final String MSG_CAUSE_REMISE_COMMERCIALE_UTILISABLE_PERIODE_SELECTIONNE = "msg.cause.remiseCommerciale.utilisable.periode.selectionne";

    /**
     * The constante MSG_CAUSE_PERSISTING_REMISE_COMMERCIALE
     */
    public static final String MSG_CAUSE_PERSISTING_REMISE_COMMERCIALE = "persisting  RemiseCommercialeAyantDroit";

    /**
     * The constante REMISE_COMMERCIALE_UI_COUNT
     */
    public static final String REMISE_COMMERCIALE_UI_COUNT = "remiseCommercialeUI count :{} ";
    /**
     * The constante ALTER_SESSION_SET
     */
    public static final String ALTER_SESSION_SET = "ALTER SESSION SET nls_sort = 'French_M'";

    /**
     * The constante MSG_CAUSE_REMISE_REMISE_COMMERCIALE_OPT
     */
    public static final String MSG_CAUSE_REMISE_REMISE_COMMERCIALE_OPT = "msg.cause.get.remiseCommercialeOpt";

    /**
     * The constante REMISE_COMMERCIALE
     */
    public static final String REMISE_COMMERCIALE = "REMISE COMMERCIALE";

    /**
     * The constante MSG_CAUSE_GET_ALL_REMISE_COMMERCIALE
     */
    public static final String MSG_CAUSE_GET_ALL_REMISE_COMMERCIALE = "msg.cause.get.all.remiseCommerciale";

    /**
     * The constante MSG_CAUSE_GET_REGIME
     */
    public static final String MSG_CAUSE_GET_REGIME = "msg.cause.get.regime";

    /**
     * The Constant LOCALIZED_VENDEUR_TYPE
     */
    public static final String LOCALIZED_VENDEUR_TYPE = "msg.error.type.vendeur";

    /**
     * Error failed to create BencapAcceptation
     */
    public static final String ERROR_FAIL_CREATION_BENCAP_ACCEPTATION = "Failed to create Bencap Acceptation";

    /**
     * Error failed to create Courtier Bordereau
     */
    public static final String ERROR_FAIL_CREATION_COURTIER_BORDEREAU = "Failed to create Courtier Bordereau";

    /**
     * The constante MSG_CAUSE_DECOMPTE_CHANGEMENT_IMPOSSIBLE_EXISTE_DECOMPTES_VALIDES_PAYES_TIER
     */
    public static final String MSG_CAUSE_DECOMPTE_CHANGEMENT_IMPOSSIBLE_EXISTE_DECOMPTES_VALIDES_PAYES_TIER = "msg.cause.decompte.verify.sequence.changement.impossible.existe.décomptes.validés.payés.tiers";

    /**
     * The constante MSG_CAUSE_GET_DECOMPTE
     */
    public static final String MSG_CAUSE_GET_DECOMPTE = "msg.cause.get.decompte";

    /**
     * The constante ACTE_DECOMPTE
     */
    public static final String ACTE_DECOMPTE = "DECOMPTE";

    /**
     * The constante ACTE_DECOMPTE_RECEIVING_REQUEST_GET_LIST_ACTEVO_IDORGANISME
     */
    public static final String ACTE_DECOMPTE_RECEIVING_REQUEST_GET_LIST_ACTEVO_IDORGANISME = "Receiving request to get list ActeVO by idOrganisme : [{}] and idProduit : [{}]";


    /**
     * EXECUTE_PROCEDURE P_CHGCODETIERS
     */
    public static final String EXECUTE_PROCEDURE_P_CHGCODETIERS = "Execute procedure p_chgCodeTiers";
    /**
     * Procedure successfully executed
     */
    public static final String PROCEDURE_SUCCESSFULLY_EXECUTED = "Procedure successfully executed";

    /**
     * Error failed to updating code tiers
     */
    public static final String ERROR_FAIL_UPDATING_CODE_TIERS = "msg.cause.adc.probleme.Updating.Code.Tiers";


    /**
     *  The constante GET_ALL_TIERS_BY_ID
     */
    public static final String GET_ALL_TIERS_BY_ID = "msg.cause.get.all.tiers.byId";

    /**
     *  The constante GET_TIERS_MSG
     */
    public static final String GET_TIERS_MSG = "msg.cause.get.tiers";

    /**
     *  The constante GET_ALL_TIERS_BY_ID_OR_FINESS_MSG
     */
    public static final String GET_ALL_TIERS_BY_ID_OR_FINESS_MSG = "msg.cause.get.all.tiers.byIdOrFiness";

    /**
     *  The constante COUNT_LIST_OF_TIERS_MSG
     */
    public static final String COUNT_LIST_OF_TIERS_MSG = "count List of TiersBVO = {}";

    /**
     * Error while Duplicating.
     */
    public static final String ERROR_WHILE_DUPLICATING = "Error while duplicating : {} ";


    /**
     * The constante MSG_CAUSE_DECOMPTE_CHANGEMENT_IMPOSSIBLE_SEQUENCE_COURS_TIERS_CHANGER_CODE
     */
    public static final String MSG_CAUSE_DECOMPTE_CHANGEMENT_IMPOSSIBLE_SEQUENCE_COURS_TIERS_CHANGER_CODE = "msg.cause.decompte.verify.sequence.changement.impossible.cours.tier.changer.code.tiers";

    /**
     * The constante MSG_CAUSE_VENDEUR_SUPPRESSION_IMPOSSIBLE_VENDEUR_REFERENCE_GESTION_PRODUITS
     */
    public static final String MSG_CAUSE_VENDEUR_SUPPRESSION_IMPOSSIBLE_VENDEUR_REFERENCE_GESTION_PRODUITS = "msg.cause.vendeur.suppression.impossible.refrence.gestion.produit";

    /**
     * The constante MSG_CAUSE_DELETE_VENDEUR
     */
    public static final String MSG_CAUSE_DELETE_VENDEUR = "msg.cause.delete.vendeur";

    /**
     * The Constant LOCALIZED_ENTITY_TARIF_NEGOCIE.
     */
    public static final String LOCALIZED_ENTITY_TARIF_NEGOCIE = "msg.error.type.tarif.negocie";

    /**
     * Error while verification.
     */
    public static final String ERROR_WHILE_TEST = "Error while verification : {} ";

    /**
     * Error while creating.
     */
    public static final String LAUNCH_PROCESS_CREATING = "lunch creating : Tarif Negocie";

    /**
     * Error while updating.
     */
    public static final String LAUNCH_PROCESS_UPDATING = "lunch updating : Tarif Negocie";

    /**
     * The Constant MSG_CAUSE_TIERS_NOE_INVALID_DELETING
     */
    public static final String MSG_CAUSE_TIERS_NOE_INVALID_DELETING = "msg.cause.tier.noe.delete";

    /**
     * The constante MSG_CAUSE_TIERS_CHANGING_IMPOSSIBLE
     */
    public static final String MSG_CAUSE_TIERS_CHANGING_IMPOSSIBLE = "msg.cause.tiers.changing.impossible.code.tier";

    /**
     * The constante MSG_CAUSE_GET_TIER
     */
    public static final String MSG_CAUSE_GET_TIER = "msg.cause.get.tier";

    /**
     * The constante MSG_CAUSE_TARIF_NEGOCIE_ERROR_UPDATING
     */
    public static final String MSG_CAUSE_TARIF_NEGOCIE_ERROR_UPDATING = "msg.cause.tarif.negocie.error.updating";

    /**
     * The constante MSG_CAUSE_TARIF_NEGOCIE_ERROR_SAVING
     */
    public static final String MSG_CAUSE_TARIF_NEGOCIE_ERROR_SAVING = "msg.cause.tarif.negocie.error.saving";

    /**
     * The constante MSG_CAUSE_TARIF_NEGOCIE_ERROR_DELETING
     */
    public static final String MSG_CAUSE_TARIF_NEGOCIE_ERROR_DELETING = "msg.cause.tarif.negocie.error.deleting";

    /**
     * The constante MSG_CAUSE_TARIF_NEGOCIE_ERROR_DUPLATING
     */
    public static final String MSG_CAUSE_TARIF_NEGOCIE_ERROR_DUPLATING = "msg.cause.tarif.negocie.error.duplating";

    /**
     * The Constant LOCALIZED_ENTITY_CODE_TIER.
     */
    public static final String LOCALIZED_ENTITY_CODE_TIER = "msg.error.type.code.tier";

    /**
     * The constante ERROR_WHILE_CHANGINGff
     */
    public static final String ERROR_WHILE_CHANGING = "msg.error.changing.code";

    /**
     * The constante MSG_CAUSE_TARIF_NEGOCIE_ERROR_VERIFING_OVERLOAP_TARIF_NEGOCIE
     */
    public static final String MSG_CAUSE_TARIF_NEGOCIE_ERROR_VERIFING_OVERLOAP_TARIF_NEGOCIE = "msg.cause.tarif.negocie.error.verifing.overloap.tarif.negocie";

    /**
     * Error while locking
     */
    public static final String ERROR_WHILE_LOCKING = "Error while locking ";

    /**
     * Error while released
     */
    public static final String ERROR_WHILE_RELEASED = "Error while released ";

    /**
     * The Constant LOCALIZED_ENTITY_BORDEREAU.
     */
    public static final String LOCALIZED_ENTITY_BORDEREAU = "msg.error.type.bordereau";

    /**
     * The Constant LOCALIZED_ENTITY_BORDEREAU_DESTINATAIRE.
     */
    public static final String LOCALIZED_ENTITY_BORDEREAU_DESTINATAIRE = "msg.error.type.bordereau.destinataire";

    /**
     * The constante MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_DELETE
     */
    public static final String MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_CREATE = "msg.cause.bordereau.destinataire.error.create";

    /**
     * The constante MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_UPDATE
     */
    public static final String MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_UPDATE = "msg.cause.bordereau.destinataire.error.update";


    /**
     * The constante MSG_CAUSE_BORDEREAU_ERROR_DELETING
     */
    public static final String MSG_CAUSE_BORDEREAU_ERROR_DELETING = "msg.cause.bordereau.error.deleting";

    /**
     * The constante MSG_CAUSE_BORDEREAU_ERROR_VERROUILLE
     */
    public static final String MSG_CAUSE_BORDEREAU_ERROR_VERROUILLE = "msg.cause.bordereau.error.verrouille";
    /**
     * The constante MSG_CAUSE_BORDEREAU_ERROR_LIBERE
     */
    public static final String MSG_CAUSE_BORDEREAU_ERROR_LIBERE = "msg.cause.bordereau.error.libere";
    /**
     * The constante MSG_CAUSE_BORDEREAU_ERROR_UPDATING
     */
    public static final String MSG_CAUSE_BORDEREAU_ERROR_UPDATING = "msg.cause.bordereau.error.update";

    /**
     * The constante MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_DELETE
     */
    public static final String MSG_CAUSE_BORDEREAU_DESTINATAIRE_ERROR_DELETE = "msg.cause.bordereau.destinataire.error.delete";

    /**
     * The constante CREATION_USER_PROD
     */
    public static final String CREATION_USER_PROD = "Création impossible USERPROD ";

    /**
     * The constante CREATION_USER_ORG_DECOMPTEUSE
     */
    public static final String CREATION_USER_ORG_DECOMPTEUSE = "Création impossible USER_ORG_DECOMPTEUSE";

    /**
     * The constante DATA_ACCESS_EXCEPTION
     */
    public static final String DATA_ACCESS_EXCEPTION = "Firing DataAccessException ...";

    /**
     * The constante CLOSE_CURRENT_RS
     */
    public static final String CLOSE_CURRENT_RS = "Close current rs";

    /**
     * The constante ERROR_CLOSING_RS
     */
    public static final String ERROR_CLOSING_RS = "Error closing rs";

    /**
     * The constante ERROR_CLOSING_STATEMENT
     */
    public static final String ERROR_CLOSING_STATEMENT = "Error closing statement";

    /**
     * The constante COUNT_LIST.
     */
    public static final String COUNT_LIST = "Count list {}";

    /**
     * The constante RECEIVING_USER_NAME_COLUMN.
     */
    public static final String RECEIVING_USER_NAME_COLUMN = "Receiving User name columns";

    /**
     * The constante RECEIVING_DETAILS_FOR_TAB_EXCEL.
     */
    public static final String RECEIVING_DETAILS_FOR_TAB_EXCEL = "Receiving details for tab excel {}";

    /**
     * Constante pour logguer la reception d'une requête de sauvegarde.
     */
    public static final String RECEIVING_SAVE_REQUEST = "Receiving save request for {}";

    /**
     * Constante pour logger l'execution d'une procédure.
     */
    public static final String EXECUTE_PROCEDURE = "Execute procedure {}";

    /**
     * la constante CHECKING_SINISTRE_PERIOD_REMUN_HAS_DECOMPTE_PAYE_OR_NON_PAYE
     */
    public static final String CHECKING_SINISTRE_PERIOD_REMUN_HAS_DECOMPTE_PAYE_OR_NON_PAYE = "Checking if sinistre with id = {} has decompte payé ou non payé sur ses périodes remuns";

    /**
     * la constante DELETING_PERIOD_REMUN_AND_DECOMPTE
     */
    public static final String DELETING_PERIOD_REMUN_AND_DECOMPTE = "Deleting period remun et decompte inutile du sinistre avec l'id = {}";

    /**
     * Message pour une donnée non trouvée
     */
    public static final String DATA_NOT_FOUND = "msg.tech.general.error.data.notfound";

    /**
     * Message pour supprimer un decompte
     */
    public static final String DELETING_DECOMPTE_BY_ID = "Deleting decompte by ID= {}";

    /**
     * Message pour erreur de suppression decompte
     */
    public static final String ERROR_DELETING_DECOMPTE = "Failed to delete Decompte ...";

    /**
     * Message pour un groupe event non trouvée
     */
    public static final String GROUPEVENT_NOT_FOUND = "msg.cause.get.even.grp";

    /**
     * Constante INIT_QUERY_PARAMETERS
     */
    public static final String INIT_QUERY_PARAMETERS = "init query parameters";

    /**
     * Constante FAILED_TO_PARSE_DATE
     */
    public static final String FAILED_TO_PARSE_DATE = "Failed to parse date";

    /**
     * Message d'erreur lors de la recherche de l'indicateur Contrat d'Acces aux Soins
     */
    public static final String ERROR_RECHERCHE_IND_CONTRAT_ACCES_SOINS = "Erreur lors de la recherche de l'indicateur Contrat d'Acces aux Soins {} dans la formule";

    /**
     * Constante pour récupérer le résultat de la procédure ou de la fonction plsql
     */
    public static final String RESULT_PROCEDURE_FUNCTION = "Resultat  = [{}] ";

    /**
     * Message d'erreur lors de la récupération du nombre de lignes
     */
    public static final String FAILED_COUNT_NB_OPT_LINES_PARAM = "Failed to count number of option lines parametre...";

    /**
     * Message pour le recalcul des cotisations
     */
    public static final String MSG_RECALCUL_COTIS_GROUPE = "Recalcul des cotisations de ce groupe en cours...";

    /**
     * Constante FLUSH_MODIF_TO_DB
     */
    public static final String FLUSH_MODIF_TO_DB = "Flushing modifications to db";

    /**
     * Message lorsqu'on essaie de supprimer une donnée dans la BD
     */
    public static final String TRYING_TO_DELETE_OBJ_FROM_DB = "Trying to delete Object from Database";

    /**
     * Message pour la suppression d'une donnée dans la BD
     */
    public static final String OBJ_DELETED_FROM_DB = "Object has been deleted from Database";

    /**
     * Message d'erreur pour la période
     */
    public static final String CHECK_ERROR_PERIOD = "Check error : {} is not valid";


    /**
     * Message d'erreur pour la période
     */
    public static final String ERROR_DELETING_FRAIS_PARAM = "Error while deleting {} ";

    /**
     * Message lors de l'exécution d'une requête
     */
    public static final String EXECUTE_QUERY = "Executing query {}";

    /**
     * Message pour erreur de suppression d'un frais groupe param
     */
    public static final String ERROR_DELETING_FRAIS_GROUPE_PARAM = "Error while deleting {} ";

    /**
     * Message pour erreur de suppression d'un frais groupe param
     */
    public static final String ERROR_DELETING_FRAIS_GROUPE = "Error while deleting {} ";

    /**
     * Message pour erreur d'annulation d'un frais collectif
     */
    public static final String ERROR_CANCELING_FRAIS_GROUPE = "Error while canceling {} ";
}
