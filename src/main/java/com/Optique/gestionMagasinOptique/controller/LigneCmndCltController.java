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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Optique.gestionMagasinOptique.dao.CommandeCltDao;
import com.Optique.gestionMagasinOptique.dao.LigneCmndCltDao;
import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
import com.Optique.gestionMagasinOptique.model.LigneCmndClt;
import com.Optique.gestionMagasinOptique.model.Produit;
//import com.Optique.gestionMagasinOptique.model.UserJournals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pcuser9
 *
 */

@RestController
@RequestMapping("/optique")
@CrossOrigin
public class LigneCmndCltController {

	/**
	 * Client
	 * 
	 */
	@Autowired
	private LigneCmndCltDao LigneCmndCltdao;

	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List ligneCmndClt
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@GetMapping(value = "/ligneCmndClt/list")
	public List<LigneCmndClt> listligneCmndCltAll() {
		List<LigneCmndClt> listlignecmndclt = LigneCmndCltdao.listLigneCmndClt();
		return listlignecmndclt;
	}
	
	// get List commandeClt by Client
	@GetMapping(value = "/ligneCmndClt/list/{idCmndClt}")
	public List<LigneCmndClt> listCommandeCltByClt(@PathVariable int idCmndClt) {
		List<LigneCmndClt> listcommandeclt = LigneCmndCltdao.findAllLigneCmndCltByIdCmnd(idCmndClt);
		return listcommandeclt;
	}

	// get commandeClt by id
	@GetMapping(value = "/ligneCmndClt/{id}")
	public ResponseEntity<LigneCmndClt> afficherunligneCmndCltbyId(@PathVariable int id) {
		LigneCmndClt lignecmndclt = LigneCmndCltdao.findById(id);
		if (lignecmndclt == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(lignecmndclt);
	}
	// ajouter un ligneCmndClt
	@PostMapping(value = "/ligneCmndClt/create/{idCmndClt}/{idProd}")
	public ResponseEntity<Void> ajouterligneCmndClt(@RequestBody LigneCmndClt lignecmndclt, @PathVariable int idCmndClt,@PathVariable int idProd) {
		Produit prod = new Produit();
		prod.setIdProd(idProd);		
		CommandeClt commandeclt =new CommandeClt();
		commandeclt.setIdCmdeeClt(idCmndClt);
		lignecmndclt.setCommandeClt(commandeclt);
		lignecmndclt.setProduitB(prod);
		lignecmndclt.setStatus("1");
		LigneCmndClt comndlt = LigneCmndCltdao.save(lignecmndclt);
		if (comndlt == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comndlt.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un ligneCmndClt By id
	@PutMapping("/ligneCmndClt/{id}/update/{idCmndClt}/{idProd}")
	ResponseEntity<LigneCmndClt> updateligneCmndClt(@RequestBody LigneCmndClt newlignecmndclt ,@PathVariable Integer id,@PathVariable int idCmndClt,@PathVariable int idProd) {
		Produit prod = new Produit();
		prod.setIdProd(idProd);
		CommandeClt commandeClt =new CommandeClt();
		commandeClt.setIdCmdeeClt(idCmndClt);
		Optional<Object> comndClt = LigneCmndCltdao.findById(id).map(lignecmndClt -> {
			lignecmndClt.setProduitB(prod);
			lignecmndClt.setCommandeClt(commandeClt);
			lignecmndClt.setPrixUnitaire(newlignecmndclt.getPrixUnitaire());
			lignecmndClt.setQteCmdee(newlignecmndclt.getQteCmdee());
			LigneCmndClt lignecomndClt = LigneCmndCltdao.save(lignecmndClt);

			return ResponseEntity.ok(lignecomndClt);
		});
		if (!comndClt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un ligneCmndClt By id
//	@DeleteMapping("/ligneCmndClt/{id}/delete")
//	ResponseEntity<Void> deleteligneCmndClt(@PathVariable Integer id) {
//		Optional<LigneCmndClt> findcommandeCltbyid = LigneCmndCltdao.findById(id);
//		if (findcommandeCltbyid.isPresent()) {
//			LigneCmndCltdao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
	@DeleteMapping("/ligneCmndClt/{id}/delete")
	ResponseEntity<Void> deleteligneCmndClt(@PathVariable Integer id) {
		Optional<Object> ligcomndclt = LigneCmndCltdao.findById(id).map(lignecomndclt -> {
			lignecomndclt.setStatus("0");
			LigneCmndClt cmndClt = LigneCmndCltdao.save(lignecomndclt);

			return ResponseEntity.ok(cmndClt);
		});
		if (!ligcomndclt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}