package formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}
