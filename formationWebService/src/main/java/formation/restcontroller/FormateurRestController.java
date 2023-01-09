package formation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.entity.Formateur;
import formation.jsonviews.Views;
import formation.service.FormateurService;

@RestController
@RequestMapping("/api/formateur")
public class FormateurRestController {

	@Autowired
	private FormateurService formateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Formateur> getAll() {
		return formateurService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Formateur getById(@PathVariable Long id) {
		return formateurService.getById(id);
	}

	@GetMapping("/{id}/formations")
	@JsonView(Views.FormateurWithFormationsCommeReferents.class)
	public Formateur getByIdWithFormationsCommeReferent(@PathVariable Long id) {
		return formateurService.getByIdWithFormationsCommeReferent(id);
	}
}
