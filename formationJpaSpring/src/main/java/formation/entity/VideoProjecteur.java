package formation.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
