/**
 * 
 */
package com.Optique.gestionMagasinOptique.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Optique.gestionMagasinOptique.dao.UserDao;
import com.Optique.gestionMagasinOptique.model.Monture;
import com.Optique.gestionMagasinOptique.model.User;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class UserController {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// Users
	@GetMapping(value = "/Users/list")
	public List<User> listUser() {
		return userDao.listUser();
	}

	// Users/{id}
	@GetMapping(value = "/Users/{id}")
	public ResponseEntity<User> afficherUnUsers(@PathVariable int id) {
		User user = userDao.findById(id);
		if (user == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value="/user/auth")
	public ResponseEntity<User> auth(@RequestBody User user) {
		
		User authUser = userDao.getUserByloginPass(user.getLogin(), user.getMotdepasse());
		if (authUser==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(authUser);
	}

	// ajouter un User
	@PostMapping(value = "/Users")
	public ResponseEntity<Void> ajouterUser(@RequestBody User user) {
		user.setMotdepasse("1");
		user.setStatus("1");
		User newuser = userDao.save(user);
		if (newuser == null)
			ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUser())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/Users/{id}")
	ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Integer id) {
		Optional<Object> use = userDao.findById(id).map(user -> {
			user.setNom(newUser.getNom());
			user.setPrenom(newUser.getPrenom());
			user.setEmail(newUser.getEmail());
			user.setLogin(newUser.getLogin());
			user.setMotdepasse(newUser.getMotdepasse());
			user.setTel(newUser.getTel());
			user.setAddresse(newUser.getAddresse());
			User us = userDao.save(user);
			return ResponseEntity.ok(us);
		});
		if (!use.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
	//réinitialisée mot de passe
	@PutMapping("/Users/{id}/update/pwd")
	ResponseEntity<User> reinitialise(@PathVariable Integer id) {
		Optional<Object> use = userDao.findById(id).map(user -> {
			user.setMotdepasse("1");
			User us = userDao.save(user);
			return ResponseEntity.ok(us);
		});
		if (!use.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}

//	@DeleteMapping("/Users/{id}")
//	ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
//		Optional<User> findUserbyid = userDao.findById(id);
//		if (findUserbyid.isPresent()) {
//			userDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
////supprimerS un user By id
	@DeleteMapping("/Users/{id}")
	ResponseEntity<Void> supprimerUser (@PathVariable Integer id) {
		Optional<Object> us = userDao.findById(id).map(user -> {
			user.setStatus("0");
			User user1 = userDao.save(user);

			return ResponseEntity.ok(user1);
		});
		if (!us.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}