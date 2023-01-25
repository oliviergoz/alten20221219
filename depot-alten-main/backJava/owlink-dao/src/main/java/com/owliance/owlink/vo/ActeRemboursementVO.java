package com.owliance.owlink.vo;

import com.owliance.owlink.framework.entity.BaseVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "ACTRBT")
public class ActeRemboursementVO extends BaseVO implements java.io.Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2710867419977418435L;

    /**
     * The id.
     */
    private Integer id;

    /**
     * The id produit.
     */
    private String idProduit;

    /**
     * The id act.
     */
    private String idAct;

    /**
     * The date effet.
     */
    private Date dateEffet;

    /**
     * The quantite.
     */
    private Short quantite;

    /**
     * The acte.
     */
    private String acte;

    /**
     * The montant.
     */
    private BigDecimal montant;

    /**
     * The rbt P.
     */
    private BigDecimal rbtP;

    /**
     * The rbt pmsst.
     */
    private String rbtPmsst;

    /**
     * The rbt pu.
     */
    private BigDecimal rbtPu;

    /**
     * The taux.
     */
    private BigDecimal taux;

    /**
     * The comptable.
     */
    private String comptable;

    /**
     * The sens.
     */
    private String sens;

    /**
     * The formule.
     */
    private String formule;

    /**
     * The polonaise.
     */
    private String polonaise;

    /**
     * The depense.
     */
    private String depense;

    /**
     * The securite sociale.
     */
    private String securiteSociale;

    /**
     * The controle plafond.
     */
    private String controlePlafond;

    /**
     * The rbt pdr.
     */
    private String rbtPdr;

    /**
     * The rbt form ccam.
     */
    private String rbtFormCcam;

    /**
     * The user code.
     */
    private String userCode;

    /**
     * The plafond.
     */
    private BigDecimal plafond;

    /**
     * The rbt pmsstp.
     */
    private String rbtPmsstp;

    /**
     * The quantite P.
     */
    private Short quantiteP;

    /**
     * The duree.
     */
    private Short duree;

    /**
     * The type.
     */
    private String type;

    /**
     * The deuxieme comptable.
     */
    private String deuxiemeComptable;

    /**
     * The taux RO.
     */
    private BigDecimal tauxRO;

    /**
     * Le commentaire explicatif de la formule
     */
    private String commentaire;

    /**
     * Gets the id actrbt.
     *
     * @return the id actrbt
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ACTRBT")
    @SequenceGenerator(name = "ID_ACTRBT", sequenceName = "ID_ACTRBT", allocationSize = 1)
    @Column(name = "ID_ACTRBT", unique = true, nullable = false, precision = 8, scale = 0)
    public Integer getId() {

        return this.id;
    }

    /**
     * Sets the id actrbt.
     *
     * @param id the new id actrbt
     */
    public void setId(Integer id) {

        this.id = id;
    }

    /**
     * Gets the id prod.
     *
     * @return the id prod
     */
    @Column(name = "ID_PROD", nullable = false, length = 8)
    public String getIdProduit() {

        return this.idProduit;
    }

    /**
     * Sets the id prod.
     *
     * @param idProduit the new id prod
     */
    public void setIdProduit(String idProduit) {

        this.idProduit = idProduit;
    }

    /**
     * Gets the id act.
     *
     * @return the id act
     */
    @Column(name = "ID_ACT", nullable = false, length = 7)
    public String getIdAct() {

        return this.idAct;
    }

    /**
     * Sets the id act.
     *
     * @param idAct the new id act
     */
    public void setIdAct(String idAct) {

        this.idAct = idAct;
    }

    /**
     * Gets the rbt dateffet.
     *
     * @return the rbt dateffet
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "RBT_DATEFFET", nullable = false, length = 7)
    public Date getDateEffet() {

        return this.dateEffet;
    }

    /**
     * Sets the rbt dateffet.
     *
     * @param dateEffet the new rbt dateffet
     */
    public void setDateEffet(Date dateEffet) {

        this.dateEffet = dateEffet;
    }

    /**
     * Gets the rbt qte.
     *
     * @return the rbt qte
     */
    @Column(name = "RBT_QTE", precision = 4, scale = 0)
    public Short getQuantite() {

        return this.quantite;
    }

    /**
     * Sets the rbt qte.
     *
     * @param quantite the new rbt qte
     */
    public void setQuantite(Short quantite) {

        this.quantite = quantite;
    }

    /**
     * Gets the rbt act.
     *
     * @return the rbt act
     */
    @Column(name = "RBT_ACT", length = 7)
    public String getActe() {

        return this.acte;
    }

    /**
     * Sets the rbt act.
     *
     * @param acte the new rbt act
     */
    public void setActe(String acte) {

        this.acte = acte;
    }

    /**
     * Gets the rbt mt.
     *
     * @return the rbt mt
     */
    @Column(name = "RBT_MT", precision = 9, scale = 3)
    public BigDecimal getMontant() {

        return this.montant;
    }

    /**
     * Sets the rbt mt.
     *
     * @param montant the new rbt mt
     */
    public void setMontant(BigDecimal montant) {

        this.montant = montant;
    }

    /**
     * Gets the rbt P.
     *
     * @return the rbt P
     */
    @Column(name = "RBT_P", precision = 6, scale = 3)
    public BigDecimal getRbtP() {

        return this.rbtP;
    }

    /**
     * Sets the rbt P.
     *
     * @param rbtP the new rbt P
     */
    public void setRbtP(BigDecimal rbtP) {

        this.rbtP = rbtP;
    }

    /**
     * Gets the rbt pmsst.
     *
     * @return the rbt pmsst
     */
    @Column(name = "RBT_PMSST", length = 1)
    public String getRbtPmsst() {

        return this.rbtPmsst;
    }

    /**
     * Sets the rbt pmsst.
     *
     * @param rbtPmsst the new rbt pmsst
     */
    public void setRbtPmsst(String rbtPmsst) {

        this.rbtPmsst = rbtPmsst;
    }

    /**
     * Gets the rbt pu.
     *
     * @return the rbt pu
     */
    @Column(name = "RBT_PU", precision = 9, scale = 3)
    public BigDecimal getRbtPu() {

        return this.rbtPu;
    }

    /**
     * Sets the rbt pu.
     *
     * @param rbtPu the new rbt pu
     */
    public void setRbtPu(BigDecimal rbtPu) {

        this.rbtPu = rbtPu;
    }

    /**
     * Gets the rbt taux.
     *
     * @return the rbt taux
     */
    @Column(name = "RBT_TAUX", precision = 7, scale = 3)
    public BigDecimal getTaux() {

        return this.taux;
    }

    /**
     * Sets the rbt taux.
     *
     * @param taux the new rbt taux
     */
    public void setTaux(BigDecimal taux) {

        this.taux = taux;
    }

    /**
     * Gets the rbt cpta.
     *
     * @return the rbt cpta
     */
    @Column(name = "RBT_CPTA", length = 10)
    public String getComptable() {

        return this.comptable;
    }

    /**
     * Sets the rbt cpta.
     *
     * @param comptable the new rbt cpta
     */
    public void setComptable(String comptable) {

        this.comptable = comptable;
    }

    /**
     * Gets the rbt sens.
     *
     * @return the rbt sens
     */
    @Column(name = "RBT_SENS", length = 1)
    public String getSens() {

        return this.sens;
    }

    /**
     * Sets the rbt sens.
     *
     * @param sens the new rbt sens
     */
    public void setSens(String sens) {

        this.sens = sens;
    }

    /**
     * Gets the rbt formul.
     *
     * @return the rbt formul
     */
    @Column(name = "RBT_FORMUL")
    public String getFormule() {

        return this.formule;
    }

    /**
     * Sets the rbt formul.
     *
     * @param formule the new rbt formul
     */
    public void setFormule(String formule) {

        this.formule = formule;
    }

    /**
     * Gets the rbt polonaise.
     *
     * @return the rbt polonaise
     */
    @Column(name = "RBT_POLONAISE")
    public String getPolonaise() {

        return this.polonaise;
    }

    /**
     * Sets the rbt polonaise.
     *
     * @param polonaise the new rbt polonaise
     */
    public void setPolonaise(String polonaise) {

        this.polonaise = polonaise;
    }

    /**
     * Gets the rbt dep.
     *
     * @return the rbt dep
     */
    @Column(name = "RBT_DEP", length = 1)
    public String getDepense() {

        return this.depense;
    }

    /**
     * Sets the rbt dep.
     *
     * @param depense the new rbt dep
     */
    public void setDepense(String depense) {

        this.depense = depense;
    }

    /**
     * Gets the rbt ss.
     *
     * @return the rbt ss
     */
    @Column(name = "RBT_SS", length = 1)
    public String getSecuriteSociale() {

        return this.securiteSociale;
    }

    /**
     * Sets the rbt ss.
     *
     * @param securiteSociale the new rbt ss
     */
    public void setSecuriteSociale(String securiteSociale) {

        this.securiteSociale = securiteSociale;
    }

    /**
     * Gets the rbt ctrlplaf.
     *
     * @return the rbt ctrlplaf
     */
    @Column(name = "RBT_CTRLPLAF", length = 1)
    public String getControlePlafond() {

        return this.controlePlafond;
    }

    /**
     * Sets the rbt ctrlplaf.
     *
     * @param controlePlafond the new rbt ctrlplaf
     */
    public void setControlePlafond(String controlePlafond) {

        this.controlePlafond = controlePlafond;
    }

    /**
     * Gets the rbt pdr.
     *
     * @return the rbt pdr
     */
    @Column(name = "RBT_PDR", length = 1)
    public String getRbtPdr() {

        return this.rbtPdr;
    }

    /**
     * Sets the rbt pdr.
     *
     * @param rbtPdr the new rbt pdr
     */
    public void setRbtPdr(String rbtPdr) {

        this.rbtPdr = rbtPdr;
    }

    /**
     * Gets the rbt form ccam.
     *
     * @return the rbt form ccam
     */
    @Column(name = "RBT_FORM_CCAM")
    public String getRbtFormCcam() {

        return this.rbtFormCcam;
    }

    /**
     * Sets the rbt form ccam.
     *
     * @param rbtFormCcam the new rbt form ccam
     */
    public void setRbtFormCcam(String rbtFormCcam) {

        this.rbtFormCcam = rbtFormCcam;
    }

    /**
     * Gets the user code.
     *
     * @return the user code
     */
    @Column(name = "USER_CODE", length = 31)
    public String getUserCode() {

        return this.userCode;
    }

    /**
     * Sets the user code.
     *
     * @param userCode the new user code
     */
    public void setUserCode(String userCode) {

        this.userCode = userCode;
    }

    /**
     * Gets the rbt plafp.
     *
     * @return the rbt plafp
     */
    @Column(name = "RBT_PLAFP", precision = 6, scale = 3)
    public BigDecimal getPlafond() {

        return this.plafond;
    }

    /**
     * Sets the rbt plafp.
     *
     * @param plafond the new rbt plafp
     */
    public void setPlafond(BigDecimal plafond) {

        this.plafond = plafond;
    }

    /**
     * Gets the rbt pmsstp.
     *
     * @return the rbt pmsstp
     */
    @Column(name = "RBT_PMSSTP", length = 1)
    public String getRbtPmsstp() {

        return this.rbtPmsstp;
    }

    /**
     * Sets the rbt pmsstp.
     *
     * @param rbtPmsstp the new rbt pmsstp
     */
    public void setRbtPmsstp(String rbtPmsstp) {

        this.rbtPmsstp = rbtPmsstp;
    }

    /**
     * Gets the rbt qtep.
     *
     * @return the rbt qtep
     */
    @Column(name = "RBT_QTEP", precision = 3, scale = 0)
    public Short getQuantiteP() {

        return this.quantiteP;
    }

    /**
     * Sets the rbt qtep.
     *
     * @param quantiteP the new rbt qtep
     */
    public void setQuantiteP(Short quantiteP) {

        this.quantiteP = quantiteP;
    }

    /**
     * Gets the rbt duree.
     *
     * @return the rbt duree
     */
    @Column(name = "RBT_DUREE", precision = 4, scale = 0)
    public Short getDuree() {

        return this.duree;
    }

    /**
     * Sets the rbt duree.
     *
     * @param duree the new rbt duree
     */
    public void setDuree(Short duree) {

        this.duree = duree;
    }

    /**
     * Gets the rbt typ.
     *
     * @return the rbt typ
     */
    @Column(name = "RBT_TYP", length = 1)
    public String getType() {

        return this.type;
    }

    /**
     * Sets the rbt typ.
     *
     * @param type the new rbt typ
     */
    public void setType(String type) {

        this.type = type;
    }

    /**
     * Gets the rbt cpta 9.
     *
     * @return the rbt cpta 9
     */
    @Column(name = "RBT_CPTA9", length = 10)
    public String getDeuxiemeComptable() {

        return this.deuxiemeComptable;
    }

    /**
     * Sets the rbt cpta 9.
     *
     * @param deuxiemeComptable the new rbt cpta 9
     */
    public void setDeuxiemeComptable(String deuxiemeComptable) {

        this.deuxiemeComptable = deuxiemeComptable;
    }

    /**
     * Gets the rbt tauxro.
     *
     * @return the rbt tauxro
     */
    @Column(name = "RBT_TAUXRO", precision = 5)
    public BigDecimal getTauxRO() {

        return this.tauxRO;
    }

    /**
     * Sets the rbt tauxro.
     *
     * @param tauxRO the new rbt tauxro
     */
    public void setTauxRO(BigDecimal tauxRO) {

        this.tauxRO = tauxRO;
    }

    /**
     * Récupère le commentaire explicatif de la formule
     *
     * @return le commentaire
     */
    @Column(name = "RBT_FORMUL_COMM")
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Attribue le commentaire explicatif de la formule
     *
     * @param commentaire le commentaire
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
