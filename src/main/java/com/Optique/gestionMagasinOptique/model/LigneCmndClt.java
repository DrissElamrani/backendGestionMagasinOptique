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
public class LigneCmndClt {
	@Id
	@SequenceGenerator(name = "LIGNECMNDCLT_ID_SEQ", sequenceName = "LIGNECMNDCLT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIGNECMNDCLT_ID_SEQ")
	/** @pdOid a2e17b52-19da-44d5-b22e-0653e7078ebb */
	private int id;
	/** @pdOid 57a5184c-a36c-40e0-a90e-6b9277348dba */
	private int prixUnitaire;
	/** @pdOid fc6a01e4-fe89-46ce-9380-2a69b9da77cf */
	private int qteCmdee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProd")
	public Produit produitB;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCmdeeClt")
	private CommandeClt commandeClt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
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

	public CommandeClt getCommandeClt() {
		return commandeClt;
	}

	public void setCommandeClt(CommandeClt commandeClt) {
		this.commandeClt = commandeClt;
	}

}
