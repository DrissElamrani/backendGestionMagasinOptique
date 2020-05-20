package com.Optique.gestionMagasinOptique.model;

public class UserDroit {
	   /** @pdOid 10539c27-e46f-485e-a91a-df0917d5c17d */
	   private int id;
	   /** @pdOid 984c7ff9-c213-4922-8b01-443c3636e3d1 */
	   private String dateCreation;
	   
	   private Droit droitB;
	   
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
