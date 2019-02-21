package fr.jpa.tp4;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="montant")
	private double montant;
	
	@Column(name="modif")
	private String modif;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Compte monCompte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getModif() {
		return modif;
	}

	public void setModif(String modif) {
		this.modif = modif;
	}

	public Compte getMonCompte() {
		return monCompte;
	}

	public void setMonCompte(Compte monCompte) {
		this.monCompte = monCompte;
	}
	

}
