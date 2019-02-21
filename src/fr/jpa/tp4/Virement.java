package fr.jpa.tp4;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {
	
	private String beneficiare;
	

	public String getBeneficiare() {
		return beneficiare;
	}
	

	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}
	

}
