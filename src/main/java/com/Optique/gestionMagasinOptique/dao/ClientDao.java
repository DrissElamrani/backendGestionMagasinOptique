package com.Optique.gestionMagasinOptique.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Client;
@Repository
public interface ClientDao extends JpaRepository<Client, Integer>{
	
//	public List <Client> findall();
	 public Client findById(int id);
	 
	 @org.springframework.data.jpa.repository.Query("SELECT nom FROM Client c WHERE c.idClt=:id")
	 public String getNomById(@Param("id") int id);

	 
//	 @Transactional
//	 @Modifying
//	 @org.springframework.data.jpa.repository.Query("DELETE FROM Client c WHERE c.idClt=:id")
//	 public Integer remove(@Param("id") int id);
//	 
	 

}
