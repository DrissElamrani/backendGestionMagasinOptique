package com.Optique.gestionMagasinOptique.model;

public class LigneCmndFourn {
	   private int id;
	   /** @pdOid 8c6e49c8-c588-4640-bb48-89638f1a272c */
	   private float prixUnitaire;
	   /** @pdOid 2114d814-6d32-4a03-b903-664383c9eedd */
	   private int qteCmdee;
	   
	   private Produit produitB;
	   
	   private CommandeFourn commandeFourn;

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
