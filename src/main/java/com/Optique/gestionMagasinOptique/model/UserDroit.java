package com.Optique.gestionMagasinOptique.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class UserDroit {
	@Id
	@SequenceGenerator(name = "Produit_ID_SEQ", sequenceName = "Produit_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produit_ID_SEQ")
	/** @pdOid 10539c27-e46f-485e-a91a-df0917d5c17d */
	private int id;
	/** @pdOid 984c7ff9-c213-4922-8b01-443c3636e3d1 */
	private String dateCreation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDroit")
	private Droit droitB;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Droit getDroitB() {
		return droitB;
	}

	public void setDroitB(Droit droitB) {
		this.droitB = droitB;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
