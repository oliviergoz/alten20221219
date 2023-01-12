package ajc.formation.alten.formation.entity;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "salle")
@SequenceGenerator(name = "seqSalle", sequenceName = "salle_salle_id", initialValue = 10, allocationSize = 1)
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalle")
	@Column(name = "salle_id")
	private Long id;
	@Column(name = "salle_nom")
	private String nom;
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "salle_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "salle_rue", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "salle_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "salle_ville", length = 255)) })
	private Adresse adresse;

	public Salle() {

	}

	public Salle(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(id, other.id);
	}

}
