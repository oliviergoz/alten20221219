package ajc.formation.alten.formation.entity;

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
