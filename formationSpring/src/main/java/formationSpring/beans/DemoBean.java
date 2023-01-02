package formationSpring.beans;

public class DemoBean {
	private String nom;
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
