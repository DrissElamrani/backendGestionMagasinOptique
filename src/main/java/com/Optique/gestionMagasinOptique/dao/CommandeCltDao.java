package com.Optique.gestionMagasinOptique.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
import com.Optique.gestionMagasinOptique.model.UserJournals;
@Repository
public interface CommandeCltDao extends JpaRepository<CommandeClt, Integer> {
	
	 public CommandeClt findById(int id);
	 
		@org.springframework.data.jpa.repository.Query("SELECT c FROM CommandeClt c join FETCH c.client WHERE c.client.idClt=:idClt and c.status='1'")
		public List<CommandeClt> findAllCommandeCltByClt(@Param("idClt") int idClt);

//	 String req="SELECT nom FROM Client c WHERE TO_DATE('c.dateCreation', 'YYYY/MM/DD') between  TO_DATE("+datedebut+", 'YYYY/MM/DD') and TO_DATE("+datefin+", 'YYYY/MM/DD')";
//     String req="";
//	 
//     @Query(req)
//	 public List<Client> searchClient(@Param("id") int id);

	 
		 @org.springframework.data.jpa.repository.Query("select c FROM CommandeClt c WHERE c.status='1'")
		 public List<CommandeClt> listCommandeClt();
	 

}
