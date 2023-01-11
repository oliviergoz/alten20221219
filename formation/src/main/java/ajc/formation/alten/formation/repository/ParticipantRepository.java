package ajc.formation.alten.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.formation.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
