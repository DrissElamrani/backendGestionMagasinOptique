package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Produit;
@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {
	
//	 public Produit findById(int id);

//	 String req="SELECT nom FROM Produit c WHERE TO_DATE('c.dateCreation', 'YYYY/MM/DD') between  TO_DATE("+datedebut+", 'YYYY/MM/DD') and TO_DATE("+datefin+", 'YYYY/MM/DD')";

	 
//	 @Transactional
//	 @Modifying
//	 @org.springframework.data.jpa.repository.Query("DELETE FROM Produit c WHERE c.idClt=:id")
//	 public Integer remove(@Param("id") int id);
//	 
	 

}
