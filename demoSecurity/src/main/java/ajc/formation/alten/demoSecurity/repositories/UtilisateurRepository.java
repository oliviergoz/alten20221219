package ajc.formation.alten.demoSecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.demoSecurity.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByLogin(String login);
}
