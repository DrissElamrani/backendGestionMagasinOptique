package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Fournisseur;
@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur, Integer>{
	
//	public List <Client> findall();
	 public Fournisseur findById(int id);
	 
//	 @org.springframework.data.jpa.repository.Query("SELECT nom FROM Client c WHERE c.idClt=:id")
//	 public String getNomById(@Param("id") int id);

	 
	 @org.springframework.data.jpa.repository.Query("select f FROM Fournisseur f WHERE f.status='1'")
	 public List<Fournisseur> listFournisseur(); 
	 

}
