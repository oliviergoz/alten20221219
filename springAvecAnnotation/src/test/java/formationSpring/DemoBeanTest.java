package formationSpring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.DemoBean;

class DemoBeanTest {

	static ClassPathXmlApplicationContext ctx = null;

	@BeforeAll
	static void lancementSpring() {
		ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
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
		assertNotNull(ctx.getBean("demoBean"));
		DemoBean demoBean = (DemoBean) ctx.getBean("demoBean");
		demoBean = ctx.getBean("demoBean", DemoBean.class);
	
	}

}
