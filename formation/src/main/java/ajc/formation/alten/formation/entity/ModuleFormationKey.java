package ajc.formation.alten.formation.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ModuleFormationKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "module_formation_formation_id", foreignKey = @ForeignKey(name = "module_formation_formation_id_fk"))
	private Formation formation;
	@ManyToOne
	@JoinColumn(name = "module_formation_module_id", foreignKey = @ForeignKey(name = "module_formation_module_id_fk"))
	private Module module;

	public ModuleFormationKey() {

	}

	public ModuleFormationKey(Module module, Formation formation) {
		super();
		this.module = module;
		this.formation = formation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formation, module);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormationKey other = (ModuleFormationKey) obj;
		return Objects.equals(formation, other.formation) && Objects.equals(module, other.module);
	}

}
