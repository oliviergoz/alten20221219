package formation.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.entity.Formateur;
import formation.entity.Formation;

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
