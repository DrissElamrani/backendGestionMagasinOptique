/**
 * 
 */
package com.Optique.gestionMagasinOptique.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Optique.gestionMagasinOptique.dao.JournalUserDao;
import com.Optique.gestionMagasinOptique.model.User;
import com.Optique.gestionMagasinOptique.model.UserJournals;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class JournalUserController {

	@Autowired
	private JournalUserDao journalUserDao;


	public JournalUserDao getJournalUserDao() {
		return journalUserDao;
	}

	public void setJournalUserDao(JournalUserDao journalUserDao) {
		this.journalUserDao = journalUserDao;
	}
	
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}

	// tous Journals
	@GetMapping(value = "/JournalsUser")
	public List<UserJournals> listJournal() {
		return journalUserDao.findAll();
	}
	
	// tous les journals d'un User
	@GetMapping(value ="/JournalsUser/{idUser}")
	public List<UserJournals> listJournalbyIdUser(@PathVariable int idUser) {
		return journalUserDao.findAllJournalbyidUser(idUser);
	}
	
	//ajouter un Journal
	@PostMapping(value = "/JournalsUser/{idUser}")
	public ResponseEntity<Void> ajouterjournal(@RequestBody UserJournals newjournal,@PathVariable int idUser) {
		User user = new User(idUser);
//		user.setIdUser(1);
		newjournal.setUser(user);
		newjournal.setDateAction(getDateNow());
		UserJournals journal = journalUserDao.save(newjournal);
		if (journal == null)
			ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(journal.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

//	// Users/{id}
//	@GetMapping(value = "JournalsUser/{id}")
//	public ResponseEntity<UserJournals> afficherjournalByidUser(@PathVariable int id) {
//		UserJournals journal = journalUserDao.findById(id);
//		if (journal == null)
//			return ResponseEntity.noContent().build();
//		return ResponseEntity.ok(journal);
//	}

	// @GetMapping(value = "Users/{id}/Nom")
	// public String getNomById(@PathVariable int id) throws
	// ClientIntrouvableException {
	// String Nom = clientDao.getNomById(id);
	// if (Nom == null)
	// throw new ClientIntrouvableException("Le produit avec l'id " + id + "
	// n'existe pas");
	//
	// return Nom;
	// }



//	@PutMapping("/Users/{id}")
//	ResponseEntity<UserJournals> updateEmployee(@RequestBody UserJournals newUser, @PathVariable Integer id) {
//		Optional<Object> use = journalUserDao.findById(id).map(user -> {
//			user.setNom(newUser.getNom());
//			user.setPrenom(newUser.getPrenom());
//			user.setEmail(newUser.getEmail());
//			user.setLogin(newUser.getLogin());
//			user.setMotdepasse(newUser.getMotdepasse());
//			user.setTel(newUser.getTel());
//			user.setAddresse(newUser.getAddresse());
//			User us = journalUserDao.save(user);
//			return ResponseEntity.ok(us);
//		});
//		if (!use.isPresent())
//			return ResponseEntity.noContent().build();
//
//		return ResponseEntity.ok().build();
//	}

//	@DeleteMapping("/Users/{id}")
//	ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
//		Optional<UserJournals> findUserbyid = journalUserDao.findById(id);
//		if (findUserbyid.isPresent()) {
//			journalUserDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
}