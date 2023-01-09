package formation.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.entity.Formation;
import formation.jsonviews.Views;
import formation.service.FormationService;

@RestController
@RequestMapping("/api/formation")
public class FormationRestController {

	@Autowired
	private FormationService formationService;

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

	// suppression DELETE

}
