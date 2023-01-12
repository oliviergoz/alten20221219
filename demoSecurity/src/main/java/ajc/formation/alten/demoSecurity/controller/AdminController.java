package ajc.formation.alten.demoSecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ajc.formation.alten.demoSecurity.entities.Utilisateur;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@GetMapping("")
	// public String home(@AuthenticationPrincipal UserDetails user ) {
	public String home(@AuthenticationPrincipal Utilisateur user,Model model) {
		LOGGER.debug(user.toString());
		model.addAttribute("utilisateur", user);
		return "admin/home";
	}
}
