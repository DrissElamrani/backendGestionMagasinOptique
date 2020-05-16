package com.Optique.gestionMagasinOptique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"idClt"})
@Entity
public class Client {

	 @Id
		@SequenceGenerator(name = "CLIENT_ID_SEQ", sequenceName = "CLIENT_ID_SEQ", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_SEQ")
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//	 @GeneratedValue
	   private int idClt;
	   /** @pdOid 1545baf3-d84e-4ff0-8483-2cd24bcb60c5 */
	   private String nom;
	   /** @pdOid 0e900eae-46a6-4b72-87e6-1dc2a0aff6f0 */
	   private String prenom;
	   /** @pdOid 86cdd1a0-51f3-4a3f-ae2d-57f98e64221d */
	   private int numero;
	   /** @pdOid bf33ec4b-95bc-4006-b29f-146163c35381 */
	   private String addresse;
	   /** @pdOid fac8033b-dd30-4ab6-8878-f46d8e724e10 */
	   private String mutuelle;
	   /** @pdOid 3c39fb36-ad5d-4af0-8df0-62be426b2734 */
	   private String dateCreation;
	   private String dateModification;
	   /** @pdOid fd2aae80-c4c6-444c-b06b-441ee90dfd6c */
	   private String remarque;
	   private String email;
//	   @Length(min=9, max=10, message = "le Numero de telephone doit étre égale 10 chiffre")
	   private String telephone;
	
	   
	public String getDateModification() {
		return dateModification;
	}

	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}

	public int getIdClt() {
		return idClt;
	}

	public void setIdClt(int idClt) {
		this.idClt = idClt;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(String mutuelle) {
		this.mutuelle = mutuelle;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
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



	public Client(String nom, String prenom, int numero, String addresse, String mutuelle,
			String dateCreation, String remarque, String email, String telephone,String datemodification) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.addresse = addresse;
		this.mutuelle = mutuelle;
		this.dateCreation = dateCreation;
		this.remarque = remarque;
		this.email = email;
		this.telephone = telephone;
		this.dateModification=datemodification;
	}


//	public Client(String nom, String prenom) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//	}

//	@Override
//	public String toString() {
//		return "Client [nom=" + nom + ", prenom=" + prenom + "]";
//	}

	@Override
	public String toString() {
		return "Client [idClt=" + idClt + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", addresse="
				+ addresse + ", mutuelle=" + mutuelle + ", dateCreation=" + dateCreation + ", dateModification="
				+ dateModification + ", remarque=" + remarque + ", email=" + email + ", telephone=" + telephone + "]";
	}
	public Client() {
		super();
	}
	

	
	
}
