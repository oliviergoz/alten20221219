package exoFormation;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import exoFormation.config.JpaConfig;
import exoFormation.dao.DaoFormateur;
import exoFormation.entity.Formateur;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class DaoFormateurTest {

	@Autowired
	DaoFormateur daoFormateur;

	@Test
	//@Commit
	void InsertTest() {
		Formateur formateur = new Formateur("olivier", "gozlan", "olivier@xxx.fr", "111111", null, true, 11111);
		assertNull(formateur.getId());
		daoFormateur.insert(formateur);
		assertNotNull(formateur.getId());
		assertNotNull(daoFormateur.findByKey(formateur.getId()));
	}

}
