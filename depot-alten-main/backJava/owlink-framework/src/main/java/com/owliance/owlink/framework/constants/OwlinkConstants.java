/**
 * Copyright Owliance © 2016 - 2020 ,All right reserved
 * <p>
 * Owliance PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.owliance.owlink.framework.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe contenant toutes les constante de variable
 *
 * @author fmartinez
 * @since 0.1.5-Alpha
 *
 * Created : 11 juil 2016
 */
public final class OwlinkConstants implements java.io.Serializable {

    /**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 7017792688805070908L;

	/**
	 * The Constant SEPARATOR.
	 */
	public static final String SEPARATOR = "1";

	/**
	 * The Constant SEPARATOR2.
	 */
	public static final String SEPARATOR2 = "2";

	/**
	 * CRLF.
	 */
	public static final String CRLF_FRONT = "<br>";

	/**
	 * Request attibute.
	 */
	public static final String REQATTR_OWLINKCONTEXT = "OWLINKCONTEXT";

	/**
	 * Technical.
	 */
	public static final String MSGERR_TECHCONFIRM = "MSGERR_TECHCONFIRM";

	/**
	 * The Constant MSGERR_TECHINFO.
	 */
	public static final String MSGERR_TECHINFO = "MSGERR_TECHINFO";

	/**
	 * The Constant MSGERR_TECHWARN.
	 */
	public static final String MSGERR_TECHWARN = "MSGERR_TECHWARN";

	/**
	 * The Constant MSGERR_TECHERROR.
	 */
	public static final String MSGERR_TECHERROR = "MSGERR_TECHERROR";

	/**
	 * The Constant MSGERR_TECHSUCCESS.
	 */
	public static final String MSGERR_TECHSUCCESS = "MSGERR_TECHSUCCESS";

	/**
	 * The Constant MSGERR_BUSNCONFIRM.
	 */
	public static final String MSGERR_BUSNCONFIRM = "MSGERR_BUSNCONFIRM";

	/**
	 * The Constant UTILISATEUR_MODELE.
	 */
	public static final String UTILISATEUR_MODELE = "MODÈLE";
	/**
	 * The Constant UTILISATEUR_MODELE2.
	 */
	public static final String UTILISATEUR_MODELE2 = "MODELE";
	/**
	 * The Constant UTILISATEUR_UTILISATEUR.
	 */
	public static final String UTILISATEUR_UTILISATEUR = "utilisateur";

	/**
	 * The Constant MSGERR_BUSNINFO.
	 */
	public static final String MSGERR_BUSNINFO = "MSGERR_BUSNINFO";

	/**
	 * The Constant MSGERR_BUSNWARN.
	 */
	public static final String MSGERR_BUSNWARN = "MSGERR_BUSNWARN";

	/**
	 * The Constant MSGERR_BUSNERROR.
	 */
	public static final String MSGERR_BUSNERROR = "MSGERR_BUSNERROR";

	/**
	 * The Constant MSGERR_BUSNSUCCESS.
	 */
	public static final String MSGERR_BUSNSUCCESS = "MSGERR_BUSNSUCCESS";

	/**
	 * The Constant ID_PRODUIT_PREV
	 */
	public static final String ID_PRODUIT_PREV = "PREV";

	/**
	 * The Constant APP_NAME.
	 */
	public static final String APP_NAME = "OWLINK_WEB";

	/**
	 * The Constant APP_VERROU_PRIORITY_ONE.
	 */
	public static final Integer APP_VERROU_PRIORITY_ONE = 1;

	/**
	 * The Constant DEFAULT_DECIMALNUMBER.
	 */
	public static final Integer DEFAULT_DECIMALNUMBER = 2;

	/**
	 * The Constant DEP.
	 */
	public static final String DEP = "DEP";

	/**
	 * The Constant PUO.
	 */
	public static final String PUO = "PUO";

	/**
	 * The Constant TAC.
	 */
	public static final String TAC = "TAC";

	/**
	 * The Constant RRO.
	 */
	public static final String RRO = "RRO";

	/**
	 * The Constant QTE.
	 */
	public static final String QTE = "QTE";

	/**
	 * The Constant TOR.
	 */
	public static final String TOR = "TOR";

	/**
	 * The Constant TRO.
	 */
	public static final String TRO = "TRO";

	/**
	 * The Constant PMA.
	 */
	public static final String PMA = "PMA";

	/**
	 * The Constant PMB.
	 */
	public static final String PMB = "PMB";

	/**
	 * The Constant PMC.
	 */
	public static final String PMC = "PMC";

	/**
	 * The Constant TRO_HPDS.
	 */
	public static final String TRO_HPDS = "TRO_HPDS";

	/**
	 * The Constant RRO_HPDS.
	 */
	public static final String RRO_HPDS = "RRO_HPDS";

	/**
	 * The Constant PUN.
	 */
	public static final String PUN = "PUN";

	/**
	 * The Constant QTS.
	 */
	public static final String QTS = "QTS";

	/**
	 * The Constant RRP.
	 */
	public static final String RRP = "RRP";

	/**
	 * The Constant RMP.
	 */
	public static final String RMP = "RMP";
	/**
	 * The STATUS_BLOQUANT (BLOQUANT% 0).
	 */
	public static final Short STATUS_BLOQUANT = 0;

	/**
	 * The STATUS_PASSANT (PASSANT% 1).
	 */
	public static final Short STATUS_PASSANT = 1;

	/**
	 * The STATUS_FORCAGE (FORCABLE% 2).
	 */
	public static final Short STATUS_FORCAGE = 2;

	/**
	 * The STATUS_BLOQUANT_SUIVANT (BLOQUANTSUIVANT% 3).
	 */
	public static final Short STATUS_BLOQUANT_SUIVANT = 3;

	/**
	 * The Constant STATUS_INVISIBLE (INVISIBLE% 4).
	 */
	public static final Short STATUS_INVISIBLE = 4;

	/**
	 * The ERREUR_ORA.
	 */
	public static final Short ERREUR_ORA = 8;
	/**
	 * error 22.
	 */
	public static final Short ERREUR_22 = 22;
	/**
	 * error 21.
	 */
	public static final Short ERREUR_21 = 21;
	/**
	 * The ERREUR_30.
	 */
	public static final Short ERREUR_30 = 30;
	/**
	 * The ERREUR_33.
	 */
	public static final Short ERREUR_33 = 33;
	/**
	 * The ERREUR_35.
	 */
	public static final Short ERREUR_35 = 35;

	/**
	 * The ERREUR_40.
	 */
	public static final Short ERREUR_40 = 40;

	/**
	 * The ERREUR_41.
	 */
	public static final Short ERREUR_41 = 41;

	/**
	 * The ERREUR_42.
	 */
	public static final Short ERREUR_42 = 42;

	/**
	 * The ERREUR_43.
	 */
	public static final Short ERREUR_43 = 43;

	/**
	 * The ERREUR_44.
	 */
	public static final Short ERREUR_44 = 44;

	/**
	 * The ERREUR_45.
	 */
	public static final Short ERREUR_45 = 45;

	/**
	 * The ERREUR_46.
	 */
	public static final Short ERREUR_46 = 46;
	/**
	 * The ERREUR_50.
	 */
	public static final Short ERREUR_50 = 50;
	/**
	 * The ERREUR_60.
	 */
	public static final Short ERREUR_60 = 60;
	/**
	 * The ERREUR_61.
	 */
	public static final Short ERREUR_61 = 61;
	/**
	 * The ERREUR_64.
	 */
	public static final Short ERREUR_64 = 64;
	/**
	 * The ERREUR_65.
	 */
	public static final Short ERREUR_65 = 65;
	/**
	 * The ERREUR_66.
	 */
	public static final Short ERREUR_66 = 66;
	/**
	 * The ERREUR_67.
	 */
	public static final Short ERREUR_67 = 67;
	/**
	 * The ERREUR_68.
	 */
	public static final Short ERREUR_68 = 68;
	/**
	 * The ERREUR_70.
	 */
	public static final Short ERREUR_70 = 70;
	/**
	 * The ERREUR_71.
	 */
	public static final Short ERREUR_71 = 71;
	/**
	 * The ERREUR_72.
	 */
	public static final Short ERREUR_72 = 72;
	/**
	 * The ERREUR_73.
	 */
	public static final Short ERREUR_73 = 73;
	/**
	 * The ERREUR_81.
	 */
	public static final Short ERREUR_81 = 81;
	/**
	 * The ERREUR_82.
	 */
	public static final Short ERREUR_82 = 82;
	/**
	 * The ERREUR_85.
	 */
	public static final Short ERREUR_85 = 85;

