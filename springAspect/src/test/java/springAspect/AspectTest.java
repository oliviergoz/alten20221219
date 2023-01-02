package springAspect;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import springAspect.beans.MonBean;
import springAspect.config.AppConfig;

@SpringJUnitConfig(AppConfig.class)
class AspectTest {

	@Autowired
	MonBean monBean;

	@Test
	void test() {
		monBean.methodeDeMonBean();
	}

}
