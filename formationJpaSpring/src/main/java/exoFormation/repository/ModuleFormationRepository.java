package exoFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exoFormation.entity.ModuleFormation;
import exoFormation.entity.ModuleFormationKey;

public interface ModuleFormationRepository extends JpaRepository<ModuleFormation, ModuleFormationKey> {

}