	/**
	 * The ERREUR_88.
	 */
	public static final Short ERREUR_88 = 88;
	/**
	 * The ERREUR_90.
	 */
	public static final Short ERREUR_90 = 90;
	/**
	 * The ERREUR_92.
	 */
	public static final Short ERREUR_92 = 92;
	/**
	 * The ERREUR_93.
	 */
	public static final Short ERREUR_93 = 93;
	/**
	 * The ERREUR_95.
	 */
	public static final Short ERREUR_95 = 95;
	/**
	 * The ERREUR_94.
	 */
	public static final Short ERREUR_94 = 94;
	/**
	 * The ERREUR_96.
	 */
	public static final Short ERREUR_96 = 96;
	/**
	 * The ERREUR_100.
	 */
	public static final Short ERREUR_100 = 100;
	/**
	 * The ERREUR_101.
	 */
	public static final Short ERREUR_101 = 101;
	/**
	 * The ERREUR_102.
	 */
	public static final Short ERREUR_102 = 102;
	/**
	 * The ERREUR_113.
	 */
	public static final Short ERREUR_113 = 113;
	/**
	 * The ERREUR_114.
	 */
	public static final Short ERREUR_114 = 114;
	/**
	 * The ERREUR_115.
	 */
	public static final Short ERREUR_115 = 115;
	/**
	 * The ERREUR_116.
	 */
	public static final Short ERREUR_116 = 116;
	/**
	 * The ERREUR_117.
	 */
	public static final Short ERREUR_117 = 117;
	/**
	 * The ERREUR_118.
	 */
	public static final Short ERREUR_118 = 118;
	/**
	 * The ERREUR_119.
	 */
	public static final Short ERREUR_119 = 119;
	/**
	 * The ERREUR_125.
	 */
	public static final Short ERREUR_125 = 125;
	/**
	 * The ERREUR_130.
	 */
	public static final Short ERREUR_130 = 130;
	/**
	 * The ERREUR_131.
	 */
	public static final Short ERREUR_131 = 131;
	/**
	 * The ERREUR_134.
	 */
	public static final Short ERREUR_134 = 134;
	/**
	 * The ERREUR_136.
	 */
	public static final Short ERREUR_136 = 136;
	/**
	 * The ERREUR_137.
	 */
	public static final Short ERREUR_137 = 137;
	/**
	 * The ERREUR_138.
	 */
	public static final Short ERREUR_138 = 138;
	/**
	 * The ERREUR_149.
	 */
	public static final Short ERREUR_149 = 149;
	/**
	 * The ERREUR_152.
	 */
	public static final Short ERREUR_152 = 152;
	/**
	 * The ERREUR_206.
	 */
	public static final Short ERREUR_206 = 206;
	/**
	 * The ERREUR_210.
	 */
	public static final Short ERREUR_210 = 210;
	/**
	 * The ERREUR_211.
	 */
	public static final Short ERREUR_211 = 211;
	/**
	 * The ERREUR_211.
	 */
	public static final Short ERREUR_213 = 213;
	/**
	 * The ERREUR_215.
	 */
	public static final Short ERREUR_215 = 215;
	/**
	 * The ERREUR_300.
	 */
	public static final Short ERREUR_300 = 300;
	/**
	 * The ERREUR_303.
	 */
	public static final Short ERREUR_303 = 303;
	/**
	 * The ERREUR_306.
	 */
	public static final Short ERREUR_306 = 306;
	/**
	 * The Constant ERREUR_308.
	 */
	public static final Short ERREUR_308 = 308;
	/**
	 * The ERREUR_309.
	 */
	public static final Short ERREUR_309 = 309;
	/**
	 * The Constant ERREUR_311.
	 */
	public static final Short ERREUR_311 = 311;
	/**
	 * The Constant ERREUR_312.
	 */
	public static final Short ERREUR_312 = 312;
	/**
	 * The ERREUR_314.
	 */
	public static final Short ERREUR_314 = 314;
	/**
	 * The ERREUR_327.
	 */
	public static final Short ERREUR_327 = 327;
	/**
	 * The ERREUR_328.
	 */
	public static final Short ERREUR_328 = 328;
	/**
	 * The ERREUR_333.
	 */
	public static final Short ERREUR_333 = 333;
	/**
	 * The Constant ERREUR_339.
	 */
	public static final Short ERREUR_339 = 339;
	/**
	 * The Constant ERREUR_340.
	 */
	public static final Short ERREUR_340 = 340;
	/**
	 * The Constant ERREUR_341.
	 */
	public static final Short ERREUR_341 = 341;
	/**
	 * The ERREUR_342.
	 */
	public static final Short ERREUR_342 = 342;
	/**
	 * The Constant ERREUR_343.
	 */
	public static final Short ERREUR_343 = 343;
	/**
	 * The Constant ERREUR_360.
	 */
	public static final Short ERREUR_360 = 360;
	/**
	 * The ERREUR_362.
	 */
	public static final Short ERREUR_362 = 362;
	/**
	 * The Constant ERREUR_370.
	 */
	public static final Short ERREUR_370 = 370;
	/**
	 * The Constant ERREUR_380.
	 */
	public static final Short ERREUR_380 = 380;
	/**
	 * The Constant ERREUR_390.
	 */
	public static final Short ERREUR_390 = 390;
	/**
	 * The ERREUR_401.
	 */
	public static final Short ERREUR_401 = 401;
	/**
	 * The ERREUR_412.
	 */
	public static final Short ERREUR_412 = 412;
	/**
	 * The ERREUR_424.
	 */
	public static final Short ERREUR_424 = 424;
	/**
	 * The ERREUR_427.
	 */
	public static final Short ERREUR_427 = 427;
	/**
	 * The ERREUR_429.
	 */
	public static final Short ERREUR_429 = 429;
	/**
	 * The ERREUR_432.
	 */
	public static final Short ERREUR_432 = 432;
	/**
	 * The ERREUR_601.
	 */
	public static final Short ERREUR_601 = 601;
	/**
	 * The ERREUR_602.
	 */
	public static final Short ERREUR_602 = 602;
	/**
	 * The ERREUR_603.
	 */
	public static final Short ERREUR_603 = 603;
	/**
	 * The ERREUR_640.
	 */
	public static final Short ERREUR_640 = 640;
	/**
	 * The ERREUR_642.
	 */
	public static final Short ERREUR_642 = 642;
	/**
	 * The ERREUR_643.
	 */
	public static final Short ERREUR_644 = 644;
	/**
	 * The ERREUR_644.
	 */
	public static final Short ERREUR_643 = 643;
	/**
	 * The ERREUR_645.
	 */
	public static final Short ERREUR_645 = 645;
	/**
	 * The ERREUR_650.
	 */
	public static final Short ERREUR_650 = 650;
	/**
	 * The ERREUR_651.
	 */
	public static final Short ERREUR_651 = 651;
	/**
	 * The ERREUR_704.
	 */
	public static final Short ERREUR_704 = 704;
	/**
	 * The ERREUR_705.
	 */
	public static final Short ERREUR_705 = 705;
	/**
	 * The ERREUR_714.
	 */
	public static final Short ERREUR_714 = 714;
	/**
	 * The ERREUR_715.
	 */
	public static final Short ERREUR_715 = 715;
	/**
	 * The ERREUR_716.
	 */
	public static final Short ERREUR_716 = 716;
	/**
	 * the error 719.
	 */
	public static final Short ERREUR_719 = 719;
	/**
	 * The ERREUR_726.
	 */
	public static final Short ERREUR_726 = 726;
	/**
	 * The ERREUR_727.
	 */
	public static final Short ERREUR_727 = 727;
	/**
	 * The ERREUR_728.
	 */
	public static final Short ERREUR_728 = 728;
	/**
	 * The ERREUR_770.
	 */
	public static final Short ERREUR_770 = 770;
	/**
	 * The ERREUR_20001.
	 */
	public static final Integer ERREUR_20001 = 20001;
	/**
	 * The ERREUR_20002.
	 */
	public static final Integer ERREUR_20002 = 20002;

