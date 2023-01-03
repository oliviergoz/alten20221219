package exoFormation.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "module_module_id", initialValue = 10, allocationSize = 1)
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqModule")
	@Column(name = "module_id")
	private Long id;
	@Column(name = "module_titre")
	private String titre;
	@Column(name = "module_details", columnDefinition = "TEXT")
	private String details;
	@OneToMany(mappedBy = "id.module")
	private List<ModuleFormation> formations;

	public Module() {
	}

	public Module(String titre, String details) {
		super();
		this.titre = titre;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<ModuleFormation> getFormations() {
		return formations;
	}

	public void setFormations(List<ModuleFormation> formations) {
		this.formations = formations;
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
		Module other = (Module) obj;
		return Objects.equals(id, other.id);
	}

}
