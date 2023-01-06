package exoFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import exoFormation.entity.Adresse;
import exoFormation.entity.Formation;
import exoFormation.exception.FormationException;
import exoFormation.exception.IdException;
import exoFormation.repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	private FormationRepository formationRepo;

	public void create(Formation formation) {
		checkFormationIsNotNull(formation);
		checkFormationLibelleIsNotNullOrEmpty(formation);
		checkFormationReferentIsNotNull(formation);
		formationRepo.save(formation);
	}

	private void checkFormationReferentIsNotNull(Formation formation) {
		if (formation.getReferent() == null) {
			throw new FormationException();
		}
	}

	private void checkFormationLibelleIsNotNullOrEmpty(Formation formation) {
		if (formation.getLibelle() == null || formation.getLibelle().isEmpty()) {
			throw new FormationException();
		}
	}

	private void checkFormationIsNotNull(Formation formation) {
		if (formation == null) {
			throw new FormationException();
		}
	}

	public Formation getById(Long id) {
		if (id == null) {
			throw new IdException();
		}
		return formationRepo.findById(id).orElseThrow(FormationException::new);
	}

	public void delete(Formation formation) {
		checkFormationIsNotNull(formation);
		deleteById(formation.getId());
	}

	public void delete(Long id) {
		deleteById(id);
	}

	private void deleteById(Long id) {
		Formation formation = getById(id);
		formationRepo.delete(formation);
	}

	public List<Formation> getAll() {
		return formationRepo.findAll();
	}

	public Page<Formation> getAll(Pageable pageable) {
		if (pageable == null) {
			throw new FormationException();
		}
		return formationRepo.findAll(pageable);
	}

	public Page<Formation> getNextPage(Page<Formation> page) {
		if (page == null) {
			throw new FormationException();
		}
		return formationRepo.findAll(page.nextOrLastPageable());
	}

	public Page<Formation> getPrevious(Page<Formation> page) {
		if (page == null) {
			throw new FormationException();
		}
		return formationRepo.findAll(page.previousOrFirstPageable());
	}

	public Formation update(Formation formation) {
		// @formatter:off
		Formation formationEnBase = getById(formation.getId());
		checkFormationLibelleIsNotNullOrEmpty(formationEnBase);
		formationEnBase.setLibelle(formation.getLibelle());
		formationEnBase.setDescription(formation.getDescription());
		checkFormationReferentIsNotNull(formation);
		formationEnBase.setReferent(formation.getReferent());
		formationEnBase.setDistanciel(formation.isDistanciel());
		return formationRepo.save(formationEnBase);
		// @formatter:on
	}
}
