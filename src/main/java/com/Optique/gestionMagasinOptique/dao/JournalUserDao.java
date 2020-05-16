package com.Optique.gestionMagasinOptique.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Optique.gestionMagasinOptique.model.UserJournals;;


@Repository
public interface JournalUserDao extends JpaRepository<UserJournals, Integer>{

	public UserJournals findById(int id);           
	
	@org.springframework.data.jpa.repository.Query("SELECT j FROM UserJournals j join FETCH j.user WHERE j.user.idUser=:idUser")
	public List<UserJournals> findAllJournalbyidUser(@Param("idUser")int idUser);
}
