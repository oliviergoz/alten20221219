package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	//@RequestMapping("/page1")
	@GetMapping("/page1")
	public String page1() {
		return "page1";
	}
}
