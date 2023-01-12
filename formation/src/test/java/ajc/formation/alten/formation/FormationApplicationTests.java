package ajc.formation.alten.formation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ajc.formation.alten.formation.entity.Compte;
import ajc.formation.alten.formation.entity.Role;
import ajc.formation.alten.formation.services.CompteService;

@SpringBootTest
class FormationApplicationTests {

	@Autowired
	private CompteService compteSrv;

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void initCompte() {
		compteSrv.create(new Compte("interne", "interne", Role.ROLE_INTERNE));
		compteSrv.create(new Compte("user1", "user1", Role.ROLE_USER));
	}

}
