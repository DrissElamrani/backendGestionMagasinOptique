package com.Optique.gestionMagasinOptique.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Optique.gestionMagasinOptique.model.User;;


@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	 public User findById(int id);
	
	 @org.springframework.data.jpa.repository.Query("SELECT * FROM User u WHERE u.login=:login and u.motdepasse=:pass")
	 public User getUserByloginPass(@Param("login") String login,@Param("pass") String pass);
	 
//	 @Query("FROM User u WHERE u.login=:login and u.motdepasse=:pass")
//	 boolean getUserByloginPass(@Param("login") String login,@Param("pass") String pass);

}
