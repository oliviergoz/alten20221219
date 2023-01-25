/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p> Owliance PROPRIETARY/CONFIDENTIAL. Use
 * is subject to license terms.
 */
package com.owliance.owlink.bvo;
// Generated 26 avr. 2016 17:24:18 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.Date;

import com.owliance.owlink.framework.entity.BaseBVO;


/**
 *
 * class ActeRemboursementBVO.java
 *
 * @author hbenizid
 * @since 0.5.9-Alpha
 *
 * @see com.owliance.owlink.bvo
 *
 *      <p>
 *      Created : 6 déc. 2017
 *      <p>
 *      Updated : 6 déc. 2017 by hbenizid (version 0.5.9-Alpha)
 *
 */
public class ActeRemboursementBVO extends BaseBVO implements java.io.Serializable {

	/**
	 * long
	 */
	private static final long serialVersionUID = 107220224324315194L;

	/**
	 * The id.
	 */
	// private Integer idActrbt
	private Integer			  id;

	/**
	 * The id produit.
	 */
	// private String idProd
	private String				  idProduit;

	/**
	 * The id act.
	 */
	private String				  idAct;

	/**
	 * The date effet.
	 */
	// private Date rbtDateffet
	private Date				  dateEffet;

	/**
	 * The quantite.
	 */
	// private Short rbtQte
	private Short				  quantite;

	/**
	 * The acte.
	 */
	// private String rbtAct
	private String				  acte;

	/**
	 * The montant.
	 */
	// private BigDecimal rbtMt
	private BigDecimal		  montant;

	/**
	 * The rbt P.
	 */
	private BigDecimal		  rbtP;

	/**
	 * The rbt pmsst.
	 */
	private String				  rbtPmsst;

	/**
	 * The rbt pu.
	 */
	private BigDecimal		  rbtPu;

	/**
	 * The taux.
	 */
	// private BigDecimal rbtTaux
	private BigDecimal		  taux;

	/**
	 * The comptable.
	 */
	// private String rbtCpta
	private String				  comptable;

	/**
	 * The sens.
	 */
	// private String rbtSens
	private String				  sens;

	/**
	 * The formule.
	 */
	// private String rbtFormul
	private String				  formule;

	/**
	 * The polonaise.
	 */
	// private String rbtPolonaise
	private String				  polonaise;

	/**
	 * The depense.
	 */
	// private String rbtDep
	private String				  depense;

	/**
	 * The securite sociale.
	 */
	// private String rbtSs
	private String				  securiteSociale;

	/**
	 * The controle plafond.
	 */
	// private String rbtCtrlplaf
	private String				  controlePlafond;

	/**
	 * The rbt pdr.
	 */
	private String				  rbtPdr;

	/**
	 * The rbt form ccam.
	 */
	private String				  rbtFormCcam;

	/**
	 * The user code.
	 */
	private String				  userCode;

	/**
	 * The plafond.
	 */
	// private BigDecimal rbtPlafp
	private BigDecimal		  plafond;

	/**
	 * The rbt pmsstp.
	 */
	private String				  rbtPmsstp;

	/**
	 * The quantite P.
	 */
	// private Short rbtQtep
	private Short				  quantiteP;

	/**
	 * The duree.
	 */
	// private Short rbtDuree
	private Short				  duree;

	/**
	 * The type.
	 */
	// private String rbtTyp
	private String				  type;

	/**
	 * The deuxieme comptable.
	 */
	// private String rbtCpta9
	private String				  deuxiemeComptable;

	/**
	 * The taux RO.
	 */
	// private BigDecimal rbtTauxro
	private BigDecimal		  tauxRO;

	/**
	 * The id regroupement.
	 */
	// private String idRegrp
	private String				  idRegroupement;
	/**
	 * The id risque.
	 */
	// private String idRisq
	private String				  idRisque;

	/**
	 * The id organisme.
	 */
	// private Integer idOrg
	private Integer			  idOrganisme;

	/**
	 * The id PiecesJustificative.
	 */
	private Long idPiecesJustificative;

	/**
	 * Le commentaire explicatif de la formule
	 */
	private String commentaire;

	/**
	 * Instantiates a new actrbt.
	 */
	public ActeRemboursementBVO() {
		/*
		 * empty
		 */
	}

