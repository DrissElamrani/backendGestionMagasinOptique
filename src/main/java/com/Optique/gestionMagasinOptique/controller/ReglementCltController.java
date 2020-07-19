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

import com.Optique.gestionMagasinOptique.dao.ReglementCltDao;
import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.Lentille;
import com.Optique.gestionMagasinOptique.model.ReglementClt;
//import com.Optique.gestionMagasinOptique.model.UserJournals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pcuser9
 *
 */

@RestController
@RequestMapping("/optique")
@CrossOrigin
public class ReglementCltController {

	/**
	 * Client
	 * 
	 */
	@Autowired
	private ReglementCltDao reglementCltDao;


	public ReglementCltDao getReglementCltDao() {
		return reglementCltDao;
	}
	public void setReglementCltDao(ReglementCltDao reglementCltDao) {
		this.reglementCltDao = reglementCltDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List reglementClt
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@GetMapping(value = "/reglementClt/list")
	public List<ReglementClt> listReglementCltAll() {
		List<ReglementClt> listreglementclt = reglementCltDao.listReglementClt();
		return listreglementclt;
	}
	
//	// get List reglementClt by Client
//	@GetMapping(value = "/reglementClt/list/{idClt}")
//	public List<ReglementClt> listReglementCltByClt(@PathVariable int idClt) {
//		List<ReglementClt> listreglementclt = reglementCltDao.findAllReglementCltByCmndClt(idClt);
//		return listreglementclt;
//	}

	// get reglementClt by id
	@GetMapping(value = "/reglementClt/{id}")
	public ResponseEntity<ReglementClt> afficherUnReglementClt(@PathVariable int id) {
		ReglementClt rglclt = reglementCltDao.findById(id);
		if (rglclt == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(rglclt);
	}
	// ajouter un reglementClt
	@PostMapping(value = "/reglementClt/create")
	public ResponseEntity<Void> ajouterReglementClient(@RequestBody ReglementClt reglementclt) {
		reglementclt.setStatus("1");
		ReglementClt reglclt = reglementCltDao.save(reglementclt);
		if (reglclt == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reglclt.getIdReglmClt())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un reglementClt By id
	@PutMapping("/reglementClt/{id}/update")
	ResponseEntity<ReglementClt> updatereglementClient(@RequestBody ReglementClt newReglementClt,@PathVariable Integer id) {
		Optional<Object> comndClt = reglementCltDao.findById(id).map(reglementClt -> {
			reglementClt.setMontantRest(newReglementClt.getMontantRest());
			reglementClt.setMontantTotal(newReglementClt.getMontantTotal());
			ReglementClt comndClt1 = reglementCltDao.save(reglementClt);

			return ResponseEntity.ok(comndClt1);
		});
		if (!comndClt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un reglementClt By id
//	@DeleteMapping("/reglementClt/{id}/delete")
//	ResponseEntity<Void> deletereglementClient(@PathVariable Integer id) {
//		Optional<ReglementClt> findreglementCltbyid = reglementCltDao.findById(id);
//		if (findreglementCltbyid.isPresent()) {
//			reglementCltDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
////supprimerS un reglementClt By id
    @DeleteMapping("/reglementClt/{id}/delete")
	ResponseEntity<Void> deleteLentilles(@PathVariable Integer id) {
		Optional<Object> regl = reglementCltDao.findById(id).map(reglementclt -> {
			reglementclt.setStatus("0");
			ReglementClt reglementclt1 = reglementCltDao.save(reglementclt);

			return ResponseEntity.ok(reglementclt1);
		});
		if (!regl.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}