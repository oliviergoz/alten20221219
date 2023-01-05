package demoMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demoMvc.model.Personne;

@Controller
@RequestMapping("/exercice")
public class ExerciceController {

	@GetMapping("")
	public String form() {
		return "exercice/form";
	}

	@PostMapping("")
	public String traitementForm(@ModelAttribute Personne personne, Model model) {
		if (personne.getPrenom().isEmpty() || personne.getNom().isEmpty()) {
			model.addAttribute("error", true);
			model.addAttribute("personne", personne);
			return "exercice/form";
		}
		model.addAttribute("personne", personne);
		return "exercice/hello";
	}
}
