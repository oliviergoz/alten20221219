package exoFormation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import exoFormation.config.JpaConfig;
import exoFormation.entity.Formateur;
import exoFormation.exception.FormateurException;
import exoFormation.repository.FormateurRepository;

@SpringJUnitConfig(JpaConfig.class)
class FormateurRepositoryTest {

	@Autowired
	private FormateurRepository formateurRepo;
	
	@Test
	void requetePerso() {
		formateurRepo.findByInterneIsTrue();
		formateurRepo.findByNomContaining("o");
		
	}

	@Test
	@Disabled
	void test() {
		Formateur f = formateurRepo.findById(50L).orElseThrow(FormateurException::new);
		assertTrue(f instanceof Formateur);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		}
	}

	@Test
	@Disabled
	void findByIdException() {
		assertThrows(FormateurException.class, () -> {
			formateurRepo.findById(500L).orElseThrow(FormateurException::new);
		});
	}

	@Test
	@Disabled
	void PageTest() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Formateur> page = formateurRepo.findAll(pageable);
		System.out.println(page);
		page.forEach(f -> {
			System.out.println(f.getId());
		});
		page = formateurRepo.findAll(page.nextOrLastPageable());
		System.out.println(page);
		page.forEach(f -> {
			System.out.println(f.getId());
		});
	}
	
	

}