	/*
	 * Etat Prestation
	 */
	/**
	 * The Constant ETAT_PRESTATION_P. || Decompte P E C
	 */
	public static final String ETAT_PRESTATION_P = "P";

	/**
	 * The Constant ETAT_PRESTATION_D. || Decompte DEVIS
	 */
	public static final String ETAT_PRESTATION_D = "D";

	/**
	 * The Constant ETAT_PRESTATION_O. || Decompte PAYE
	 */
	public static final String ETAT_PRESTATION_O = "O";

	/**
	 * The Constant ETAT_PRESTATION_V. || Decompte PRE PAYE
	 */
	public static final String ETAT_PRESTATION_V = "V";

	/**
	 * The Constant ETAT_PRESTATION_A. || Decompte EN_Attente
	 */
	public static final String ETAT_PRESTATION_A = "A";

	/**
	 * The Constant ETAT_PRESTATION_A_ETOILE. || Decompte EN_Attente
	 */
	public static final String ETAT_PRESTATION_A_ETOILE = "A*";

	/**
	 * The Constant ETAT_PRESTATION_N. || Decompte VALIDE
	 */
	public static final String ETAT_PRESTATION_N = "N";

	/**
	 * The Constant ETAT_PRESTATION_N. || Decompte EN_SEQUENCE
	 */
	public static final String ETAT_PRESTATION_E = "E";
	/**
	 * The Constant ETAT_PRESTATION_PAYE. || Decompte Paye
	 */
	public static final String ETAT_PRESTATION_PAYE = "PAYE";

	/**
	 * The Constant DECOMPTEUSE_HOPITAL.
	 */
	public static final String DECOMPTEUSE_HOPITAL = "HOPITAL";

	/**
	 * The Constant DECOMPTEUSE_NOEMIE.
	 */
	public static final String DECOMPTEUSE_NOEMIE = "NOEMIE";

	/**
	 * The OPTIONNELLE.
	 */
	public static final String OPTIONNELLE = "O";

	/**
	 * The ANNUELLE.
	 */
	public static final String ANNUELLE = "A";

	/**
	 * The Constant LIST_TYPE_ACTE.
	 */
	public static final String LIST_TYPE_ACTE = "PFH,PFT,FRH,FRT";
	/**
	 * The Constant LIST_TYPE_ACTE_COMPLETE.
	 */
	public static final String LIST_TYPE_ACTE_COMPLETE = "PAT,PAS";
	/**
	 * the constante ESP .
	 */
	public static final String ESP = "ESP";

	/**
	 * The Acte_PRINCIPAL. Acte Principal
	 */
	public static final String ACTE_PRINCIPAL = "P";
	/**
	 * The Acte_ENCHAINE. Acte Enchaine
	 */
	public static final String ACTE_ENCHAINE = "E";
	/**
	 * The Constant ACTE_MULTI_OPTION. Acte Multi-Option
	 */
	public static final String ACTE_MULTI_OPTION = "M";

	/**
	 * The Constant OUI.
	 */
	public static final String OUI = "OUI";
	/**
	 * The Constant NON.
	 */
	public static final String NON = "NON";

	/**
	 * The Constant TYPE_REGLEMENT_NORMAL.
	 */
	public static final String TYPE_REGLEMENT_NORMAL = "N";
	/**
	 * The Constant TYPE_REGLEMENT_OBLIGATOIRE.
	 */
	public static final String TYPE_REGLEMENT_OBLIGATOIRE = "O";

	/**
	 * The Constant VIREMENT.
	 */
	public static final String VIREMENT = "VIR";
	/**
	 * The Constant CHEQUE.
	 */
	public static final String CHEQUE = "CHQ";

	/**
	 * constant message owlink handler status.
	 */
	public static final String ASKED = "ASKED";

	/**
	 * constant message owlink handler status.
	 */
	public static final String NOT_ASKED = "NOT_ASKED";

	/**
	 * constant defined of type message confirmation.
	 */
	public static final String TYPE_MESSAGE_CONFIRMATION = "CONFIRMATION";

	/**
	 * constant defined of type message blocage.
	 */
	public static final String TYPE_MESSAGE_BLOCAGE = "BLOCAGE";

	/**
	 * The Constant QUALITE_AYANT_DROIT_RESP.
	 */
	public static final String QUALITE_AYANT_DROIT_RESP = "RESP";

	/**
	 * The vv.
	 */
	public static final String DECOMPTEUSE_VV = "vv";
	/**
	 * The PHA.
	 */
	public static final String DECOMPTEUSE_PHA = "PHA";
	/**
	 * The B2.
	 */
	public static final String DECOMPTEUSE_B2 = "B2";
	/**
	 * The VIAM.
	 */
	public static final String DECOMPTEUSE_VIAM = "VIAM";
	/**
	 * The SERV.
	 */
	public static final String DECOMPTEUSE_SERV = "SERV";
	/**
	 * The HOP.
	 */
	public static final String DECOMPTEUSE_HOP = "HOP";
	/**
	 * The SV.
	 */
	public static final String DECOMPTEUSE_SV = "SV";
	/**
	 * The ISAN.
	 */
	public static final String DECOMPTEUSE_ISAN = "ISAN";
	/**
	 * The ALME.
	 */
	public static final String DECOMPTEUSE_ALME = "ALME";
	/**
	 * The constante ALL.
	 */
	public static final String ALL = "ALL";

	/**
	 * The NUMBER_0.
	 */
	public static final Integer NUMBER_0 = 0;
	/**
	 * The NUMBER_1.
	 */
	public static final Integer NUMBER_1 = 1;
	/**
	 * The NUMBER_2.
	 */
	public static final Integer NUMBER_2 = 2;
	/**
	 * The NUMBER_3.
	 */
	public static final Integer NUMBER_3 = 3;
	/**
	 * The NUMBER_4.
	 */
	public static final Integer NUMBER_4 = 4;
	/**
	 * The NUMBER_5.
	 */
	public static final Integer NUMBER_5 = 5;
	/**
	 * The NUMBER_7.
	 */
	public static final Integer NUMBER_7 = 7;
	/**
	 * The NUMBER_8.
	 */
	public static final Integer NUMBER_8 = 8;
	/**
	 * The NUMBER_9.
	 */
	public static final Integer NUMBER_9 = 9;
	/**
	 * The NUMBER_10.
	 */
	public static final Integer NUMBER_10 = 10;
	/**
	 * The NUMBER_14.
	 */
	public static final Integer NUMBER_14 = 14;
	/**
	 * The NUMBER_91.
	 */
	public static final String NUMBER_91 = "91";
	/**
	 * The NUMBER_92.
	 */
	public static final String NUMBER_92 = "92";
	/**
	 * The NUMBER_93.
	 */
	public static final String NUMBER_93 = "93";

	/**
	 * The Constant PRESTATION_STATUS_VALIDER.
	 */
	public static final String PRESTATION_STATUS_VALIDER = "V";

	/**
	 * The Constant PRESTATION_STATUS_DIFFERER.
	 */
	public static final String PRESTATION_STATUS_DIFFERER = "D";

	/**
	 * The Constant CLIENT_MIN.
	 */
	public static final String CLIENT_MIN = "LG_MIN_PWD";

	/**
	 * The Constant CLIENT_NUM.
	 */
	public static final String CLIENT_NUM = "NB_NUM_PWD";

	/**
	 * The Constant CLIENT_DELAI.
	 */
	public static final String CLIENT_DELAI = "DELAI_PWD";

