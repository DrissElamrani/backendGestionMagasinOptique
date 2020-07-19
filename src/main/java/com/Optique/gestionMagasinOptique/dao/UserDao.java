package com.Optique.gestionMagasinOptique.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Optique.gestionMagasinOptique.model.Monture;
import com.Optique.gestionMagasinOptique.model.User;;


@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	 public User findById(int id);
	
	 @org.springframework.data.jpa.repository.Query("SELECT u FROM User u WHERE u.login=:login and u.motdepasse=:pass and u.status='1'")
	 public User getUserByloginPass(@Param("login") String login,@Param("pass") String pass);
	 
	 @org.springframework.data.jpa.repository.Query("select u FROM User u WHERE u.status='1'")
	 public List<User> listUser();

}
