package ajc.formation.alten.demoSecurity;

import org.assertj.core.api.PathAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import ajc.formation.alten.demoSecurity.entities.Role;
import ajc.formation.alten.demoSecurity.entities.Utilisateur;
import ajc.formation.alten.demoSecurity.repositories.UtilisateurRepository;

@SpringBootTest
class DemoSecurityApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void initUser() {
		Utilisateur admin = new Utilisateur("admin", passwordEncoder.encode("admin"), Role.ROLE_ADMIN);
		utilisateurRepo.save(admin);
		utilisateurRepo.save(new Utilisateur("user", passwordEncoder.encode("user"), Role.ROLE_USER));
	}

}
