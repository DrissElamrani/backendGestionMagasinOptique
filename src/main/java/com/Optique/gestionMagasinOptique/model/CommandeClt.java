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
public class CommandeClt {
	@Id
	@SequenceGenerator(name = "COMMANDECLT_ID_SEQ", sequenceName = "COMMANDECLT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMANDECLT_ID_SEQ")
	/** @pdOid dbf9e941-67e1-4365-ae42-32089348dfd8 */
	private int idCmdeeClt;
	/** @pdOid 8582b1c7-2453-463d-9778-b763df453554 */
	private String dateCommande;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idClt")
	private Client client;

	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdCmdeeClt() {
		return idCmdeeClt;
	}

	public void setIdCmdeeClt(int idCmdeeClt) {
		this.idCmdeeClt = idCmdeeClt;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
