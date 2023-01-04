package exoFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exoFormation.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
