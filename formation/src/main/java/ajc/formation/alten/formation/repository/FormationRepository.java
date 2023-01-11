package ajc.formation.alten.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.alten.formation.entity.Formateur;
import ajc.formation.alten.formation.entity.Formation;
import jakarta.transaction.Transactional;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	@Modifying
	@Transactional
	@Query("update Formation f set f.referent=null where f.referent=:referent")
	void updateByReferentSetReferentToNull(@Param("referent") Formateur referent);

	@Modifying
	@Transactional
	@Query("delete Formation f where f.referent=:referent")
	void deleteByReferent(@Param("referent") Formateur referent);
}
