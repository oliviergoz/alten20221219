package ajc.formation.alten.formation.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.formation.entity.Compte;
import ajc.formation.alten.formation.jsonviews.Views;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

	@GetMapping("/api/auth")
	@JsonView(Views.Common.class)
	public Compte authentication(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
