package ajc.formation.alten.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.formation.alten.formation.entity.Formateur;
import ajc.formation.alten.formation.services.FormateurService;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private FormateurService formateurService;

	@GetMapping("")
	public String list(Model model, @RequestParam(name = "element", required = false, defaultValue = "5") int element,
			@RequestParam(name = "page", required = false, defaultValue = "0") int numeroPage) {
		model.addAttribute("page", formateurService.getAll(PageRequest.of(numeroPage, element)));
		return "formateur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id, Model model) {
		formateurService.delete(id);
		return "redirect:/formateur";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return form(model, new Formateur());
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		return form(model, formateurService.getById(id));
	}

	private String form(Model model, Formateur formateur) {
		model.addAttribute("formateur", formateur);
		return "formateur/edit";
	}

	// @PostMapping("")
	@GetMapping("/save")
	public String save(Model model, @Valid @ModelAttribute Formateur formateur, BindingResult br) {
		if (br.hasErrors()) {
			return form(model, formateur);
		}
		if (formateur.getId() != null) {
			formateurService.update(formateur);
		} else {
			formateurService.create(formateur);
		}
		return "redirect:/formateur";
	}
}
