package ajc.formation.alten.formation.entity;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
@AttributeOverride(name = "adresse.numero", column = @Column(name = "participant_numero", length = 50))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "participant_rue", length = 255))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "participant_cp", length = 50))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "participant_ville", length = 255))
@AttributeOverride(name = "id", column = @Column(name = "participant_id"))
@AttributeOverride(name = "prenom", column = @Column(name = "participant_prenom", length = 255, nullable = false))
@AttributeOverride(name = "nom", column = @Column(name = "participant_nom", length = 255, nullable = false))
@AttributeOverride(name = "email", column = @Column(name = "participant_email", length = 255))
@AttributeOverride(name = "telephone", column = @Column(name = "participant_telephone", length = 255))
@SequenceGenerator(name = "seqPersonne", sequenceName = "participant_seq", initialValue = 50, allocationSize = 1)
public class Participant extends Personne {
	@Column(name = "dt_naiss")
	private LocalDate dateNaissance;

	@OneToOne
	@JoinColumn(name = "participant_pc_id", foreignKey = @ForeignKey(name = "participant_pc_id_fk"))
	private Ordinateur ordinateur;

	public Participant() {

	}

	public Participant(String prenom, String nom, String email, String telephone, Adresse adresse,
			LocalDate dateNaissance) {
		super(prenom, nom, email, telephone, adresse);
		this.dateNaissance = dateNaissance;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

}
