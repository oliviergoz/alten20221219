package formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
