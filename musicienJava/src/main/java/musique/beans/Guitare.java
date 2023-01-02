package musique.beans;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument{

	@Override
	public void jouer() {
		System.out.println("je suis guitare");
	}

}
