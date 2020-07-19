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
public class LigneCmndFourn {
	@Id
	@SequenceGenerator(name = "LIGNECMNDFOURN_ID_SEQ", sequenceName = "LIGNECMNDFOURN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIGNECMNDFOURN_ID_SEQ")
	private int id;
	/** @pdOid 8c6e49c8-c588-4640-bb48-89638f1a272c */
	private float prixUnitaire;
	/** @pdOid 2114d814-6d32-4a03-b903-664383c9eedd */
	private int qteCmdee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProd")
	private Produit produitB;

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

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQteCmdee() {
		return qteCmdee;
	}

	public void setQteCmdee(int qteCmdee) {
		this.qteCmdee = qteCmdee;
	}

	public Produit getProduitB() {
		return produitB;
	}

	public void setProduitB(Produit produitB) {
		this.produitB = produitB;
	}

	public CommandeFourn getCommandeFourn() {
		return commandeFourn;
	}

	public void setCommandeFourn(CommandeFourn commandeFourn) {
		this.commandeFourn = commandeFourn;
	}
}
