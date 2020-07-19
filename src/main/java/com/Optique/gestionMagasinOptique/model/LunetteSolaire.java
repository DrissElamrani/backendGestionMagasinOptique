package com.Optique.gestionMagasinOptique.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lunettesolaire")
public class LunetteSolaire extends Produit {
	/** @pdOid 4504d9b3-5ae4-48b2-956a-43dd548d92f6 */
	private String categorie;
	/** @pdOid edba20b4-77f8-4965-aca4-f6bd1d8eb31f */
	private String type;

	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
