package ajc.formation.alten.formation.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.formation.entity.Compte;
import ajc.formation.alten.formation.jsonviews.Views;
import ajc.formation.alten.formation.repository.CompteRepository;
import ajc.formation.alten.formation.services.CompteService;

@CrossOrigin(origins = "*")
@RestController
public class CompteRestController {
	
	@Autowired
	private CompteService compteSrv;


	@PostMapping("/api/inscription")
	@JsonView(Views.Common.class)
	public Compte inscription(@Valid @RequestBody Compte compte,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteSrv.createUser(compte);
	}
	
	@GetMapping("/api/compte/checklogin/{login}")
	public boolean checkLoginExist(@PathVariable String login) {
		return compteSrv.loginExist(login);
	}
}
