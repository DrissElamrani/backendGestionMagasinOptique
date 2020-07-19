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
import com.Optique.gestionMagasinOptique.dao.FournisseurDao;
import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Fournisseur;
import com.Optique.gestionMagasinOptique.model.LigneReglmClt;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class FournisseurController {

	/**
	 * fournisseur
	 * 
	 */
	@Autowired
	private FournisseurDao fournisseurDao;

	public FournisseurDao getfournisseurDao() {
		return fournisseurDao;
	}
	public void setfournisseurDao(FournisseurDao fournisseurDao) {
		this.fournisseurDao = fournisseurDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// fournisseurs
	@GetMapping(value = "/fournisseurs/list")
	public List<Fournisseur> listfournisseurs() {
		List<Fournisseur> listfournisseur = fournisseurDao.listFournisseur();
		return listfournisseur;
	}

	// fournisseur/{id}
	@GetMapping(value = "/fournisseurs/{id}")
	public ResponseEntity<Fournisseur> afficherUnfournisseur(@PathVariable int id) {
		Fournisseur Fourn = fournisseurDao.findById(id);
		if (Fourn == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(Fourn);
	}


	// ajouter un fournisseurs
	@PostMapping(value = "/fournisseurs/create")
	public ResponseEntity<Void> ajouterFournisseur(@RequestBody Fournisseur fournisseur) {
		fournisseur.setDateCreation(getDateNow());
		fournisseur.setStatus("1");
		Fournisseur fourn = fournisseurDao.save(fournisseur);
		if (fourn == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fourn.getIdFourn())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}

//	modifier un fournisseur By id
	@PutMapping("/fournisseurs/{id}/update")
	ResponseEntity<Fournisseur> updateEmployee(@RequestBody Fournisseur newfournisseur, @PathVariable Integer id) {
		Optional<Object> fourn = fournisseurDao.findById(id).map(fournisseur -> {
			fournisseur.setNom(newfournisseur.getNom());
			fournisseur.setDateModification(getDateNow());
			fournisseur.setEmail(newfournisseur.getEmail());
			fournisseur.setIce(newfournisseur.getIce());
			fournisseur.setFax(newfournisseur.getFax());
			fournisseur.setTel1(newfournisseur.getTel1());
			fournisseur.setTel2(newfournisseur.getTel2());
			fournisseur.setTel3(newfournisseur.getTel3());
			fournisseur.setAddresse(newfournisseur.getAddresse());
			Fournisseur four = fournisseurDao.save(fournisseur);

			return ResponseEntity.ok(four);
		});
		if (!fourn.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	Supprimer un fournisseur By id
//	@DeleteMapping("/fournisseurs/{id}/delete")
//	ResponseEntity<Void> deletefournisseur(@PathVariable Integer id) {
//		Optional<Fournisseur> findfournisseurbyid = fournisseurDao.findById(id);
//		if (findfournisseurbyid.isPresent()) {
//			fournisseurDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
//	supprimerS un fournisseur By id
	@DeleteMapping("/fournisseurs/{id}/delete")
	ResponseEntity<Void> deleteFournisseurs(@PathVariable Integer id) {
		Optional<Object> four = fournisseurDao.findById(id).map(fournisseur -> {
			fournisseur.setStatus("0");
			Fournisseur clt1 = fournisseurDao.save(fournisseur);

			return ResponseEntity.ok(clt1);
		});
		if (!four.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}