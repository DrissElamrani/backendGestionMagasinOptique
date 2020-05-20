package com.Optique.gestionMagasinOptique.model;

public class Droit {
	   private int idDroit;
	   /** @pdOid 64124545-a251-449d-baa3-c294fa4d0be4 */
	   private String role;
	   /** @pdOid 059cd7a0-6b0d-446c-834b-1cbbc79efb2e */
	   private String dateCreation;
	public int getIdDroit() {
		return idDroit;
	}
	public void setIdDroit(int idDroit) {
		this.idDroit = idDroit;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
}
