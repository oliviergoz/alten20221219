package musique.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

	public Guitariste() {
		// injection non disponible dans le constructeur
		// System.out.println(instrument); forcement null
	}

	@PostConstruct
	public void init() {
		System.out.println(instrument);
	}

	@Override
	public void jouerInstrument() {
		instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
