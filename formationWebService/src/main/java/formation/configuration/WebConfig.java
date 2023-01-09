package formation.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import formation.config.JpaConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "formation.restcontroller")
@Import(JpaConfig.class)
public class WebConfig {

	

}
