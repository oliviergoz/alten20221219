package formationSpring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DemoBean {
	private String nom;
	@Autowired
	// @Qualifier("autreBean") si plusieurs bean disponible
	@Qualifier("autreBean")
	private AutreBean injection;

	public DemoBean() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public AutreBean getInjection() {
		return injection;
	}

	public void setInjection(AutreBean injection) {
		this.injection = injection;
	}

}
