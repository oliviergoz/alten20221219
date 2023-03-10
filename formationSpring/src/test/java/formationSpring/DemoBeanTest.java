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
		// demander à spring un objet
//		assertNotNull(ctx.getBean(DemoBean.class));
//		DemoBean demo=ctx.getBean(DemoBean.class);
		// si plusieurs beans correspondent=>error
		assertNotNull(ctx.getBean("monBean2"));
		assertNotNull(ctx.getBean("monBean"));
		assertNotEquals(ctx.getBean("monBean2"), ctx.getBean("monBean"));
		DemoBean demoBean = (DemoBean) ctx.getBean("monBean");
		demoBean = ctx.getBean("monBean", DemoBean.class);
		assertEquals("olivier", demoBean.getNom());
	}

}
