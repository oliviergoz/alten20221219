package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("")
	public String home(@RequestParam(value = "prenom", required = false, defaultValue = "olivier") String prenom, Model model) {
		model.addAttribute("prenom", prenom);
		return "public/home";
	}
}
