package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import formationSpring.beans.AutreBean;
import formationSpring.beans.DemoBean;

@Configuration
@ComponentScan({"formationSpring.beans"})
public class AppConfig {

//	@Bean
//	public AutreBean autreBean() {
//		return new AutreBean();
//	}
//
//	@Bean("monBean")
//	public DemoBean monBean(AutreBean autreBean) {
//		DemoBean demoBean = new DemoBean();
//		demoBean.setAutreBean(autreBean);
//		demoBean.setNom("olivier");
//		return demoBean;
//	}
}
