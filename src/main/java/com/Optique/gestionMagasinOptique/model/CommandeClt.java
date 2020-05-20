package com.Optique.gestionMagasinOptique.model;

public class CommandeClt {
	   /** @pdOid dbf9e941-67e1-4365-ae42-32089348dfd8 */
	   private int idCmdeeClt;
	   /** @pdOid 8582b1c7-2453-463d-9778-b763df453554 */
	   private String dateCommande;
	   private Client client;
	public int getIdCmdeeClt() {
		return idCmdeeClt;
	}
	public void setIdCmdeeClt(int idCmdeeClt) {
		this.idCmdeeClt = idCmdeeClt;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	   
}
