package exoFormation.dao;

import java.util.List;

import exoFormation.entity.Materiel;
import exoFormation.entity.Ordinateur;
import exoFormation.entity.VideoProjecteur;

public interface DaoMateriel extends DaoGeneric<Materiel, Long>{
	List<Ordinateur> findAllOrdinateur();
	List<VideoProjecteur> findAllVideoProjecteur();
}
