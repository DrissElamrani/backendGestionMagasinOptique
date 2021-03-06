package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Lentille;
import com.Optique.gestionMagasinOptique.model.LunetteSolaire;
@Repository
public interface LunetteSolaireDao extends JpaRepository<LunetteSolaire, Integer> {
	
	 public LunetteSolaire findById(int id);

//	 String req="SELECT nom FROM Client c WHERE TO_DATE('c.dateCreation', 'YYYY/MM/DD') between  TO_DATE("+datedebut+", 'YYYY/MM/DD') and TO_DATE("+datefin+", 'YYYY/MM/DD')";
//     String req="";
//	 
//     @Query(req)
//	 public List<Client> searchClient(@Param("id") int id);

	 
	 @org.springframework.data.jpa.repository.Query("select l FROM LunetteSolaire l WHERE l.status='1'")
	 public List<LunetteSolaire> listLunetteSolaire();
//	 
	 

}
