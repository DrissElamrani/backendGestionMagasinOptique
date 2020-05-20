package com.Optique.gestionMagasinOptique.model;

public class LigneReglmClt {
	   private int id;
	   /** @pdOid cfdf5a64-2596-412d-9d24-ecc46c03c1b0 */
	   private String dateCreation;
	   /** @pdOid 02a2cd7d-b087-4959-b95a-118ca070fae3 */
	   private float montant;
	   
	   public ReglementClt reglementCltB;
	   
	   private CommandeClt commandeClt;

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

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public ReglementClt getReglementCltB() {
		return reglementCltB;
	}

	public void setReglementCltB(ReglementClt reglementCltB) {
		this.reglementCltB = reglementCltB;
	}

	public CommandeClt getCommandeClt() {
		return commandeClt;
	}

	public void setCommandeClt(CommandeClt commandeClt) {
		this.commandeClt = commandeClt;
	}
}
