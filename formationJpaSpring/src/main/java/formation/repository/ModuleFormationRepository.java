package formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.ModuleFormation;
import formation.entity.ModuleFormationKey;

public interface ModuleFormationRepository extends JpaRepository<ModuleFormation, ModuleFormationKey> {

}
