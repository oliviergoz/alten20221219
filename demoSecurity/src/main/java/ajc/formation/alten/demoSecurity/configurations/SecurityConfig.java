package ajc.formation.alten.demoSecurity.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//ancienne version
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	// definir les regles d'acces au URL
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**") //urls concernées par la regle que je definie
			.csrf().disable()  //csrf à couper pour faire simple
			.authorizeRequests() //definition des regles
				.antMatchers("/public/**").permitAll()  //toutes les requetes vers /public avec n'importe quoi derriere passent
				//.antMatchers(null) on peut en mettre autant qu'on veut
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()//any request=>toutes les requetes, authenticated=>avoir fourni login/password correct
			.and()	
			.formLogin();
		// @formatter:on
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		//authentification en memoire
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN")
//				.and()
//				.withUser("admin2").password("{noop}admin2").roles("ADMIN","USER")
//				.and()
//				.withUser("user").password("{noop}user").roles("USER");
		
		//base de donnees
		auth.userDetailsService(userDetailsService);
		
		// @formatter:on

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
