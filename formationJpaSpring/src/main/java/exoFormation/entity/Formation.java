package exoFormation.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "formation_formation_id", initialValue = 10, allocationSize = 1)
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	@Column(name = "formation_id")
	private Long id;
	@Column(name = "formation_libelle")
	@NotEmpty
	private String libelle;
	@Column(name = "formation_description", columnDefinition = "TEXT")
	private String description;
	@Column(name = "formation_distanciel")
	private boolean distanciel;
	@ManyToOne
	@JoinColumn(name = "formation_salle_id", foreignKey = @ForeignKey(name = "formation_formation_salle_id_fk"))
	private Salle salle;
	@ManyToOne
	@JoinColumn(name = "formation_referent_id", foreignKey = @ForeignKey(name = "formation_formation_referent_id_fk"), nullable = false)
	@NotNull
	private Formateur referent;
	@ManyToMany
	@JoinTable(name = "participant_formation", joinColumns = @JoinColumn(name = "participant_formation_formation_id", foreignKey = @ForeignKey(name = "participant_formation_formation_id_fk")), inverseJoinColumns = @JoinColumn(name = "participant_formation_participant_id", foreignKey = @ForeignKey(name = "participant_formation_participant_id")))
	private Set<Participant> stagiaires;
	@OneToMany(mappedBy = "id.formation")
	// @Transient
	private Set<ModuleFormation> modules;

	public Formation() {

	}

	public Formation(@NotEmpty String libelle, String description, boolean distanciel, @NotNull Formateur referent) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.distanciel = distanciel;
		this.referent = referent;
	}

	public Formation(String libelle, String description, boolean distanciel, Salle salle, Formateur referent,
			Set<Participant> stagiaires, Set<ModuleFormation> modules) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.distanciel = distanciel;
		this.salle = salle;
		this.referent = referent;
		this.stagiaires = stagiaires;
		this.modules = modules;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDistanciel() {
		return distanciel;
	}

	public void setDistanciel(boolean distanciel) {
		this.distanciel = distanciel;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Set<Participant> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Participant> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Set<ModuleFormation> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleFormation> modules) {
		this.modules = modules;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}
