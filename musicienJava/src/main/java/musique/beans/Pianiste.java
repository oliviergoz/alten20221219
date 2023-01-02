package musique.beans;

public class Pianiste implements Musicien {

	private Instrument instrument;

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
