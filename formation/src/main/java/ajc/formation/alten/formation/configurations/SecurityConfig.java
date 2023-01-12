package ajc.formation.alten.formation.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return  http.antMatcher("/**")
					.csrf().disable()
		            .authorizeRequests()
		            	.antMatchers("/formation","/formateur").authenticated()
		            	.antMatchers("/inscription").anonymous()
		            	.anyRequest().hasRole("INTERNE")
		            .and()	
					.formLogin()
					.and()
					.build();
		// @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
