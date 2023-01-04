package exoFormation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import exoFormation.config.JpaConfig;
import exoFormation.entity.Adresse;
import exoFormation.entity.Formateur;
import exoFormation.exception.FormateurException;
import exoFormation.exception.IdException;
import exoFormation.service.FormateurService;

@SpringJUnitConfig(JpaConfig.class)
class FormateurServiceTest {

	@Autowired
	private FormateurService formateurSrv;

	@Test
	void test() {
		assertNotNull(formateurSrv);
	}

	@Test
	public void insert() {
		Formateur f = new Formateur("test", "test", "test", "test", new Adresse("test", "test", "test", "test"), false,
				0);
		formateurSrv.create(f);
		assertNotNull(formateurSrv.getById(f.getId()));
	}

	@Test
	void insertError() {
		Formateur f = new Formateur(null, "test", "test", "test", new Adresse("test", "test", "test", "test"), false,
				0);

		assertThrows(FormateurException.class, () -> {
			formateurSrv.create(f);
		});

		assertThrows(FormateurException.class, () -> {
			formateurSrv.create(
					new Formateur("", "test", "test", "test", new Adresse("test", "test", "test", "test"), false, 0));
		});
	}

	@Test
	void findById() {
		assertThrows(IdException.class, () -> {
			formateurSrv.getById(null);
		});
		assertThrows(FormateurException.class, () -> {
			formateurSrv.getById(1L);
		});
	}

}
