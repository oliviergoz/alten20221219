package formation.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.entity.Formation;
import formation.jsonviews.Views;
import formation.service.FormateurService;
import formation.service.FormationService;

@RestController
@RequestMapping("/api/formation")
public class FormationRestController {

	@Autowired
	private FormationService formationService;
	@Autowired
	private FormateurService formateurService;

	// remonter en GET
	@GetMapping("")
	@JsonView(Views.FormationWithReferent.class)
	public List<Formation> getAll() {
		return formationService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.FormationWithReferent.class)
	public Formation getById(@PathVariable Long id) {
		return formationService.getById(id);
	}

	// creation POST
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.FormationWithReferent.class)
	public Formation create(@Valid @RequestBody Formation formation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return formationService.create(formation);
	}

	// modification PUT
	@PutMapping("/{id}")
	@JsonView(Views.FormationWithReferent.class)
	public Formation update(@Valid @RequestBody Formation formation, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		formation.setId(id);
		return formationService.update(formation);
	}

	// suppression DELETE
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		formationService.delete(id);
	}

	// modification partielle
	@PatchMapping("/{id}")
	@JsonView(Views.FormationWithReferent.class)
	public Formation patch(@PathVariable Long id, @RequestBody Map<String, Object> objetJsonRecu) {
		Formation formationEnBase = formationService.getById(id);
//		if (objetJsonRecu.get("libelle") != null) {
//			formationEnBase.setLibelle(objetJsonRecu.get("libelle").toString());
//		}
//		if (objetJsonRecu.get("description") != null) {
//			formationEnBase.setDescription(objetJsonRecu.get("description").toString());
//		}
//		if (objetJsonRecu.get("distanciel") != null) {
//			formationEnBase.setDistanciel(Boolean.parseBoolean(objetJsonRecu.get("distanciel").toString()));
//		}

		objetJsonRecu.forEach((key, value) -> {
			if (key.equals("referent")) {
				Map<String, Object> referentEnJsonRecu = (Map<String, Object>) objetJsonRecu.get("referent");
				formationEnBase
						.setReferent(formateurService.getById(Long.parseLong(referentEnJsonRecu.get("id").toString())));
			} else {
				Field field = ReflectionUtils.findField(Formation.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, formationEnBase, value);
			}
		});

		return formationService.update(formationEnBase);
	}

}
