package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Monture;
import com.Optique.gestionMagasinOptique.model.User;
import com.Optique.gestionMagasinOptique.model.Verre;
@Repository
public interface VerreDao extends JpaRepository<Verre, Integer> {
	
	 public Verre findById(int id);

//	 String req="SELECT nom FROM Client c WHERE TO_DATE('c.dateCreation', 'YYYY/MM/DD') between  TO_DATE("+datedebut+", 'YYYY/MM/DD') and TO_DATE("+datefin+", 'YYYY/MM/DD')";
//     String req="";
//	 
//     @Query(req)
//	 public List<Client> searchClient(@Param("id") int id);

	 
	 @org.springframework.data.jpa.repository.Query("select v FROM Verre v WHERE v.status='1'")
	 public List<Verre> listVerre();
//	 
	 

}
