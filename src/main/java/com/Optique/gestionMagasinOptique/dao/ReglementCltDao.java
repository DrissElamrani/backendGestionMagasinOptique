package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
import com.Optique.gestionMagasinOptique.model.Monture;
import com.Optique.gestionMagasinOptique.model.ReglementClt;
import com.Optique.gestionMagasinOptique.model.UserJournals;
@Repository
public interface ReglementCltDao extends JpaRepository<ReglementClt, Integer> {
	
	 public ReglementClt findById(int id);
	 
//		@org.springframework.data.jpa.repository.Query("SELECT c FROM ReglementClt c join FETCH c.client WHERE c.client.idClt=:idClt")
//		public List<ReglementClt> findAllReglementCltByCmndClt(@Param("idClt") int idClt);
	 
	 @org.springframework.data.jpa.repository.Query("select r FROM ReglementClt r WHERE r.status='1'")
	 public List<ReglementClt> listReglementClt();
		
}
