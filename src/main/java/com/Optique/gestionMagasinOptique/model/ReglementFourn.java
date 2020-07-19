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
public class ReglementFourn {
	@Id
	@SequenceGenerator(name = "Produit_ID_SEQ", sequenceName = "Produit_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produit_ID_SEQ")
	/** @pdOid cf6aad58-1acd-4428-bf3c-1821894af867 */
	private int idReglmFourn;
	/** @pdOid e198cb95-8286-463f-9465-b85aaf53f605 */
	private float montantTotal;
	/** @pdOid 97134b82-aaaf-470e-8ce9-580207233d08 */
	private float montantRest;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdReglmFourn() {
		return idReglmFourn;
	}

	public void setIdReglmFourn(int idReglmFourn) {
		this.idReglmFourn = idReglmFourn;
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

//	public Fournisseur getFournisseur() {
//		return fournisseur;
//	}
//
//	public void setFournisseur(Fournisseur fournisseur) {
//		this.fournisseur = fournisseur;
//	}
}