	/**
	 * The Constant EMPRUNT.
	 */
	public static final Integer PRODUIT_TYPE_EMPRUNT = 4;

	/**
	 * Constant qui indique la valeur indicatif que l'utulisateur est un admin.
	 */
	public static final Integer EST_ADMIN = 1;

	/**
	 * Admin username and default oracle schema name.
	 *
	 * @deprecated do not use this schema or username in DAO, VO, services, etc.
	 */
	@Deprecated
	public static final String ADMIN = "MUTIX";

	/**
	 * Constant qui indique l'evenement est affectable.
	 */
	public static final Integer EVENT_AFFECTABLE = 1;
	/**
	 * The Constant F_M0351.
	 */
	public static final String F_M0351 = "F_M0351";

	/**
	 * The Constant F_M0352.
	 */
	public static final String F_M0352 = "F_M0352";

	/**
	 * The Constant F_M0367_EQPMT.
	 */
	public static final String F_M0367_EQPMT = "F_M0367_EQPMT";

	/**
	 * The Constant F_M0367_AUDIO.
	 */
	public static final String F_M0367_AUDIO = "F_M0367_AUDIO";

	/**
	 * The Constant G_NBDECIMALES Gestion des devises étrangères Precision aprés la
	 * virgule.
	 */
	public static final Integer G_NBDECIMALES = 2;

	/**
	 * the produce type application/json constant.
	 */
	public static final String APPLICATION_JSON = "application/json";

	/**
	 * The INIT_JRPREL_TYPE constant. It specify if the JR PRELEV should be
	 * generated or based on the preset values in the product table.
	 */
	public static final String INIT_JRPREL_TYPE = "E";

	/**
	 * The Constant MONTURE.
	 */
	public static final String MONTURE = "M";

	/**
	 * The Constant OEIL_DROIT.
	 */
	public static final String OEIL_DROIT = "OD";

	/**
	 * The Constant OEIL_GAUCHE.
	 */
	public static final String OEIL_GAUCHE = "OG";

	/**
	 * The Constant OEIL_DROIT_SUPPL.
	 */
	public static final String OEIL_DROIT_SUPPL = "SD01";

	/**
	 * The Constant OEIL_GAUCHE_SUPPL.
	 */
	public static final String OEIL_GAUCHE_SUPPL = "SG01";

	/**
	 * The Constant OREILLE_DROITE.
	 */
	public static final String OREILLE_DROITE = "ORD";

	/**
	 * The Constant OREILLE_GAUCHE.
	 */
	public static final String OREILLE_GAUCHE = "ORG";

	/**
	 * The Constant OREILLE_DROITE_ENTRETIEN.
	 */
	public static final String OREILLE_DROITE_ENTRETIEN = "ORDE";

	/**
	 * define the directory containing the garanties docs.
	 */
	public static final String TABLE_GARANTIES_DIRECTORY = "/home/aide/";

	/**
	 * The Constant OREILLE_GAUCHE_ENTRETIEN.
	 */
	public static final String OREILLE_GAUCHE_ENTRETIEN = "ORGE";

	/**
	 * définir l'identificateur du mode de règlement prélèvement bancaire.
	 */
	public static final String REGLEMENT_PRELEVEMENT = "PRL";

	/**
	 * définir l'identificateur du mode de règlement prélèvement bancaire.
	 */
	public static final String RIB_OBLIGATOIRE = "O";

	/**
	 * the GPROD_REGLT_MANDAT_EXISTANT constant.
	 */
	public static final int GPROD_REGLT_MANDAT_EXISTANT = 20706;

	/**
	 * the GPINFO_RUBRIQUE_CODE_GESTION constant.
	 */
	public static final String GPINFO_RUBRIQUE_CODE_GESTION = "Code gestion";

	/**
	 * the GPINFO_RUBRIQUE_CODE constant.
	 */
	public static final String GPINFO_RUBRIQUE_CODE = "Code";

	/**
	 * the GPINFO_RUBRIQUE_LETTRE_COTISATION constant.
	 */
	public static final String GPINFO_RUBRIQUE_LETTRE_COTISATION = "Lettre de cotisation";

	/**
	 * the GPINFO_RUBRIQUE_LETTRE constant.
	 */
	public static final String GPINFO_RUBRIQUE_LETTRE = "Lettre";

	/**
	 * The CLASS_VERRE constant.
	 */
	public static final String CLASS_VERRE = "CLASSVERRE";

	/**
	 * The TYPE_VERRE constant.
	 */
	public static final String TYPE_VERRE = "TYPEVERRE";

	/**
	 * The TYPE_TIERS constant.
	 */
	public static final String TYPE_TIERS = "TYPTIERS";

	/**
	 * The TIERS constant.
	 */
	public static final String TIERS = "TIERS";
	/**
	 * The VALEUR
	 */
	public static final String VALEUR = "VALEUR";

	/**
	 * The PONDERATION
	 */
	public static final String PONDERATION = "PONDERATION";
	/**
	 * The VALEUR_ID
	 */
	public static final Integer VALEUR_ID = 1;
	/**
	 * The VALEUR_TYPE_1
	 */
	public static final Integer VALEUR_TYPE_1 = 1;
	/**
	 * The VALEUR_TYPE_2
	 */
	public static final Integer VALEUR_TYPE_2 = 2;
	/**
	 * The VALEUR_TYPE_3
	 */
	public static final Integer VALEUR_TYPE_3 = 3;
	/**
	 * The VALEUR_NUM_FLUX
	 */
	public static final Integer VALEUR_NUM_FLUX = 16;
	/**
	 * The VALEUR_MAX_DATE_FIN
	 */
	public static final String VALEUR_MAX_DATE_FIN = "31/12/2999";

	/**
	 * The Constant TYPE_EMPLOYEUR.
	 */
	public static final String TYPE_EMPLOYEUR = "G";

	/**
	 * The Constant TYPE_SALARIER.
	 */
	public static final String TYPE_SALARIER = "S";

	/**
	 * The Constant TYPE_CE.
	 */
	public static final String TYPE_CE = "C";
	/**
	 * the constant id grp opt justif
	 */
	public static final Integer ID_GRP_OPT_JUSTIF = 47;

	/**
	 * the constant id gprod justif
	 */
	public static final Integer ID_GPROD_JUSTIF = 33;
	/**
	 * the constant final id gprod
	 */
	public static final Integer ID_GPROD = 332791;

	/**
	 * the constant final id prod justif
	 */
	public static final Integer ID_PROD_JUSTIF = 21;

	/**
	 * the constant final id prod justif
	 */
	public static final Integer ID_GRP_OPT = 332127;

	/**
	 * DELETE ACTION CONSTANT
	 */
	public static final String DELETE_ACTION = "DELETE";
	/**
	 * CREATE ACTION CONSTANT
	 */
	public static final String CREATE_ACTION = "CREATE";
	/**
	 * UPDATE ACTION CONSTANT
	 */
	public static final String UPDATE_ACTION = "UPDATE";
	/**
	 * Accepted exception id thrown by trigger after update fprod date radiation
	 * field
	 */
	public static final int GRP_TABLE_RADIATION_TRIGGER_ERROR = 1403;

	/**
	 * the catalog name PCK_DSN
	 */
	public static final String PCK_DSN = "PCK_DSN";

	/**
	 * the attribut name ID_DSN_VIRSEMENT
	 */
	public static final String ID_DSN_VIRSEMENT = "P_ID_DSN_VERSEMENT";

	/**
	 * The constant TOTAL_PAGES
	 */
	public static final Short TYPE_REPARTITION_MONTANT = 2;

	/**
	 * The constant TYPE_ENVOI
	 */
	public static final Short TYPE_ENVOI = 2;

	/**
	 * The constant TOTAL_PAGES
	 */
	public static final Short TYPE_REPARTITION_VENTILATION = 1;

	/**
	 * The constant BENCAP_CREATE_EVENT
	 */
	public static final String BENCAP_CREATE_EVENT = "Ajout d'un BENCAP";

	/**
	 * The constant BENCAP_UPDATE_EVENT
	 */
	public static final String BENCAP_UPDATE_EVENT = "Modification d'un BENCAP";

