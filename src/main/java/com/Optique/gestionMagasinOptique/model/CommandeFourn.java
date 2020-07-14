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
public class CommandeFourn {
	@Id
	@SequenceGenerator(name = "COMMANDEFOURN_ID_SEQ", sequenceName = "COMMANDEFOURN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMANDEFOURN_ID_SEQ")
	/** @pdOid d4606277-1b45-4f84-9b4c-abc987e429d6 */
	private int idCmdeeFourn;
	/** @pdOid 2793ec52-ea0f-47de-a3b7-b0166cf09169 */
	private String dateCommande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFourn")
	private Fournisseur fournisseur;

	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
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
