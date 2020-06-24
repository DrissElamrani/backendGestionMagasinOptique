package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
import com.Optique.gestionMagasinOptique.model.LigneCmndClt;
import com.Optique.gestionMagasinOptique.model.UserJournals;
@Repository
public interface LigneCmndCltDao extends JpaRepository<LigneCmndClt, Integer> {
	
	 public LigneCmndClt findById(int id);
	 
		@org.springframework.data.jpa.repository.Query("SELECT lc FROM LigneCmndClt lc join FETCH lc.commandeClt WHERE lc.commandeClt.idCmdeeClt=:idCmndClt")
		public List<LigneCmndClt> findAllLigneCmndCltByIdCmnd(@Param("idCmndClt") int idCmndClt);
 
	 

}
