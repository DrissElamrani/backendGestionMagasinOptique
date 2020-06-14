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

import com.Optique.gestionMagasinOptique.dao.ProduitDao;
import com.Optique.gestionMagasinOptique.dao.JournalUserDao;
import com.Optique.gestionMagasinOptique.model.Produit;
//import com.Optique.gestionMagasinOptique.model.UserJournals;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class ProduitController {

	/**
	 * Produit
	 * 
	 */
	@Autowired
	private ProduitDao produitDao;

	public ProduitDao getProduitDao() {
		return produitDao;
	}
	public void setProduitDao(ProduitDao ProduitDao) {
		this.produitDao = ProduitDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
//	// get List Produits
//	@GetMapping(value = "/produits/list")
//	public List<Produit> listProduits() {
//		List<Produit> listProduit = produitDao.findAll();
//		return listProduit;
//	}
//
//	// get Produit by id
//	@GetMapping(value = "/Produits/{id}")
//	public ResponseEntity<Produit> afficherUnProduit(@PathVariable int id) {
//		Produit prod = produitDao.findById(id);
//		if (prod == null)
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok(prod);
//	}
//
////	@GetMapping(value = "/Produits/{id}/Nom")
////	public String getNomById(@PathVariable int id) throws ProduitIntrouvableException {
////		String Nom = ProduitDao.getNomById(id);
////		if (Nom == null)
////			throw new ProduitIntrouvableException("Le produit avec l'id " + id + "  n'existe pas");
////
////		return Nom;
////	}
//
//	// ajouter un Produits
//	@PostMapping(value = "/produits/create")
//	public ResponseEntity<Void> ajouterProduit(@RequestBody Produit produit) {
//		produit.setDateCreation(getDateNow());
//		Produit prod = produitDao.save(produit);
//		if (prod == null)
//			return ResponseEntity.noContent().build();
//		else {
//			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getIdProd())
//					.toUri();
//			return ResponseEntity.created(location).build();
//		}
//	}
////	modifier un Produit By id
//	@PutMapping("/produits/{id}/update")
//	ResponseEntity<Produit> updateEmployee(@RequestBody Produit newProduit, @PathVariable Integer id) {
//		Optional<Object> prod = produitDao.findById(id).map(produit -> {
//			produit.setNomProd(newProduit.getNomProd());
//			produit.setDateCreation(getDateNow());
//			produit.setPrixUnitaire(newProduit.getPrixUnitaire());
//			produit.setQteProd(newProduit.getQteProd());
//			produit.setDateModification(getDateNow());
//			Produit prodd = produitDao.save(produit);
//
//			return ResponseEntity.ok(prodd);
//		});
//		if (!prod.isPresent())
//			return ResponseEntity.noContent().build();
//
//		return ResponseEntity.ok().build();
//	}
////	supprimerS un Produit By id
//	@DeleteMapping("/produits/{id}/delete")
//	ResponseEntity<Void> deleteProduit(@PathVariable Integer id) {
//		Optional<Produit> findProduitbyid = produitDao.findById(id);
//		if (findProduitbyid.isPresent()) {
//			produitDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
}