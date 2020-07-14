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
public class LigneReglmClt {
	@Id
	@SequenceGenerator(name = "LIGNEREGLMCLT_ID_SEQ", sequenceName = "LIGNEREGLMCLT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIGNEREGLMCLT_ID_SEQ")
	private int id;
	/** @pdOid cfdf5a64-2596-412d-9d24-ecc46c03c1b0 */
	private String dateCreation;
	/** @pdOid 02a2cd7d-b087-4959-b95a-118ca070fae3 */
	private float montant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReglmClt")
	public ReglementClt reglementCltB;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCmdeeClt")
	private CommandeClt commandeClt;

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
