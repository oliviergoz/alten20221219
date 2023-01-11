package ajc.formation.alten.formation.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {
	@EmbeddedId
	private ModuleFormationKey id;
	@Column(name = "date_formation")
	private LocalDate dateFormation;
	@ManyToOne
	@JoinColumn(name = "module_formation_formateur_id", foreignKey = @ForeignKey(name = "module_formation_formateur_id_fk"), nullable = false)
	private Formateur formateur;

	public ModuleFormation() {

	}

	public ModuleFormation(ModuleFormationKey id, LocalDate dateFormation, Formateur formateur) {
		super();
		this.id = id;
		this.dateFormation = dateFormation;
		this.formateur = formateur;
	}

	public ModuleFormationKey getId() {
		return id;
	}

	public void setId(ModuleFormationKey id) {
		this.id = id;
	}

	public LocalDate getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(LocalDate dateFormation) {
		this.dateFormation = dateFormation;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
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
		ModuleFormation other = (ModuleFormation) obj;
		return Objects.equals(id, other.id);
	}

}
