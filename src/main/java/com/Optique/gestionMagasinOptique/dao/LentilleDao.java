package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Lentille;
import com.Optique.gestionMagasinOptique.model.Monture;

@Repository
public interface LentilleDao extends JpaRepository<Lentille, Integer> {
	
	 public Lentille findById(int id);
 
	 @org.springframework.data.jpa.repository.Query("select l FROM Lentille l WHERE l.status='1'")
	 public List<Lentille> listLentille();

}
