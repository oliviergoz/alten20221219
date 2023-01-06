package demoMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exoFormation.entity.Formation;
import exoFormation.service.FormateurService;
import exoFormation.service.FormationService;

@Controller
@RequestMapping("/formation")
public class FormationController {

	@Autowired
	private FormationService formationSrv;
	@Autowired
	private FormateurService formateurSrv;
	
	@GetMapping("")
	public String list(Model model, @RequestParam(name = "element", required = false, defaultValue = "20") int element,
			@RequestParam(name = "page", required = false, defaultValue = "0") int numeroPage) {
		model.addAttribute("page", formationSrv.getAll(PageRequest.of(numeroPage, element)));
		return "formation/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id, Model model) {
		formationSrv.delete(id);
		return "redirect:/formation";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return form(model, new Formation());
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		return form(model, formationSrv.getById(id));
	}

	private String form(Model model, Formation formation) {
		model.addAttribute("formation", formation);
		model.addAttribute("formateurs", formateurSrv.getAll());
		return "formation/edit";
	}

	@PostMapping("")
	public String save(Model model,@Valid @ModelAttribute Formation formation,BindingResult br) {
		if(br.hasErrors()) {
			return form(model,formation);
		}
		if (formation.getId() != null) {
			formationSrv.update(formation);
		} else {
			formationSrv.create(formation);
		}
		return "redirect:/formation";
	}
}
