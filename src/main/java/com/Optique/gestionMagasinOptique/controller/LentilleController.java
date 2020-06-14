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

import com.Optique.gestionMagasinOptique.dao.LentilleDao;
import com.Optique.gestionMagasinOptique.model.Lentille;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class LentilleController {

	/**
	 * monture
	 * 
	 */
	@Autowired
	private LentilleDao lentillesDao;
	
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List montures
	@GetMapping(value = "/lentilles/list")
	public List<Lentille> listlentilles() {
		List<Lentille> listlentilles = lentillesDao.findAll();
		return listlentilles;
	}

	// get monture by id
	@GetMapping(value = "/lentilles/{id}")
	public ResponseEntity<Lentille> afficherUnLentille(@PathVariable int id) {
		Lentille lentille = lentillesDao.findById(id);
		if (lentille == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(lentille);
	}
	// ajouter un Lentille
	@PostMapping(value = "/lentilles/create")
	public ResponseEntity<Void> ajouterlentille(@RequestBody Lentille lentille) {
		lentille.setDateCreation(getDateNow());
		Lentille len = lentillesDao.save(lentille);
		if (len == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(len.getIdProd())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un Lentille By id
	@PutMapping("/lentilles/{id}/update")
	ResponseEntity<Lentille> updateLentille(@RequestBody Lentille newLentille, @PathVariable Integer id) {
		Optional<Object> lent = lentillesDao.findById(id).map(lentille -> {
			lentille.setType(newLentille.getType());
			lentille.setQteProd(newLentille.getQteProd());
			lentille.setPrixUnitaire(newLentille.getPrixUnitaire());
			lentille.setNomProd(newLentille.getNomProd());
			lentille.setCyl(newLentille.getCyl());
			lentille.setAxe(newLentille.getAxe());
			lentille.setDateModification(getDateNow());
			lentille.setNature(newLentille.getNature());
			lentille.setOeilGaucheDroit(newLentille.getOeilGaucheDroit());
			lentille.setRc(newLentille.getRc());
			lentille.setSph(newLentille.getSph());
			
			Lentille len = lentillesDao.save(lentille);

			return ResponseEntity.ok(len);
		});
		if (!lent.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
//	supprimerS un monture By id
	@DeleteMapping("/lentilles/{id}/delete")
	ResponseEntity<Void> deletelentilles(@PathVariable Integer id) {
		Optional<Lentille> findmonturebyid = lentillesDao.findById(id);
		if (findmonturebyid.isPresent()) {
			lentillesDao.deleteById(id);
		}

		return ResponseEntity.noContent().build();
	}
}