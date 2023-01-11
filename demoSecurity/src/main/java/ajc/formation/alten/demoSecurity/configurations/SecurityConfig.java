package ajc.formation.alten.demoSecurity.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
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
				.anyRequest().authenticated()//any request=>toutes les requetes, authenticated=>avoir fourni login/password correct
			.and()	
			.formLogin();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN")
				.and()
				.withUser("admin2").password("{noop}admin2").roles("ADMIN","USER")
				.and()
				.withUser("user").password("{noop}user").roles("USER");
		// @formatter:on

	}
}
