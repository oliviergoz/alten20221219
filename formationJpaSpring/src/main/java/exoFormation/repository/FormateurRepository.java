package exoFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exoFormation.entity.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	List<Formateur> findByInterneIsTrue();

	List<Formateur> findByNom(String nom);

	List<Formateur> findByNomContaining(String nom);

	Page<Formateur> findByNomContaining(String nom, Pageable pageable);

	@Query("select f from Formateur f left join fetch f.formationsCommeReferent where f.id=:id")
	Optional<Formateur> findByIdFetchFormationsCommeReferent(@Param("id") Long id);
}
