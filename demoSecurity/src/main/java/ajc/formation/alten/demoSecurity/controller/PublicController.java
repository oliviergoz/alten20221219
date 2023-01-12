package ajc.formation.alten.demoSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("")
	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("isAnonymous()")
	//@PreAuthorize("isAuthenticated()")
	public String home() {
		return "public/home";
	}
}
