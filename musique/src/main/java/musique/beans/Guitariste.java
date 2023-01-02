package musique.beans;

public class Guitariste implements Musicien {

	private Guitare instrument;

	@Override
	public void jouerInstrument() {
		instrument.jouer();
	}

	public Guitare getInstrument() {
		return instrument;
	}

	public void setInstrument(Guitare instrument) {
		this.instrument = instrument;
	}

}
