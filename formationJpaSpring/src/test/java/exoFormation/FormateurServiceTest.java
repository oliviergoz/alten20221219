package exoFormation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import exoFormation.config.JpaConfig;
import exoFormation.service.FormateurService;

@SpringJUnitConfig(JpaConfig.class)
class FormateurServiceTest {

	@Autowired
	private FormateurService formateurSrv;

	@Test
	void test() {
		assertNotNull(formateurSrv);
	}

}
