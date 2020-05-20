package com.Optique.gestionMagasinOptique.model;

public class ReglementClt {
	   /** @pdOid 03324c62-1c2d-46de-94a7-9d0be102ce66 */
	   private int idReglmClt;
	   /** @pdOid 4e690eb8-4c39-4dc0-aecf-09983189e45b */
	   private float montantTotal;
	   /** @pdOid 83bcf6a0-3662-458d-94ae-b759e577b6e3 */
	   private float montantRest;
	   
	   private Client client;

	public int getIdReglmClt() {
		return idReglmClt;
	}

	public void setIdReglmClt(int idReglmClt) {
		this.idReglmClt = idReglmClt;
	}

	public float getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

	public float getMontantRest() {
		return montantRest;
	}

	public void setMontantRest(float montantRest) {
		this.montantRest = montantRest;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
