package exoFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exoFormation.entity.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	List<Formateur> findByInterneIsTrue();

	List<Formateur> findByNom(String nom);

	List<Formateur> findByNomContaining(String nom);
}
