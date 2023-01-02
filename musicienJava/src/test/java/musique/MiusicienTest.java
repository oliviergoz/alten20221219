package musique;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import musique.beans.Musicien;
import musique.config.AppConfig;

class MiusicienTest {

	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void initSpring() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
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
		assertNotNull(ctx.getBean("pianiste"));
	}

}
