package ajc.formation.alten.formation.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.formation.jsonviews.Views;

@MappedSuperclass
public abstract class Personne {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private Long id;
	@JsonView(Views.Common.class)
	@NotBlank(message = "il faut un prenom")
	private String prenom;
	@NotBlank
	@JsonView(Views.Common.class)
	private String nom;
	@JsonView(Views.Common.class)
	private String email;
	@JsonView(Views.Common.class)
	private String telephone;
	@JsonView(Views.Common.class)
	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNaiss;
	@Embedded
	@JsonView(Views.Common.class)
	private Adresse adresse;

	public Personne() {

	}

	public Personne(String prenom, String nom, String email, String telephone, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDtNaiss() {
		return dtNaiss;
	}

	public void setDtNaiss(LocalDate dtNaiss) {
		this.dtNaiss = dtNaiss;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}
}
