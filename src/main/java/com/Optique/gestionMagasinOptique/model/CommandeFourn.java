package com.Optique.gestionMagasinOptique.model;

public class CommandeFourn {
	   /** @pdOid d4606277-1b45-4f84-9b4c-abc987e429d6 */
	   private int idCmdeeFourn;
	   /** @pdOid 2793ec52-ea0f-47de-a3b7-b0166cf09169 */
	   private String dateCommande;
	   
	   private Fournisseur fournisseur;

	public int getIdCmdeeFourn() {
		return idCmdeeFourn;
	}

	public void setIdCmdeeFourn(int idCmdeeFourn) {
		this.idCmdeeFourn = idCmdeeFourn;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	   
	   
}
