package ajc.formation.alten.formation.services;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.alten.formation.entity.Compte;
import ajc.formation.alten.formation.entity.Role;
import ajc.formation.alten.formation.exception.CompteException;
import ajc.formation.alten.formation.repository.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private Validator validator;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Compte getByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(CompteException::new);
	}

	public Compte create(Compte compte) {
		if (!validator.validate(compte).isEmpty()) {
			throw new CompteException();
		}
		compte.setRole(Role.ROLE_USER);
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		return compteRepo.save(compte);
	}
}
