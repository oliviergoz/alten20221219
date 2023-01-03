package musique.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import musique.beans.Instrument;
import musique.beans.Musicien;
import musique.beans.Pianiste;
import musique.beans.Piano;

@Configuration
@ComponentScan("musique.beans")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public Instrument piano() {
		return new Piano();
	}

	@Bean
	public Musicien pianiste(@Qualifier("piano") Instrument instrument) {
		Pianiste pianiste = new Pianiste();
		pianiste.setInstrument(instrument);
		return pianiste;
	}
}
