package com.Optique.gestionMagasinOptique.model;

public class Devis {
	   private int idDevis;
	   /** @pdOid e984a9c8-5551-4033-9173-d6534ccdff4a */
	   private int numero;
	   /** @pdOid bb98fb76-483a-43b1-9592-79f816579538 */
	   private String dateCreation;
	   private Client client;
	public int getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(int idDevis) {
		this.idDevis = idDevis;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	   
	   
}
