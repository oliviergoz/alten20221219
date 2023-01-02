package musique;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import musique.beans.Musicien;

class MiusicienTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeAll
	static void initSpring() {
		ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	}

	@AfterAll
	static void closeSpring() {
		ctx.close();
	}

	@Test
	void musicienTest() {
		Musicien musicien = ctx.getBean("guitariste", Musicien.class);
		assertNotNull(musicien);
		assertNotNull(musicien.getInstrument());
	}

}
