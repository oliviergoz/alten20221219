package ajc.formation.alten.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.formation.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByLogin(String login);
}
