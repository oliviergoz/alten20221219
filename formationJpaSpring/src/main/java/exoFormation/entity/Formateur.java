package exoFormation.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formateur")
@AttributeOverride(name = "adresse.numero", column = @Column(name = "formateur_numero", length = 50))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "formateur_rue", length = 255))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "formateur_cp", length = 50))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "formateur_ville", length = 255))
@AttributeOverride(name = "id", column = @Column(name = "formateur_id"))
@AttributeOverride(name = "prenom", column = @Column(name = "formateur_prenom", length = 255, nullable = false))
@AttributeOverride(name = "nom", column = @Column(name = "formateur_nom", length = 255, nullable = false))
@AttributeOverride(name = "email", column = @Column(name = "formateur_email", length = 255))
@AttributeOverride(name = "telephone", column = @Column(name = "formateur_telephone", length = 20))
@SequenceGenerator(name = "seqPersonne", sequenceName = "formateur_seq", initialValue = 50, allocationSize = 1)
public class Formateur extends Personne {
	private boolean interne;
	private double cout;
	@OneToMany(mappedBy = "referent")
	private Set<Formation> formationsCommeReferent;

	@OneToMany(mappedBy = "formateur")
	private Set<ModuleFormation> modulesAnimes;

	public Formateur(String prenom, String nom, String email, String telephone, Adresse adresse, boolean interne,
			double cout) {
		super(prenom, nom, email, telephone, adresse);
		this.interne = interne;
		this.cout = cout;
	}

	public Formateur() {

	}

	public boolean isInterne() {
		return interne;
	}

	public void setInterne(boolean interne) {
		this.interne = interne;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public Set<Formation> getFormationsCommeReferent() {
		return formationsCommeReferent;
	}

	public void setFormationsCommeReferent(Set<Formation> formationsCommeReferent) {
		this.formationsCommeReferent = formationsCommeReferent;
	}

	public Set<ModuleFormation> getModulesAnimes() {
		return modulesAnimes;
	}

	public void setModulesAnimes(Set<ModuleFormation> modulesAnimes) {
		this.modulesAnimes = modulesAnimes;
	}

	public String getInfos() {
		return getId() + " " + getPrenom() + " " + getNom();
	}

}
