package musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import musique.beans.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("guitariste")
	private Musicien musicien;

	public void run(String... args) {
		musicien.jouerInstrument();
	}
}
