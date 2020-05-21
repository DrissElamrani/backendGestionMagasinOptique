/***********************************************************************
 * Module:  User.java
 * Author:  pcuser9
 * Purpose: Defines the Class User
 ***********************************************************************/
package com.Optique.gestionMagasinOptique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
/** @pdOid 7fd63309-7eef-4baf-9672-40fd59868db3 */
public class User {
	@Id
	@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
	// @GeneratedValue(strategy=GenerationType.AUTO)
	// @GeneratedValue
	/** @pdOid 1b9ad889-7fb9-4178-be6c-c3fd588739a6 */
	private int idUser;
	/** @pdOid 545a6582-2e30-41f2-b715-01a947420bcb */
	private String nom;
	/** @pdOid ce3c26eb-0a8d-45d2-8914-12379cd8dccc */
	private String prenom;
	/** @pdOid 73fbfeef-3844-4746-9d93-8193c08e5f2c */
	private String tel;
	/** @pdOid 1fc132be-4779-4170-a315-523e344949e9 */
	private String email;
	/** @pdOid 9f487664-4b04-45fd-b925-850f74007ea0 */
	private String addresse;
	/** @pdOid 8d2be185-894e-4525-a29f-2a11e80a20f0 */
	private String login;
	/** @pdOid e29aa884-4688-4e9f-ac10-db36a8a77346 */
	private String motdepasse;
	private String dateCreation;
	private String datemodification;

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDatemodification() {
		return datemodification;
	}

	public void setDatemodification(String datemodification) {
		this.datemodification = datemodification;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public User() {
		super();
	}

	public User(String nom, String prenom, String tel, String email, String addresse, String login, String motdepasse,
			String dateCreation, String datemodification) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.addresse = addresse;
		this.login = login;
		this.motdepasse = motdepasse;
		this.dateCreation = dateCreation;
		this.datemodification = datemodification;
	}

	public User(int idUser) {
		super();
		this.idUser = idUser;
	}

	/**
	 * @pdRoleInfo migr=no name=UserJournals assc=associationUserUserJournals
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	// public List<UserJournals> userJournals;
	// public java.util.Collection associationUserDroit;

	/** @pdGenerated default getter */
	// public java.util.Collection<UserJournals> getUserJournals() {
	// if (userJournals == null)
	// userJournals = new java.util.HashSet<UserJournals>();
	// return userJournals;
	// }

	/** @pdGenerated default iterator getter */
	// public java.util.Iterator getIteratorUserJournals() {
	// if (userJournals == null)
	// userJournals = new java.util.HashSet<UserJournals>();
	// return userJournals.iterator();
	// }

	/**
	 * @pdGenerated default setter
	 * @param newUserJournals
	 */
	// public void setUserJournals(java.util.Collection<UserJournals>
	// newUserJournals) {
	// removeAllUserJournals();
	// for (java.util.Iterator iter = newUserJournals.iterator(); iter.hasNext();)
	// addUserJournals((UserJournals)iter.next());
	// }

	/**
	 * @pdGenerated default add
	 * @param newUserJournals
	 */
	// public void addUserJournals(UserJournals newUserJournals) {
	// if (newUserJournals == null)
	// return;
	// if (this.userJournals == null)
	// this.userJournals = new java.util.HashSet<UserJournals>();
	// if (!this.userJournals.contains(newUserJournals))
	// this.userJournals.add(newUserJournals);
	// }

	/**
	 * @pdGenerated default remove
	 * @param oldUserJournals
	 */
	// public void removeUserJournals(UserJournals oldUserJournals) {
	// if (oldUserJournals == null)
	// return;
	// if (this.userJournals != null)
	// if (this.userJournals.contains(oldUserJournals))
	// this.userJournals.remove(oldUserJournals);
	// }

	/** @pdGenerated default removeAll */
	// public void removeAllUserJournals() {
	// if (userJournals != null)
	// userJournals.clear();
	// }

}