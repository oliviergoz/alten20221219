package musique;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import musique.beans.Musicien;
import musique.config.AppConfig;

@SpringJUnitConfig(AppConfig.class)
class SpringTest {

	@Autowired
	@Qualifier("guitariste")
	Musicien guitariste;

	@Autowired
	@Qualifier("pianiste")
	Musicien pianiste;

	@Test
	void PianisteExist() {
		assertNotNull(pianiste);
	}

	@Test
	void GuitaristeExist() {
		assertNotNull(guitariste);
	}

}
