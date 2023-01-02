package formationSpring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("monBean")
public class DemoBean {
	private String nom;
	@Autowired
	private AutreBean autreBean;

	public DemoBean() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public AutreBean getAutreBean() {
		return autreBean;
	}

	public void setAutreBean(AutreBean autreBean) {
		this.autreBean = autreBean;
	}

}
