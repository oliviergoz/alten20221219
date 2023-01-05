package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("")
	public String home(@RequestParam String prenom) {
		System.out.println(prenom);
		return "public/home";
	}
}
