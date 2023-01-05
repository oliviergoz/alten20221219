package demoMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exercice")
public class ExerciceController {

	@GetMapping("")
	public String form() {
		return "exercice/form";
	}

	@PostMapping("")
	public String traitementForm(@RequestParam(name = "login", required = false, defaultValue = "") String login,
			Model model) {
		if (login.isEmpty()) {
			model.addAttribute("error", true);
			return "exercice/form";

		}
		model.addAttribute("login", login);
		return "exercice/hello";
	}
}
