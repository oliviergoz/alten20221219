package ajc.formation.alten.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.formation.entity.ModuleFormation;
import ajc.formation.alten.formation.entity.ModuleFormationKey;

public interface ModuleFormationRepository extends JpaRepository<ModuleFormation, ModuleFormationKey> {

}
