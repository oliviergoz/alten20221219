package exoFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exoFormation.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
