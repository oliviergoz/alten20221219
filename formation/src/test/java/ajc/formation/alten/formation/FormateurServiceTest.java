package ajc.formation.alten.formation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ajc.formation.alten.formation.entity.Adresse;
import ajc.formation.alten.formation.entity.Formateur;
import ajc.formation.alten.formation.exception.FormateurException;
import ajc.formation.alten.formation.exception.IdException;
import ajc.formation.alten.formation.services.FormateurService;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
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
