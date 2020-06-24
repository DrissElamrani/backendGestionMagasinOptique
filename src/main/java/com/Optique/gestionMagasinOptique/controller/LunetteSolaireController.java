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
import com.Optique.gestionMagasinOptique.dao.LunetteSolaireDao;
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
public class LunetteSolaireController {

	/**
	 * lunetteSolaire
	 * 
	 */
	@Autowired
	private LunetteSolaireDao lunettesolairedao;

	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List LunetteSolaire
	@GetMapping(value = "/lunettesolaires/list")
	public List<LunetteSolaire> listlunettesolaire() {
		List<LunetteSolaire> listlunettesolaire = lunettesolairedao.findAll();
		return listlunettesolaire;
	}

	// get LunetteSolaire by id
	@GetMapping(value = "/lunettesolaires/{id}")
	public ResponseEntity<LunetteSolaire> afficherUnLunettesolaire(@PathVariable int id) {
		LunetteSolaire lunettesolaire = lunettesolairedao.findById(id);
		if (lunettesolaire == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(lunettesolaire);
	}
	// ajouter un LunetteSolaire
	@PostMapping(value = "/lunettesolaires/create")
	public ResponseEntity<Void> ajouterLunetteSolaire(@RequestBody LunetteSolaire lunettesolaire) {
		lunettesolaire.setDateCreation(getDateNow());
		LunetteSolaire lunettesol = lunettesolairedao.save(lunettesolaire);
		if (lunettesol == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lunettesol.getIdProd())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un monture By id
	@PutMapping("/lunettesolaires/{id}/update")
	ResponseEntity<LunetteSolaire> updateLunetteSolaire(@RequestBody LunetteSolaire newLunetteSolaire, @PathVariable Integer id) {
		Optional<Object> LunettSol = lunettesolairedao.findById(id).map(lunettesolaire -> {
			lunettesolaire.setType(newLunetteSolaire.getType());
			lunettesolaire.setQteProd(newLunetteSolaire.getQteProd());
			lunettesolaire.setPrixUnitaire(newLunetteSolaire.getPrixUnitaire());
			lunettesolaire.setNomProd(newLunetteSolaire.getNomProd());
			lunettesolaire.setCategorie(newLunetteSolaire.getCategorie());
			lunettesolaire.setDateModification(getDateNow());
			LunetteSolaire lunetsolaire = lunettesolairedao.save(lunettesolaire);

			return ResponseEntity.ok(lunetsolaire);
		});
		if (!LunettSol.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
//	supprimerS un LunetteSolaire By id
	@DeleteMapping("/lunettesolaires/{id}/delete")
	ResponseEntity<Void> deleteLunetteSolaire(@PathVariable Integer id) {
		Optional<LunetteSolaire> findlunettesolairesbyid = lunettesolairedao.findById(id);
		if (findlunettesolairesbyid.isPresent()) {
			lunettesolairedao.deleteById(id);
		}

		return ResponseEntity.noContent().build();
	}
}