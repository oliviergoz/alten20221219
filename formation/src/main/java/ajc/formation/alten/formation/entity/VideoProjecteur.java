package ajc.formation.alten.formation.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("video")
public class VideoProjecteur extends Materiel {
	@Enumerated(EnumType.STRING)
	private Resolution resolution;

	public VideoProjecteur() {

	}

	public VideoProjecteur(String libelle, String description, Resolution resolution) {
		super(libelle, description);
		this.resolution = resolution;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

}
