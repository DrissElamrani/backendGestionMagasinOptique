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
import com.Optique.gestionMagasinOptique.dao.VerreDao;
import com.Optique.gestionMagasinOptique.dao.JournalUserDao;
import com.Optique.gestionMagasinOptique.model.Monture;
import com.Optique.gestionMagasinOptique.model.Verre;
//import com.Optique.gestionMagasinOptique.model.UserJournals;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class VerreController {

	/**
	 * monture
	 * 
	 */
	@Autowired
	private VerreDao verredao;

	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List montures
	@GetMapping(value = "/verres/list")
	public List<Verre> listverres() {
		List<Verre> listverre = verredao.findAll();
		return listverre;
	}

	// get verre by id
	@GetMapping(value = "/verres/{id}")
	public ResponseEntity<Verre> afficherUnVerre(@PathVariable int id) {
		Verre verre = verredao.findById(id);
		if (verre == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(verre);
	}
	// ajouter un verre
	@PostMapping(value = "/verres/create")
	public ResponseEntity<Void> ajouterVerre(@RequestBody Verre verre) {
		verre.setDateCreation(getDateNow());
		Verre ver = verredao.save(verre);
		if (ver == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ver.getIdProd())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un verre By id
	@PutMapping("/verres/{id}/update")
	ResponseEntity<Verre> updateVerre(@RequestBody Verre newVerre, @PathVariable Integer id) {
		Optional<Object> ve = verredao.findById(id).map(verre -> {
			verre.setAddV(newVerre.getAddV());
			verre.setAxe(newVerre.getAxe());
			verre.setCyl(newVerre.getCyl());
			verre.setOeilGaucheDroit(newVerre.getOeilGaucheDroit());
			verre.setSph(newVerre.getSph());
			verre.setVisionLoin(newVerre.getVisionLoin());
			verre.setVisionPres(newVerre.getVisionPres());
			verre.setQteProd(newVerre.getQteProd());
			verre.setPrixUnitaire(newVerre.getPrixUnitaire());
			verre.setNomProd(newVerre.getNomProd());
			verre.setNature(newVerre.getNature());
			verre.setDateModification(getDateNow());
			Verre verr = verredao.save(verre);

			return ResponseEntity.ok(verr);
		});
		if (!ve.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
//	supprimerS un verre By id
	@DeleteMapping("/verres/{id}/delete")
	ResponseEntity<Void> deleteverres(@PathVariable Integer id) {
		Optional<Verre> findVerrebyid = verredao.findById(id);
		if (findVerrebyid.isPresent()) {
			verredao.deleteById(id);
		}

		return ResponseEntity.noContent().build();
	}
}