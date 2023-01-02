package formationSpring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.DemoBean;
import formationSpring.config.AppConfig;

class DemoBeanTest {

	static AnnotationConfigApplicationContext ctx = null;

	@BeforeAll
	static void lancementSpring() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterAll
	static void fermetureSpring() {
		ctx.close();
	}

	@Test
	void lancementSpringTest() {
		assertNotNull(ctx);
	}

	@Test
	void chargementDemoBeanTest() {
		assertNotNull(ctx.getBean("monBean"));
		DemoBean demoBean = (DemoBean) ctx.getBean("monBean");
		demoBean = ctx.getBean("monBean", DemoBean.class);
		//assertEquals("olivier", demoBean.getNom());
	}

}
