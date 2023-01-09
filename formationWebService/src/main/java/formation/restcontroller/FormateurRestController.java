package formation.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
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

import formation.entity.Adresse;
import formation.entity.Formateur;
import formation.jsonviews.Views;
import formation.service.FormateurService;
import formation.util.Check;

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

	@PostMapping("")
	@JsonView(Views.Common.class)
	public Formateur create(@Valid @RequestBody Formateur formateur, BindingResult br) {
		Check.checkBindingResulHasError(br);
		return formateurService.create(formateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Formateur update(@Valid @RequestBody Formateur formateur, BindingResult br, @PathVariable Long id) {
		Check.checkBindingResulHasError(br);
		formateur.setId(id);
		return formateurService.update(formateur);
	}

	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Formateur patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Formateur formateur = formateurService.getById(id);

		fields.forEach((key, value) -> {
			if (key.equals("adresse")) {
				final Adresse adresse;

				if (formateur.getAdresse() != null) {
					adresse = formateur.getAdresse();
				} else {
					adresse = new Adresse();
				}
				((Map<String, Object>) value).forEach((k, v) -> {
					setField(adresse, Adresse.class, k, v);
				});
				formateur.setAdresse(adresse);
			} else if (key.equals("dtNaiss")) {
				formateur.setDtNaiss(LocalDate.parse(value.toString()));
			} else {
				setField(formateur, Formateur.class, key, value);
			}
		});
		return formateurService.update(formateur);
	}

	private void setField(Object target, Class modelClass, String fieldName, Object value) {
		Field field = ReflectionUtils.findField(modelClass, fieldName);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, target, value);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		formateurService.delete(id);
	}
}
