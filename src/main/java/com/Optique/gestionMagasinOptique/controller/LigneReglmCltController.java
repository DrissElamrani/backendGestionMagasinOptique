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
import com.Optique.gestionMagasinOptique.dao.LigneReglmCltDao;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
import com.Optique.gestionMagasinOptique.model.LigneReglmClt;
import com.Optique.gestionMagasinOptique.model.ReglementClt;



/**
 * @author pcuser9
 *
 */

@RestController
@RequestMapping("/optique")
@CrossOrigin
public class LigneReglmCltController {

	/**
	 * Client
	 * 
	 */
	@Autowired
	private LigneReglmCltDao LigneReglmCltdao;

	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List LigneReglmClt
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@GetMapping(value = "/ligneReglmClt/list")
	public List<LigneReglmClt> listLigneReglmCltAll() {
		List<LigneReglmClt> listlignecmndclt = LigneReglmCltdao.findAll();
		return listlignecmndclt;
	}
	
//	// get List commandeClt by Client
//	@GetMapping(value = "/LigneReglmClt/list/{idCmndClt}")
//	public List<LigneReglmClt> listCommandeCltByClt(@PathVariable int idCmndClt) {
//		List<LigneReglmClt> listcommandeclt = LigneReglmCltdao.findAllLigneReglmCltByIdCmnd(idCmndClt);
//		return listcommandeclt;
//	}

	// get commandeClt by id
	@GetMapping(value = "/ligneReglmClt/{id}")
	public ResponseEntity<LigneReglmClt> afficherunLigneReglmCltbyId(@PathVariable int id) {
		LigneReglmClt lignecmndclt = LigneReglmCltdao.findById(id);
		if (lignecmndclt == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(lignecmndclt);
	}
	// ajouter un LigneReglmClt
	@PostMapping(value = "/ligneReglmClt/create/{idCmndClt}/{idReglmClt}")
	public ResponseEntity<Void> ajouterLigneReglmClt(@RequestBody LigneReglmClt lignecmndclt, @PathVariable int idCmndClt,@PathVariable int idReglmClt) {
	    ReglementClt reglementclt = new ReglementClt();
	    reglementclt.setIdReglmClt(idReglmClt);
		CommandeClt commandeclt =new CommandeClt();
		commandeclt.setIdCmdeeClt(idCmndClt);
		lignecmndclt.setCommandeClt(commandeclt);
		lignecmndclt.setReglementCltB(reglementclt);
		lignecmndclt.setDateCreation(getDateNow());
		lignecmndclt.setStatus("1");
		LigneReglmClt reglmClt = LigneReglmCltdao.save(lignecmndclt);
		if (reglmClt == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reglmClt.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un LigneReglmClt By id
	@PutMapping("/ligneReglmClt/{id}/update/{idCmndClt}/{idReglmClt}")
	ResponseEntity<LigneReglmClt> updateLigneReglmClt(@RequestBody LigneReglmClt newlignereglmclt ,@PathVariable Integer id,@PathVariable int idCmndClt,@PathVariable int idReglmClt) {
	    ReglementClt reglementclt = new ReglementClt();
	    reglementclt.setIdReglmClt(idReglmClt);
		CommandeClt commandeClt =new CommandeClt();
		commandeClt.setIdCmdeeClt(idCmndClt);
		Optional<Object> comndClt = LigneReglmCltdao.findById(id).map(lignecmndClt -> {
			lignecmndClt.setReglementCltB(reglementclt);
			lignecmndClt.setCommandeClt(commandeClt);
			lignecmndClt.setMontant(newlignereglmclt.getMontant());
			LigneReglmClt lignecomndClt = LigneReglmCltdao.save(lignecmndClt);

			return ResponseEntity.ok(lignecomndClt);
		});
		if (!comndClt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un LigneReglmClt By id
//	@DeleteMapping("/ligneReglmClt/{id}/delete")
//	ResponseEntity<Void> deleteLigneReglmClt(@PathVariable Integer id) {
//		Optional<LigneReglmClt> findcommandeCltbyid = LigneReglmCltdao.findById(id);
//		if (findcommandeCltbyid.isPresent()) {
//			LigneReglmCltdao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
//	supprimerS un LigneReglmClt By id
	@DeleteMapping("/ligneReglmClt/{id}/delete")
	ResponseEntity<Void> updateLigneReglmClt(@PathVariable Integer id) {
		Optional<Object> comndClt = LigneReglmCltdao.findById(id).map(lignecmndClt -> {
			lignecmndClt.setStatus("0");
			LigneReglmClt lignecomndClt = LigneReglmCltdao.save(lignecmndClt);

			return ResponseEntity.ok(lignecomndClt);
		});
		if (!comndClt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}