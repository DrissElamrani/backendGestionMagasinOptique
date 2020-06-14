package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Monture;
@Repository
public interface MontureDao extends JpaRepository<Monture, Integer> {
	
	 public Monture findById(int id);

//	 String req="SELECT nom FROM Client c WHERE TO_DATE('c.dateCreation', 'YYYY/MM/DD') between  TO_DATE("+datedebut+", 'YYYY/MM/DD') and TO_DATE("+datefin+", 'YYYY/MM/DD')";
//     String req="";
//	 
//     @Query(req)
//	 public List<Client> searchClient(@Param("id") int id);

	 
//	 @Transactional
//	 @Modifying
//	 @org.springframework.data.jpa.repository.Query("DELETE FROM Client c WHERE c.idClt=:id")
//	 public Integer remove(@Param("id") int id);
//	 
	 

}
