package com.Optique.gestionMagasinOptique.model;

public class Produit {
	   /** @pdOid bbc3c6ac-5caf-4453-83f4-390783cc0a3f */
	   private int idProd;
	   /** @pdOid 3c504c81-c35a-4dad-88f9-4491f9a61649 */
	   private String nomProd;
	   /** @pdOid b16d276d-a182-47da-820d-404e8e61a1ab */
	   private int qteProd;
	   /** @pdOid ee4016b0-afa1-49f7-abce-d563b554a76a */
	   private String dateCreation;
	   /** @pdOid 94a8cf96-78d8-42c6-81b7-5e7142c09cbd */
	   private Float prixUnitaire;
	   /** @pdOid 1de3b460-65d8-49db-9c58-b73fb1ab6fd1 */
	   private String dateModification;
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public int getQteProd() {
		return qteProd;
	}
	public void setQteProd(int qteProd) {
		this.qteProd = qteProd;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getDateModification() {
		return dateModification;
	}
	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}
}
