package springAspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import springAspect.beans.MonInterface;
import springAspect.config.AppConfig;

@SpringJUnitConfig(AppConfig.class)
class AspectTest {

	@Autowired
	MonInterface monBean;

	@Test
	void test() {
		System.out.println(monBean.methodeDeMonBean());
	}

}
