package ajc.formation.alten.formation.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("pc")
public class Ordinateur extends Materiel {
	@Enumerated(EnumType.ORDINAL)
	private Ram ram;
	@Enumerated(EnumType.STRING)
	private Processeur processeur;

	public Ordinateur() {

	}

	public Ordinateur(String libelle, String description, Ram ram, Processeur processeur) {
		super(libelle, description);
		this.ram = ram;
		this.processeur = processeur;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Processeur getProcesseur() {
		return processeur;
	}

	public void setProcesseur(Processeur processeur) {
		this.processeur = processeur;
	}

}
