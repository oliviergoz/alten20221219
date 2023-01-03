package exoFormation.entity;

public enum Ram {
	GO4("4Go"),GO8("8Go"),GO16("16Go");
	
	private String libelle;
	
	private Ram(String libelle) {
		this.libelle=libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
}
