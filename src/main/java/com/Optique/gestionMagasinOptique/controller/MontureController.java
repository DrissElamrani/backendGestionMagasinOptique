/**
 * 
 */
package com.Optique.gestionMagasinOptique.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Date;
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

import com.Optique.gestionMagasinOptique.dao.MontureDao;
import com.Optique.gestionMagasinOptique.dao.JournalUserDao;
import com.Optique.gestionMagasinOptique.model.LunetteSolaire;
import com.Optique.gestionMagasinOptique.model.Monture;
//import com.Optique.gestionMagasinOptique.model.UserJournals;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class MontureController {

	/**
	 * monture
	 * 
	 */
	@Autowired
	private MontureDao montureDao;

	public MontureDao getmontureDao() {
		return montureDao;
	}
	public void setmontureDao(MontureDao montureDao) {
		this.montureDao = montureDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List montures
	@GetMapping(value = "/montures/list")
	public List<Monture> listmontures() {
		List<Monture> listmonture = montureDao.listMonture();
		return listmonture;
	}

	// get monture by id
	@GetMapping(value = "/montures/{id}")
	public ResponseEntity<Monture> afficherUnmonture(@PathVariable int id) {
		Monture monture = montureDao.findById(id);
		if (monture == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(monture);
	}
	// ajouter un montures
	@PostMapping(value = "/montures/create")
	public ResponseEntity<Void> ajoutermonture(@RequestBody Monture monture) {
		monture.setDateCreation(getDateNow());
		monture.setStatus("1");
		Monture mon = montureDao.save(monture);
		if (mon == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mon.getIdProd())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un monture By id
	@PutMapping("/montures/{id}/update")
	ResponseEntity<Monture> updatemonture(@RequestBody Monture newmonture, @PathVariable Integer id) {
		Optional<Object> montr = montureDao.findById(id).map(monture -> {
			monture.setType(newmonture.getType());
			monture.setQteProd(newmonture.getQteProd());
			monture.setPrixUnitaire(newmonture.getPrixUnitaire());
			monture.setNomProd(newmonture.getNomProd());
			monture.setCategorie(newmonture.getCategorie());
			monture.setDateModification(getDateNow());
			Monture mont = montureDao.save(monture);

			return ResponseEntity.ok(mont);
		});
		if (!montr.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un monture By id
//	@DeleteMapping("/montures/{id}/delete")
//	ResponseEntity<Void> deletemonture(@PathVariable Integer id) {
//		Optional<Monture> findmonturebyid = montureDao.findById(id);
//		if (findmonturebyid.isPresent()) {
//			montureDao.deleteById(id);
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
////supprimerS un monture By id
   @DeleteMapping("/montures/{id}/delete")
	ResponseEntity<Void> supprimerMonture (@PathVariable Integer id) {
		Optional<Object> mon = montureDao.findById(id).map(monture -> {
			monture.setStatus("0");
			Monture monture1 = montureDao.save(monture);

			return ResponseEntity.ok(monture1);
		});
		if (!mon.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}