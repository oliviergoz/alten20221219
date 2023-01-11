package ajc.formation.alten.formation.services;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ajc.formation.alten.formation.entity.Adresse;
import ajc.formation.alten.formation.entity.Formateur;
import ajc.formation.alten.formation.exception.FormateurException;
import ajc.formation.alten.formation.exception.IdException;
import ajc.formation.alten.formation.repository.FormateurRepository;
import ajc.formation.alten.formation.repository.FormationRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;

@Service
public class FormateurService {

	// DataTransferObject

	@Autowired
	private FormateurRepository formateurRepo;
	@Autowired
	private FormationRepository formationRepo;
	@Autowired
	private Validator validator;

	private static final Logger LOG = LoggerFactory.getLogger(FormateurService.class);

	public Formateur create(Formateur formateur) {
		checkFormateurIsNotNull(formateur);
		Set<ConstraintViolation<Formateur>> violations = validator.validate(formateur);
		if (!violations.isEmpty()) {
			violations.forEach(v -> {
				LOG.debug(v.toString());
			});
			throw new FormateurException();
		}
		return formateurRepo.save(formateur);
	}

	private void checkFormateurIsNotNull(Formateur formateur) {
		if (formateur == null) {
			throw new FormateurException("formateur null");
		}
	}

	public Formateur getById(Long id) {
		if (id == null) {
			throw new IdException();
		}
		return formateurRepo.findById(id).orElseThrow(() -> {
			throw new FormateurException("formateur inconnu");
		});
	}

	public Formateur getByIdWithFormationsCommeReferent(Long id) {
		if (id == null) {
			throw new IdException();
		}
		return formateurRepo.findByIdFetchFormationsCommeReferent(id).orElseThrow(() -> {
			throw new FormateurException("formateur inconnu");
		});
	}

	public void delete(Formateur formateur) {
		checkFormateurIsNotNull(formateur);
		deleteById(formateur.getId());
	}

	public void delete(Long id) {
		deleteById(id);
	}

	private void deleteById(Long id) {
		Formateur formateur = getById(id);
		formationRepo.deleteByReferent(formateur);
		formateurRepo.delete(getById(id));
	}

	// pas bien prod mais pratique pour le module spring mvc
	public List<Formateur> getAll() {
		return formateurRepo.findAll();
	}

	public Page<Formateur> getAll(Pageable pageable) {
		if (pageable == null) {
			throw new FormateurException();
		}
		return formateurRepo.findAll(pageable);
	}

	public Page<Formateur> getNextPage(Page<Formateur> page) {
		if (page == null) {
			throw new FormateurException();
		}
		return formateurRepo.findAll(page.nextOrLastPageable());
	}

	public Page<Formateur> getPrevious(Page<Formateur> page) {
		if (page == null) {
			throw new FormateurException();
		}
		return formateurRepo.findAll(page.previousOrFirstPageable());
	}

	public Formateur update(Formateur formateur) {
		// @formatter:off
		Formateur formateurEnBase = getById(formateur.getId());
		formateurEnBase.setPrenom(formateur.getPrenom() == null||formateur.getPrenom().isEmpty() ? formateurEnBase.getPrenom() : formateur.getPrenom());
		formateurEnBase.setNom(formateur.getNom() == null||formateur.getNom().isEmpty()? formateurEnBase.getNom() : formateur.getNom());
		formateurEnBase.setEmail(formateur.getEmail());
		formateurEnBase.setTelephone(formateur.getTelephone());
		formateurEnBase.setDtNaiss(formateur.getDtNaiss());
		if (formateur.getAdresse() != null) {
			formateurEnBase.setAdresse(
								new Adresse(
										formateur.getAdresse().getNumero(), 
										formateur.getAdresse().getRue(),
										formateur.getAdresse().getCodePostal(),
										formateur.getAdresse().getVille()));
		} else {
			formateurEnBase.setAdresse(null);
		}
		formateurEnBase.setInterne(formateur.isInterne());
		formateurEnBase.setCout(formateur.getCout());
		return formateurRepo.save(formateurEnBase);
		// @formatter:on
	}
}
