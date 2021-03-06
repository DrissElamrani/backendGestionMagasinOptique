package com.Optique.gestionMagasinOptique.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LigneReglmFourn {
	/** @pdOid 392aba3e-4aa3-46bc-93c1-232aaaccad99 */
	private int id;
	/** @pdOid c7093a08-9ba2-4c08-b414-ae5f5e769302 */
	private String dateCreation;
	/** @pdOid b8fa03e0-7065-4054-b599-7ed339a23311 */
	private float montant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReglmFourn")
	private ReglementFourn reglementFournB;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCmdeeFourn")
	private CommandeFourn commandeFourn;

	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
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

	public ReglementFourn getReglementFournB() {
		return reglementFournB;
	}

	public void setReglementFournB(ReglementFourn reglementFournB) {
		this.reglementFournB = reglementFournB;
	}

	public CommandeFourn getCommandeFourn() {
		return commandeFourn;
	}

	public void setCommandeFourn(CommandeFourn commandeFourn) {
		this.commandeFourn = commandeFourn;
	}

}