	/**
	 * Instantiates a new actrbt.
	 *
	 * @param id the id acte remboursement
	 */
	public ActeRemboursementBVO(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {

		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {

		this.id = id;
	}

	/**
	 * Gets the id produit.
	 *
	 * @return the idProduit
	 */
	public String getIdProduit() {

		return idProduit;
	}

	/**
	 * Sets the id produit.
	 *
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(String idProduit) {

		this.idProduit = idProduit;
	}

	/**
	 * Gets the id act.
	 *
	 * @return the idAct
	 */
	public String getIdAct() {

		return idAct;
	}

	/**
	 * Sets the id act.
	 *
	 * @param idAct the idAct to set
	 */
	public void setIdAct(String idAct) {

		this.idAct = idAct;
	}

	/**
	 * Gets the date effet.
	 *
	 * @return the dateEffet
	 */
	public Date getDateEffet() {

		return dateEffet;
	}

	/**
	 * Sets the date effet.
	 *
	 * @param dateEffet the dateEffet to set
	 */
	public void setDateEffet(Date dateEffet) {

		this.dateEffet = dateEffet;
	}

	/**
	 * Gets the quantite.
	 *
	 * @return the quantite
	 */
	public Short getQuantite() {

		return quantite;
	}

	/**
	 * Sets the quantite.
	 *
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Short quantite) {

		this.quantite = quantite;
	}

	/**
	 * Gets the acte.
	 *
	 * @return the acte
	 */
	public String getActe() {

		return acte;
	}

	/**
	 * Sets the acte.
	 *
	 * @param acte the acte to set
	 */
	public void setActe(String acte) {

		this.acte = acte;
	}

	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public BigDecimal getMontant() {

		return montant;
	}

	/**
	 * Sets the montant.
	 *
	 * @param montant the montant to set
	 */
	public void setMontant(BigDecimal montant) {

		this.montant = montant;
	}

	/**
	 * Gets the rbt P.
	 *
	 * @return the rbtP
	 */
	public BigDecimal getRbtP() {

		return rbtP;
	}

	/**
	 * Sets the rbt P.
	 *
	 * @param rbtP the rbtP to set
	 */
	public void setRbtP(BigDecimal rbtP) {

		this.rbtP = rbtP;
	}

	/**
	 * Gets the rbt pmsst.
	 *
	 * @return the rbtPmsst
	 */
	public String getRbtPmsst() {

		return rbtPmsst;
	}

	/**
	 * Sets the rbt pmsst.
	 *
	 * @param rbtPmsst the rbtPmsst to set
	 */
	public void setRbtPmsst(String rbtPmsst) {

		this.rbtPmsst = rbtPmsst;
	}

	/**
	 * Gets the rbt pu.
	 *
	 * @return the rbtPu
	 */
	public BigDecimal getRbtPu() {

		return rbtPu;
	}

	/**
	 * Sets the rbt pu.
	 *
	 * @param rbtPu the rbtPu to set
	 */
	public void setRbtPu(BigDecimal rbtPu) {

		this.rbtPu = rbtPu;
	}

	/**
	 * Gets the taux.
	 *
	 * @return the taux
	 */
	public BigDecimal getTaux() {

		return taux;
	}

	/**
	 * Sets the taux.
	 *
	 * @param taux the taux to set
	 */
	public void setTaux(BigDecimal taux) {

		this.taux = taux;
	}

	/**
	 * Gets the comptable.
	 *
	 * @return the comptable
	 */
	public String getComptable() {

		return comptable;
	}

	/**
	 * Sets the comptable.
	 *
	 * @param comptable the comptable to set
	 */
	public void setComptable(String comptable) {

		this.comptable = comptable;
	}

	/**
	 * Gets the sens.
	 *
	 * @return the sens
	 */
	public String getSens() {

		return sens;
	}

	/**
	 * Sets the sens.
	 *
	 * @param sens the sens to set
	 */
	public void setSens(String sens) {

		this.sens = sens;
	}

	/**
	 * Gets the formule.
	 *
	 * @return the formule
	 */
	public String getFormule() {

		return formule;
	}

	/**
	 * Sets the formule.
	 *
	 * @param formule the formule to set
	 */
	public void setFormule(String formule) {

		this.formule = formule;
	}

	/**
	 * Gets the polonaise.
	 *
	 * @return the polonaise
	 */
	public String getPolonaise() {

		return polonaise;
	}

	/**
	 * Sets the polonaise.
	 *
	 * @param polonaise the polonaise to set
	 */
	public void setPolonaise(String polonaise) {

		this.polonaise = polonaise;
	}

	/**
	 * Gets the depense.
	 *
	 * @return the depense
	 */
	public String getDepense() {

		return depense;
	}

	/**
	 * Sets the depense.
	 *
	 * @param depense the depense to set
	 */
	public void setDepense(String depense) {

		this.depense = depense;
	}

	/**
	 * Gets the securite sociale.
	 *
	 * @return the securiteSociale
	 */
	public String getSecuriteSociale() {

		return securiteSociale;
	}

	/**
	 * Sets the securite sociale.
	 *
	 * @param securiteSociale the securiteSociale to set
	 */
	public void setSecuriteSociale(String securiteSociale) {

		this.securiteSociale = securiteSociale;
	}

	/**
	 * Gets the controle plafond.
	 *
	 * @return the controlePlafond
	 */
	public String getControlePlafond() {

		return controlePlafond;
	}

	/**
	 * Sets the controle plafond.
	 *
	 * @param controlePlafond the controlePlafond to set
	 */
	public void setControlePlafond(String controlePlafond) {

		this.controlePlafond = controlePlafond;
	}

	/**
	 * Gets the rbt pdr.
	 *
	 * @return the rbtPdr
	 */
	public String getRbtPdr() {

		return rbtPdr;
	}

	/**
	 * Sets the rbt pdr.
	 *
	 * @param rbtPdr the rbtPdr to set
	 */
	public void setRbtPdr(String rbtPdr) {

		this.rbtPdr = rbtPdr;
	}

	/**
	 * Gets the rbt form ccam.
	 *
	 * @return the rbtFormCcam
	 */
	public String getRbtFormCcam() {

		return rbtFormCcam;
	}

	/**
	 * Sets the rbt form ccam.
	 *
	 * @param rbtFormCcam the rbtFormCcam to set
	 */
	public void setRbtFormCcam(String rbtFormCcam) {

		this.rbtFormCcam = rbtFormCcam;
	}

	/**
	 * Gets the user code.
	 *
	 * @return the userCode
	 */
	public String getUserCode() {

		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {

		this.userCode = userCode;
	}

	/**
	 * Gets the plafond.
	 *
	 * @return the plafond
	 */
	public BigDecimal getPlafond() {

		return plafond;
	}

	/**
	 * Sets the plafond.
	 *
	 * @param plafond the plafond to set
	 */
	public void setPlafond(BigDecimal plafond) {

		this.plafond = plafond;
	}

	/**
	 * Gets the rbt pmsstp.
	 *
	 * @return the rbtPmsstp
	 */
	public String getRbtPmsstp() {

		return rbtPmsstp;
	}

	/**
	 * Sets the rbt pmsstp.
	 *
	 * @param rbtPmsstp the rbtPmsstp to set
	 */
	public void setRbtPmsstp(String rbtPmsstp) {

		this.rbtPmsstp = rbtPmsstp;
	}

	/**
	 * Gets the quantite P.
	 *
	 * @return the quantiteP
	 */
	public Short getQuantiteP() {

		return quantiteP;
	}

	/**
	 * Sets the quantite P.
	 *
	 * @param quantiteP the quantiteP to set
	 */
	public void setQuantiteP(Short quantiteP) {

		this.quantiteP = quantiteP;
	}

	/**
	 * Gets the duree.
	 *
	 * @return the duree
	 */
	public Short getDuree() {

		return duree;
	}

	/**
	 * Sets the duree.
	 *
	 * @param duree the duree to set
	 */
	public void setDuree(Short duree) {

		this.duree = duree;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * Gets the deuxieme comptable.
	 *
	 * @return the deuxiemeComptable
	 */
	public String getDeuxiemeComptable() {

		return deuxiemeComptable;
	}

	/**
	 * Sets the deuxieme comptable.
	 *
	 * @param deuxiemeComptable the deuxiemeComptable to set
	 */
	public void setDeuxiemeComptable(String deuxiemeComptable) {

		this.deuxiemeComptable = deuxiemeComptable;
	}

	/**
	 * Gets the taux RO.
	 *
	 * @return the tauxRO
	 */
	public BigDecimal getTauxRO() {

		return tauxRO;
	}

	/**
	 * Sets the taux RO.
	 *
	 * @param tauxRO the tauxRO to set
	 */
	public void setTauxRO(BigDecimal tauxRO) {

		this.tauxRO = tauxRO;
	}

	/**
	 * Gets the idRegroupement
	 *
	 * @return the idRegroupement
	 */
	public String getIdRegroupement() {
		return idRegroupement;
	}

	/**
	 * Sets the idRegroupement
	 *
	 * @param idRegroupement The idRegroupement to set
	 */
	public void setIdRegroupement(String idRegroupement) {
		this.idRegroupement = idRegroupement;
	}

	/**
	 * Gets the idRisque
	 *
	 * @return the idRisque
	 */
	public String getIdRisque() {
		return idRisque;
	}

	/**
	 * Sets the idRisque
	 *
	 * @param idRisque The idRisque to set
	 */
	public void setIdRisque(String idRisque) {
		this.idRisque = idRisque;
	}

	/**
	 * Gets the idOrganisme
	 *
	 * @return the idOrganisme
	 */
	public Integer getIdOrganisme() {
		return idOrganisme;
	}

	/**
	 * Sets the idOrganisme
	 *
	 * @param idOrganisme The idOrganisme to set
	 */
	public void setIdOrganisme(Integer idOrganisme) {
		this.idOrganisme = idOrganisme;
	}

	/**
	 * Gets the idPiecesJustificative
	 *
	 * @return the idPiecesJustificative
	 */
	public Long getIdPiecesJustificative() {
		return idPiecesJustificative;
	}

	/**
	 * Sets the idPiecesJustificative
	 *
	 * @param idPiecesJustificative The idPiecesJustificative to set
	 */
	public void setIdPiecesJustificative(Long idPiecesJustificative) {
		this.idPiecesJustificative = idPiecesJustificative;
	}

	/**
	 * Récupère le commentaire explicatif de la formule
	 * @return le commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Attribue le commentaire explicatif de la formule
	 * @param commentaire le commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
