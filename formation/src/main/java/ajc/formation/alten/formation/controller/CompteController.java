package ajc.formation.alten.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ajc.formation.alten.formation.entity.Compte;
import ajc.formation.alten.formation.services.CompteService;

@Controller
public class CompteController {

	@Autowired
	private CompteService compteSrv;

	@GetMapping("/inscription")
	public String inscription(Model model) {
		return form(model, new Compte());
	}

	private String form(Model model, Compte compte) {
		model.addAttribute("compte", compte);
		return "inscription";
	}

	@PostMapping("/inscription")
	public String save(@Valid @ModelAttribute Compte compte, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return form(model, compte);
		}
		compteSrv.create(compte);
		return "redirect:/login";
	}
}