	/**
	 * The constant BENCAP_UPDATE_EVENT
	 */
	public static final String BENCAP_DELETE_EVENT = "Suppression d'un BENCAP";

	/** The Constant FAMILLE. */
	public static final String FAMILLE = "FAMILLE";

	/** The Constant ID_FAMILLE. */
	public static final String ID_FAMILLE = "idFamille";

	/** The Constant REFERENCE_BANCAIRE */
	public static final String REFERENCE_BANCAIRE = "REFERENCE BANCAIRE";

	/**
	 * AYANT Constant.
	 */
	public static final String AYANT_DROIT = "AYANT DROIT";

	/**
	 * The constant TUTELLE
	 */
	public static final Integer TUTELLE = Integer.valueOf(5);

	/**
	 * The constant TUTEUR
	 */
	public static final Integer TUTEUR = Integer.valueOf(6);

	/**
	 * The constant AUTRE
	 */
	public static final Integer AUTRE = Integer.valueOf(7);

	/**
	 * The constant MODIF_BENEF_TERRORISTE
	 */
	public static final String MODIF_BENEF_TERRORISTE = "BENCAP: Modification d'un bénéficiaire externe";

	/**
	 * The constant AJOUT_BENEF_TERRORISTE
	 */
	public static final String AJOUT_BENEF_TERRORISTE = "BENCAP: Saisie d'un bénéficiaire externe";

	/**
	 * The constant TYPE SINISTRE PJ OUVERTURE
	 */
	public static final String SINISTRE_PJ_TYPE_OUVERTURE = "O";

	/**
	 * The constant TYPE SINISTRE PJ OUVERTURE
	 */
	public static final String SINISTRE_PJ_TYPE_RENUMERATION = "R";

	/**
	 * The constant TYPE SINISTRE PJ VALIDE
	 */
	public static final String SINISTRE_PJ_VALIDE = "O";

	/**
	 * The constant TYPE SINISTRE PJ SANS OBJET
	 */
	public static final String SINISTRE_PJ_SANS_OBJET = "S";

	/**
	 * The constant TYPE SINISTRE PJ OUVERTURE
	 */
	public static final String SINISTRE_PJ_NON_VALIDE = "N";

	/**
	 * The constant Period renum valid oui
	 */
	public static final String PERIOD_RENUM_VALIDE_OUI = "OUI";
	/**
	 * The constant Period renum valid NON
	 */
	public static final String PERIOD_RENUM_VALIDE_NON = "NON";
	/**
	 * The constant SINSISTRE_PJ_VALIDE
	 */
	public static final String SINSISTRE_PJ_VALIDE = "1";

	/**
	 * The constant SINSISTRE_PJ_VALIDE
	 */
	public static final String SINSISTRE_PJ_VALIDE_O = "Oui";
	/**
	 * The constant SINSISTRE_PJ_VALIDE
	 */
	public static final String SINSISTRE_PJ_ETAT_SO = "S.O.";

	/**
	 * The constant p_ID_PRE
	 */
	public static final String P_ID_PRE = "p_ID_PRE";

	/**
	 * The constant header
	 */
	public static final String HEADER = "EURO";

	/**
	 * The constant variable
	 */
	public static final String VARIABLE = "NBDECIMALES";

	/**
	 * The constant PAS_COTISATION_A_REMBOURSER
	 */
	public static final String PAS_COTISATION_A_REMBOURSER = "Pas de cotisation à rembourser";

	/**
	 * The constant COTISATION_NON_PAYEE
	 */
	public static final String COTISATION_NON_PAYEE = "Cotisation non payée";

	/**
	 * The constant COTISATION_A_REMBOURSER_AVANT_LE
	 */
	public static final String COTISATION_A_REMBOURSER_AVANT_LE = "Cotisation à rembourser avant le";

	/**
	 * The constant COTISATION_A_REMBOURSER_ET_DELAI_DEPASSE
	 */
	public static final String COTISATION_A_REMBOURSER_ET_DELAI_DEPASSE = "Cotisation à rembourser et délai dépassé";

	/**
	 * The SINISTRE__EAGER_SORT_FIELD
	 */
	public static final List<String> SINISTRE_EAGER_SORT_FIELD = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("montantBrut", "montantNet",
			"montantPrelevSoc", "salaireTa", "salaireTb", "salaireTc", "entrepriseAdherente", "dateReglement",
			"nombreJours", "modePaiement", "ijss")));
	/**
	 * The UTILISATEUR_EAGER_SORT_FIELD
	 */
	public static final List<String> UTILISATEUR_EAGER_SORT_FIELD = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("organismeName", "idProduit",
			"nomProfil", "etatFilter", "typeModelNom", "pourModeleFilter", "adminUser", "habilitationPrevColFilter")));

	/**
	 * The constant ETAT_ADC_OK
	 */
	public static final String ETAT_ADC_OK = "OK";

	/**
	 * The constant ETAT_ADC_KO
	 */
	public static final String ETAT_ADC_KO = "KO";

	/** The constant for etat R/OK . */
	public static final String ETAT_R_OK = "R/OK";

	/** The constant for etat R/KO . */
	public static final String ETAT_R_KO = "R/KO";

	/** The constant for état I . */
	public static final String ETAT_I = "I";

	/**
	 * The Constant LOCALIZED_ENTITY_TYPE.
	 */
	public static final String LOCALIZED_ENTITY_TYPE = "msg.error.type.sinistrePeriodRemun";

	/**
	 * Constante pour l'etat de la demande de resiliation 1 (validée)
	 */
	public static final Integer ETAT_DEMANDE_1 = 1;
	/**
	 * Constante pour l'etat de la demande de resiliation 2 (validée avec indu)
	 */
	public static final Integer ETAT_DEMANDE_2 = 2;
	/**
	 * Constante pour l'etat de la demande de resiliation 3 (refusée)
	 */
	public static final Integer ETAT_DEMANDE_3 = 3;
	/**
	 * Constante pour l'etat de la demande de resiliation 4 (validée avec contentieux)
	 */
	public static final Integer ETAT_DEMANDE_4 = 4;
	/**
	 * Constante pour l'etat de la demande de resiliation 5 (annulée)
	 */
	public static final Integer ETAT_DEMANDE_5 = 5;
	/**
	 * Constante pour l'etat de la demande de resiliation 6 (validée mais retractée)
	 */
	public static final Integer ETAT_DEMANDE_6 = 6;
	/**
	 * The constant REFUSEE
	 */
	public static final String  REFUSEE = "Refusée";

	/**
	 * define the directory containing the notices RGPD docs.
	 */
	public static final String NOTICE_RGPD_DIRECTORY =  "/home/rgpd/";
	/**
	 * define the directory containing the CMU variable
	 */
	public static final String CMU_HAEDER =  "CMU";

	/**
	 * define the directory containing the DATE_CONTENTIEUX_CSS
	 */
	public static final String DATE_CONTENTIEUX_CSS =  "DATE_CONTENTIEUX_CSS";

	/**
	 * define the directory containing the DATE_MVT_S_F_408
	 */
	public static final String DATE_MVT_S_F_408 =  "DATE_MVT_S_F_408";

	/**
	 * status group with mix of HCGC and CGC product
	 */
	public static final String GROUPE_STATUS_MIXED_CGC = "mixedCGC";

	/**
	 * status group with only CGC product
	 */
	public static final String GROUPE_STATUS_ONLY_CGC = "onlyCGC";
	/**
	 * Status group with only HCGC product
	 */
	public static final String GROUPE_STATUS_ONLY_HCGC = "onlyNoCGC";
	/**
	 * Status group without product
	 */
	public static final String GROUPE_STATUS_NO_VALUE = "noValue";
	/**
	 * Status product CGC
	 */
	public static final String STATUS_CGC = "O";
	/**
	 * status product HCGC
	 */
	public static final String STATUS_HCGC = "N";

	/**
	 * Constante mutuelle concurrente pour le logger
	 */
	public static final String MUTUELLE_CONCURRENTE = "MUTUELLE CONCURRENTE";

	/**
	 * Constante du code état d'une ria Acceptée et traitée
	 */
	public static final String ACC_TRT = "ACC_TRT";

	/**
	 * Constante du code état d'une ria Acceptée en attente de traitement
	 */
	public static final String ACC_ATT = "ACC_ATT";

	/**
	 * Constante du numero de rubrique DSN pour la rubrique Nature DSN
	 */
	public static final String DSN_RUBRIQUE_NATURE = "05.001";

	/**
	 * Constante pour le nom d'un component Angular
	 */
	public static final String COMP_NAME = "component name";

	/**
	 * Constante pour un Id Unique
	 */
	public static final String ID_UNIQUE = "ID_UNIQUE";

	/**
	 * Constante pour un Id de Fenêtre
	 */
	public static final String ID_FEN = "ID_FEN";

	/**
	 * Constante pour un Id acces de Meta Groupe
	 */
	public static final String ID_ACCES = "ID_ACCES";

	/**
	 * Constante pour un Id groupe de Meta Groupe
	 */
	public static final String ID_GROUPE = "ID_GROUPE";

	/**
	 * Constante pour un groupe Mere
	 */
	public static final String GROUPE_MERE = "M";

	/**
	 * Constante pour un groupe filiale
	 */
	public static final String GROUPE_FILIALE = "F";

	/**
	 * Constante pour le statut du contrat RESIL.
	 */
	public static final String RESIL = "RESIL";

	/**
	 * Constante du mode d'édition des courriers BDoc en webservice.
	 */
	public static final String MODE_EDITION_WEBSERVICE = "WEBSERVICE";

	/**
	 * Constante de l'outil BDOC dans les courriers.
	 */
	public static final String COUR_OUTIL_BDOC = "4";

	/**
	 * Constante pour le type de courrier d'appel de cotisation.
	 */
	public static final String COUR_TYPE_APPEL_COT_COLL_BATCH = "APPEL_COT_COLL_BATCH";

	/**
	 * Constante des courrier de type groupe (destinataire).
	 */
	public static final String COUR_DEST_GROUPE = "G";

	/**
	 * Constante pour récupérer uniquement les courriers tagués comme à afficher.
	 */
	public static final String COUR_AFFICH = "1";

	/**
	 * Constante pour récupérer centre de famille.
	 */
	public static final String CENTRE_FAMILLE = "CENTRE";

	/**
	 * Constante pour récupérer identifiant centre de famille.
	 */
	public static final String ID_CENTRE_FAMILLE = "idCentre";

	/**
	 * Constante pour gprod libelle.
	 */
	public static final String GPROD_LIBELLE = "GPROD";

	/**
	 * Constante pour la clé de total pour le portefeuille d'adhérent
	 */
	public static final String TOTAL_KEY = "total";

	/**
	 * Constante pour le total du portefeuille d'adhérent
	 */
	public static final String TOTAL = "Total";

	/**
	 * Constante pour la clé des lignes KO pour le portefeuille d'adhérent
	 */
	public static final String KO_KEY = "ko";

	/**
	 * Constante pour les lignes KO du portefeuille d'adhérent
	 */
	public static final String KO = "KO";

	/**
	 * Constante pour la clé des lignes Non renseigné pour le portefeuille d'adhérent
	 */
	public static final String NON_RENSEIGNE_KEY = "nonRenseigne";

	/**
	 * Constante pour les lignes non renseigné du portefeuille d'adhérent
	 */
	public static final String NON_RENSEIGNE = "Non renseigné";

	/**
	 * Constante pour la clé des lignes Non conforme pour le portefeuille d'adhérent
	 * ou sinon le code du retour FM null
	 */
	public static final String ZERO_KEY = "0";


	/**
	 * The Constant FRANCE
	 */
	public static final String FRANCE_VALUE = "FRANCE";

	/**
	 * The Constant CLIENT_MME
	 */
	public static final String CLIENT_MME = "MME";

	/**
	 * The Constant CLIENT_MMA
	 */
	public static final String CLIENT_MMA = "MMA";

	/**
	 * The Constant CLIENT_LMDE
	 */
	public static final String CLIENT_LMDE = "LMDE";

	/**
	 * The Constant UNLOCK_USER
	 */
	public static final String UNLOCK_USER = "UNLOCK";


	/**
	 * The Constant LOCK_USER
	 */
	public static final String LOCK_USER = "LOCK";

	/**
	 * The Constant NEW_PWD
	 */
	public static final String NEW_PWD = "NEW PASSWORD";

	/**
	 * The Constant RESET_PWD
	 */
	public static final String RESET_PWD = "RESET PASSWORD";
	/**
	 * The Constant LOCK_USER
	 */
	public static final String RESET_ACCOUNT = "RESET ACCOUNT";
	/**
	 * The Constant LOCK_USER
	 */
	public static final String RESET_PWD_REQUEST = "RESET PWD REQUEST";
    /**
     * The Constant CLIENT_DELAIS_PASSWORD.
     */
    public static final String CLIENT_DELAIS_PASSWORD = "DELAI_PWD";
	/**
	 * The Constant CLIENT_DELAIS_INACTIVITE.
	 */
    public static final String CLIENT_DELAIS_INACTIVITE = "JOUR_INACTIF";

    /**
     * The Constant PASSWORD.
     */
    public static final String PASSWORD = "OwlPWD01";

    /**
     * The Constant USERNAME.
     */
    public static final String USERNAME = "userName";

    /**
     * The Constant USERID.
     */
    public static final String USERID = "idUser";

	/**
	 * The Constant TRACE_COMMENTAIRE_AJOUT.
	 */
	public static final String TRACE_COMMENTAIRE_AJOUT = "Ajout";

	/**
	 * The Constant TRACE_COMMENTAIRE_DELETE.
	 */
	public static final String TRACE_COMMENTAIRE_DELETE = "Suppression";

	/**
	 * The Constant LIBELLE.
	 */
	public static final String LIBELLE = "LIBELLE";

	/**
	 * The Constant ONE.
	 */
	public static final String ONE = "1";

	/**
	 * The Constant ZERO.
	 */
	public static final String ZERO = "0";

	/**
	 * The Constant EXCLUE.
	 */
	public static final String EXCLUE = "exclue";

	/**
	 * The Constant DEFAUT.
	 */
	public static final String DEFAUT = "DEFAUT";

	/**
	 * The Constant TAB_USER.
	 */
	public static final String TAB_USER = "UTILISATEUR";

	/**
	 * The Constant TAB_PROFIL.
	 */
	public static final String TAB_PROFIL = "PROFIL";

	/**
	 * The Constant TAB_MODEL.
	 */
	public static final String TAB_MODEL = "MODELE";

	/**
	 * The Constant TAB_PRODUIT.
	 */
	public static final String TAB_PRODUIT = "PRODUIT";

	/**
	 * The Constant TAB_ORGANISME.
	 */
	public static final String TAB_ORGANISME = "ORGANISME";

	/**
	 * The Constant TAB_AGENCE.
	 */
	public static final String TAB_AGENCE = "AGENCE";

	/**
	 * The Constant TAB_ENTREPRISE.
	 */
	public static final String TAB_ENTREPRISE = "ENTREPRISE";

	/**
	 * The Constant TAB_DECOMPTEUSE.
	 */
	public static final String TAB_DECOMPTEUSE = "DECOMPTEUSE";

	/**
	 * The Constant TAB_HABILITATION.
	 */
	public static final String TAB_HABILITATION = "HABILITATION";

	/**
	 * The Constant TAB_REQUETE.
	 */
	public static final String TAB_REQUETE = "REQUETE";

	/**
	 * The Constant TAB_MENU.
	 */
	public static final String TAB_MENU = "MENU";

	/**
	 * The Constant TAB_COURRIER.
	 */
	public static final String TAB_COURRIER = "COURRIER";

	/**
	 * The Constant CODE_USER.
	 */
	public static final String CODE_USER = "Code utilisateur";

	/**
	 * The Constant FULL_NAME_USER.
	 */
	public static final String FULL_NAME_USER = "Nom complet utilisateur";

	/**
	 * The Constant TYPE.
	 */
	public static final String TYPE = "Type";

	/**
	 * The Constant EMAIL.
	 */
	public static final String EMAIL = "Email";

	/**
	 * The Constant TELEPHONE.
	 */
	public static final String TELEPHONE = "Téléphone";

	/**
	 * The Constant CONSEIL_BY_DEFAULT.
	 */
	public static final String CONSEIL_BY_DEFAULT = "Conseil par défaut";

	/**
	 * The Constant EST_ADMINISTRATEUR.
	 */
	public static final String EST_ADMINISTRATEUR = "Est administrateur";

	/**
	 * The Constant HABILIT_PREV.
	 */
	public static final String HABILIT_PREV = "Habilitation prévoyance";

	/**
	 * The Constant A_POUR_MODEL.
	 */
	public static final String A_POUR_MODEL = "A pour modèle";

	/**
	 * The Constant A_POUR_MODEL.
	 */
	public static final Integer DEFAULT_ORG_ID = 0;

    /**
     * The Constant tDsnFicParamXml.
     */
    public static final String TDSNFICPARAM_XML = "tDsnFicParamXml";

    /**
     * The Constant idDsnFicParam.
     */
    public static final String DSNFICPARAM = "DsnFicParam";
    /**
     * Constante pour la clé des lignes Non conforme pour le portefeuille d'adhérent
     * C'est l'identifiant du retour fm null
     */
    public static final String NULL_RETOUR_KEY = "804";

    /**
     * Constante pour les lignes non conforme du portefeuille d'adhérent
     */
    public static final String NON_CONFORME = "Non conforme";

	/**
	 * Constante pour les retour FM
	 */
	public static final String RETOUR_FM = "RETOUR_FM";

	/**
	 * Constante Accepté avec surprime pour le RETOUR_FM.
	 */
	public static final String RETOUR_FM_ACCEPTE_AVEC_SURPRIME = "Accepté avec surprime";

	/**
	 * Constante Accepté sans surprime pour le RETOUR_FM.
	 */
	public static final String RETOUR_FM_ACCEPTE_SANS_SURPRIME = "Accepté sans surprime";

	/**
	 * Constante Refusé pour le RETOUR_FM.
	 */
	public static final String RETOUR_FM_REFUSE = "Refusé";

	/**
	 * Constante lorsqu'il n'y a pas de retour fm
	 */
	public static final String AUCUN = "Aucun";

	/**
	 * Constante du code de l'avis de cellule médicale
	 */
	public static final String CODE_AVIS_MEDICAL = "AVFM";

	/**
	 * Constante du mode de valorisation cotisation civil
	 */
	public static final String MODE_VALORISATION_COT_CIVIL = "C";

	/**
	 * Constante du mode de valorisation cotisation echeance
	 */
	public static final String MODE_VALORISATION_COT_ECHEANCE = "E";

	/**
	 * Constante du format date pour les soldes
	 */
	public static final String SOLDE_DATE_FORMAT = "dd-MM-yyyy";

	/**
	 * Constante du type de jeton de sécurité
	 */
	public static final String REPONSE_TOKEN_TYPE = "token_type";

	/**
	 * Constante du jeton de sécurité
	 */
	public static final String REPONSE_TOKEN_ACCESS = "access_token";

	/**
	 * Constante du chemin json de l'identifiant GED
	 */
	public static final String CHEMIN_JSON_ID_GED = "$.document.proprietesGed.id";

	/**
	 * Constante du nom du paramètre pour l'url du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_URL = "CE_URL";

	/**
	 * Constante du nom du paramètre pour le service d'authentification du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_SERVICE_AUTH = "CE_SERVICE_AUTH";

	/**
	 * Constante du nom du paramètre pour le service de génération BDoc du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_SERVICE_BDOC_WS = "CE_SERVICE_BDOC_WS";

	/**
	 * Constante du nom du paramètre pour le service de mise en GED du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_STORE_GED_WS = "CE_STORE_GED_WS";

	/**
	 * Constante du nom du paramètre pour le login du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_LOGIN = "CE_LOGIN";

	/**
	 * Constante du nom du paramètre pour le mot de passe du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_PASS = "CE_PASS";

	/**
	 * Constante du nom du paramètre pour la version BDoc du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_BDOC_VERSION = "CE_BDOC_VERSION";

	/**
	 * Constante du nom du paramètre pour la version GED du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_GED_VERSION = "CE_GED_VERSION";

	/**
	 * Constante du nom du paramètre pour la version PRINT du connecteur éditique.
	 */
	public static final String PARAM_CODE_CE_PRINT_VERSION = "CE_PRINT_VERSION";

	/**
	 * Constantes decrivant si un mouvement de type encaissement contient une part Entreprise, Salarié ou CE
	 */
	/**
	 * Part salarie
	 */
	public static final String TYPE_ENCAISSEMENT_SALARIE = "S";
	/**
	 * Part entreprise
	 */
	public static final String TYPE_ENCAISSEMENT_ENTREPRISE = "G";
	/**
	 * Part CE
	 */
	public static final String TYPE_ENCAISSEMENT_CE = "C";

	/**
	 * Constantes decrivant l'etat d'un mouvement
	 */
	/**
	 * Mouvement cree
	 */
	public static final Integer ETAT_MVT_CREE = 0;
	/**
	 * Mouvement imprime
	 */
	public static final Integer ETAT_MVT_IMPRIME = 1;
	/**
	 * Mouvement affecte et non imprime
	 */
	public static final Integer ETAT_MVT_AFFECTE_NON_IMPRIME = 2;
	/**
	 * Mouvement affecte et imprime
	 */
	public static final Integer ETAT_MVT_AFFECTE_IMPRIME = 3;

	/**
	 * Constantes indiquant si toutes les lignes d'un mouvement ont été imprimees
	 */
	/**
	 * Imprime
	 */
	public static final String ETAT_MVT_NON_IMPRIME = "N";
	/**
	 * Non imprime
	 */
	public static final String ETAT_MVT_TOUS_IMPRIME = "O";

	/**
	 * Mouvement de type Appel
	 */
	public static final String TYPE_MVT_APPEL = "A";
	/**
	 * Mouvement de type Encaissement
	 */
	public static final String TYPE_MVT_ENCAISSEMENT = "E";
	/**
	 * Mouvement de type Regularisation
	 */
	public static final String TYPE_MVT_REGULARISATION = "R";

	/**
	 * Constante pour le module Convention TPG
	 */
	public static final String CONVENTIONTPG = "CONVENTION TPG";

	/**
	 * Constante pour le module Convention ROC
	 */
	public static final String CONVENTION_ROC = "CONVENTION_ROC";

	/**
	 * Constante pour le module Convention Assurance
	 */
	public static final String CONVENTION_ASSURANCE = "CONVENTION ASSURANCE";

	/**
	 * Constante pour le nom du menu extraction fabrication
	 */
	public static final String EXTRACT_FAB = "M_EXTRACT_FAB";

	/**
	 * Constante pour le header RGPD de la table client
	 */
	public static final String RGPD = "RGPD";

	/**
	 * Constante pour le nom de la variable texte d'alerte du RGPD dans la table client
	 */
	public static final String RGPD_MESS_ALERT = "MESS_AVERT";

	/**
	 * Constante pour le code de l'état de l'événement rectificatif
	 */
	public static final String DSN_EVT_RECT_CODE_ETAT_INSTRUIRE = "1";

	/**
	 * Constante pour le code de l'état de l'événement rectificatif
	 */
	public static final String DSN_EVT_RECT_CODE_ETAT_ACQUITTE = "2";

	/**
	 * Constante pour le code de l'état de l'événement rectificatif
	 */
	public static final String DSN_EVT_RECT_LIB_ETAT_INSTRUIRE = "À instruire";

	/**
	 * Constante pour le code de l'état de l'événement rectificatif
	 */
	public static final String DSN_EVT_RECT_LIB_ETAT_ACQUITTE = "Acquitté";

	/**
	 * Constante pour le code de l'état de l'événement rectificatif
	 */
	public static final String DSN_EVT_RECT_LIB_ETAT_NULL = "-";

	/**
	 * Constante pour la dsn envoi réel
	 */
	public static final String DSN_ENVOI_REEL = "Réel";

	/**
	 * Constante pour la dsn envoi test
	 */
	public static final String DSN_ENVOI_TEST = "Test";

	/**
	 * Constante pour la dsn envoi autre
	 */
	public static final String DSN_ENVOI_INCONNU = "Inconnu";

	/**
	 * Constante pour résultat intégration équivalent status from tt_trt_dsn.
	 */
	public static final String DSN_RESULTAT_INTEGRATION_OK = "-";

	/**
	 *  Constante pour résultat intégration équivalent status from tt_trt_dsn.
	 */
	public static final String DSN_RESULTAT_INTEGRATION_KO = "KO";

	/**
	 *  Constante pour résultat intégration équivalent status from tt_trt_dsn.
	 */
	public static final String DSN_RESULTAT_INTEGRATION_REJET_METIER = "Rejet Métier";
	/**
	 * Constante pour récupérer le libelle à partir de la table constante.
	 */
	public static final String MS_PARAM_TARIF = "MS_PARAM_TARIF";

	/**
	 * Constante pour une chaîne de caractère vide
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * Constante  pour le message d'erreur mots de passe différents
	 */
    public static final String MSG_ERROR_MOT_DE_PASSE_DIFFERENTS = "msg.error.mot.de.passe.differents";
	/**
	 * Constante de la pièce d'ouverture d'un sinistre
	 */
	public static final String SINISTRE_PJO = "SINISTRE PJO";

	/**
	 * Constante pour le type de paramètre
	 */
    public static final String PARAMETRAGE_PARAM_VARCHAR = "VARCHAR2";

	/**
	 * Constante pour le type de paramètre
	 */
    public static final String PARAMETRAGE_PARAM_NUMBER = "NUMBER";

	/**
	 * Constante pour le type de paramètre
	 */
    public static final String PARAMETRAGE_PARAM_BIGDECIMAL = "BIGDECIMAL";

	/**
	 * Constante pour le type de paramètre
	 */
    public static final String PARAMETRAGE_PARAM_DATE = "DATE";
	/**
	 * Constante PROV pour le code statut.
	 */
	public static final String CODE_STATUT_PROV = "PROV";

	/**
	 * Constante VALID pour le code statut.
	 */
	public static final String CODE_STATUT_VALID = "VALID";

	/**
	 * Constante AFNF pour le code statut.
	 */
	public static final String CODE_STATUT_AFNF = "AFNF";

	/**
	 * Constante AFIL pour le code statut.
	 */
	public static final String CODE_STATUT_AFIL = "AFIL";

	/**
	 * Constante REFM pour le code statut.
	 */
	public static final String CODE_STATUT_REFM = "REFM";

	/**
	 * Constante pour les lignes de solde antérieur de la ventilation automatique
	 */
	public static final String VENTILATION_AUTO_FIRST_ECH = "firstEcheance";

	/**
	 * Constante pour les lignes de solde antérieur de la ventilation automatique
	 */
	public static final String VENTILATION_AUTO_LAST_ECH = "lastEcheance";

	/**
	 * Constante COUNT_DROIT_OUVERT_BY_AYANTDROIT_AND_PERIOD pour les logs
	 */
	public static final String COUNT_DROIT_OUVERT_BY_AYANTDROIT_AND_PERIOD = "COUNT_DROIT_OUVERT_BY_AYANTDROIT_AND_PERIOD";

	/**
	 * Constante FIND_MAX_ADC_DATE_RADIATION pour les logs
	 */
	public static final String FIND_MAX_ADC_DATE_RADIATION = "FIND_MAX_ADC_DATE_RADIATION  & getting result data";

	/**
	 * Constante TARIF_CODE
	 */
	public static final String TARIF_CODE = "tarifCode";

	/**
	 * Constante TIERS_NOT_FOUND
	 */
	public static final String TIERS_NOT_FOUND = "tiers not found";

	/**
	 * Constante pour le message d'erreur update period rémuneration
	 */
	public static final String MSG_ERROR_UPDATE_PERIOD_REMUN = "msg.error.update.period.remun.failure";

	/**
	 * Constante pour le message d'erreur update period rémuneration
	 */
	public static final String MSG_ERROR_CREATE_PERIOD_REMUN = "msg.error.create.period.remun.failure";

	/**
	 * Constante pour le message d'erreur delete sinistre pathologie
	 */
	public static final String MSG_ERROR_DELETE_SINISTRE_PATHOLOGIE = "msg.cause.delete.sinistre.pathologie";


	/**
	 * Constante pour le message d'erreur while deleting reglement ID
	 */
	public static final String MSG_ERROR_WHILE_DELETING_REGLT_ID = "Error while deleting reglement ID: [{}]";

	/**
	 * Constante pour le message d'erreur règlement fp not found
	 */
	public static final String MSG_ERROR_REGLT_FP_NOT_FOUND = "reglement fp not found";

	/**
	 * Constante représentant le groupe connexion dans la table client
	 */
	public static final String HEADER_CONNEXION = "CONNEXION";

	/**
	 * Constante représentant la variable de gestion des habilitations dans la table client
	 */
	public static final String VARIABLE_TOP_NOUV_HABIL = "TOP_NOUV_HABIL";

	/**
	 * Constante pour le message d'erreur delete d'un frais param
	 */
	public static final String MSG_ERROR_DELETE_FRAIS_PARAM = "msg.error.frais.param.delete";

	/**
	 * Constante pour le message d'erreur delete d'un frais param déjà affecté
	 */
	public static final String MSG_ERROR_DELETE_FRAIS_PARAM_AFFECTE = "Suppression impossible, le frais collectif est déjà affecté à des contrats collectifs.";

	/**
	 * Constante pour le message d'erreur save d'un frais param pour cause de doublon
	 */
	public static final String MSG_ERROR_SAVE_FRAIS_PARAM_DOUBLON = "msg.error.save.frais.param.doublon.id";

	/**
	 * Constante pour le message d'erreur save d'un frais param
	 */
	public static final String MSG_ERROR_SAVE_FRAIS_PARAM = "msg.error.save.frais.param";

	/**
	 * Constante représentant le mode de recalcul par défaut pour les frais
	 */
	public static final String FRAIS_MODE_RECALCUL_CODE = "I";

	/**
	 * Constante pour le message d'erreur save d'un frais groupe param pour cause de doublon
	 */
	public static final String MSG_ERROR_SAVE_FRAIS_GROUPE_PARAM_DOUBLON = "msg.error.save.frais.groupe.param.doublon.id";

	/**
	 * Constante pour le message d'erreur save d'un frais groupe param
	 */
	public static final String MSG_ERROR_SAVE_FRAIS_GROUPE_PARAM = "msg.error.save.frais.groupe.param";


	/**
	 * Constante pour le message d'erreur save d'un frais récurrent
	 */
	public static final String MSG_ERROR_SAVE_FRAIS_RECURRENT = "msg.error.save.frais.recurrent";

	/**
	 * Constante pour le message d'erreur delete d'un frais groupe param
	 */
	public static final String MSG_ERROR_DELETE_FRAIS_GROUPE_PARAM = "msg.error.frais.groupe.param.delete";

	/**
	 * Constante pour le message d'erreur delete d'un frais groupe param
	 */
	public static final String MSG_ERROR_DELETE_FRAIS_GROUPE = "msg.error.frais.groupe.delete";

	/**
	 * Constante pour le message d'erreur lors du calcul du montant total du frais colletcif
	 */
	public static final String MSG_ERROR_FRAIS_GROUPE_PARAM_CALCUL_MONTANT = "msg.error.frais.groupe.param.calcul.montant";

	/**
	 * Constante pour le message d'erreur lors de l'annalutaion d'un frais collectif
	 */
	public static final String MSG_ERROR_FRAIS_GROUPE_ANNULATION = "msg.error.frais.groupe.delete";

}
