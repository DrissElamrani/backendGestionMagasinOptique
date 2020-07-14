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

import com.Optique.gestionMagasinOptique.dao.CommandeCltDao;
import com.Optique.gestionMagasinOptique.model.Client;
import com.Optique.gestionMagasinOptique.model.CommandeClt;
//import com.Optique.gestionMagasinOptique.model.UserJournals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pcuser9
 *
 */

@RestController
@RequestMapping("/optique")
@CrossOrigin
public class CommandeCltController {

	/**
	 * Client
	 * 
	 */
	@Autowired
	private CommandeCltDao commandeCltDao;


	public CommandeCltDao getCommandeCltDao() {
		return commandeCltDao;
	}
	public void setCommandeCltDao(CommandeCltDao commandeCltDao) {
		this.commandeCltDao = commandeCltDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List commandeClt
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@GetMapping(value = "/commandeClt/list")
	public List<CommandeClt> listCommandeCltAll() {
		List<CommandeClt> listcommandeclt = commandeCltDao.findAll();
		return listcommandeclt;
	}
	
	// get List commandeClt by Client
	@GetMapping(value = "/commandeClt/list/{idClt}")
	public List<CommandeClt> listCommandeCltByClt(@PathVariable int idClt) {
		List<CommandeClt> listcommandeclt = commandeCltDao.findAllCommandeCltByClt(idClt);
		return listcommandeclt;
	}

	// get commandeClt by id
	@GetMapping(value = "/commandeClt/{id}")
	public ResponseEntity<CommandeClt> afficherUnClient(@PathVariable int id) {
		CommandeClt clt = commandeCltDao.findById(id);
		if (clt == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(clt);
	}
	// ajouter un commandeClt
	@PostMapping(value = "/commandeClt/create/{idClt}")
	public ResponseEntity<Void> ajouterProduit(@PathVariable int idClt) {
		Client clt = new Client();
		clt.setIdClt(idClt);
		CommandeClt commandeclt =new CommandeClt();
		commandeclt.setClient(clt);
		commandeclt.setDateCommande(getDateNow());
		commandeclt.setStatus("1");
		CommandeClt comndlt = commandeCltDao.save(commandeclt);
		if (comndlt == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comndlt.getIdCmdeeClt())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un commandeClt By id
	@PutMapping("/commandeClt/{id}/update/{idClt}")
	ResponseEntity<CommandeClt> updateEmployee(@PathVariable Integer id,@PathVariable int idClt) {
		Client clt = new Client();
		clt.setIdClt(idClt);
		CommandeClt newCommandeClt =new CommandeClt();
		newCommandeClt.setClient(clt);
		Optional<Object> comndClt = commandeCltDao.findById(id).map(commandeClt -> {
			commandeClt.setClient(newCommandeClt.getClient());
			CommandeClt comndClt1 = commandeCltDao.save(commandeClt);

			return ResponseEntity.ok(comndClt1);
		});
		if (!comndClt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un commandeClt By id
//	@DeleteMapping("/commandeClt/{id}/delete")
//	ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
//		Optional<CommandeClt> findcommandeCltbyid = commandeCltDao.findById(id);
//		if (findcommandeCltbyid.isPresent()) {
//			commandeCltDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
	@DeleteMapping("/commandeClt/{id}/delete")
	ResponseEntity<Void> deletecommandeClt(@PathVariable Integer id) {
		Optional<Object> comndclt = commandeCltDao.findById(id).map(commandeclt -> {
			commandeclt.setStatus("0");
			CommandeClt cmndClt = commandeCltDao.save(commandeclt);

			return ResponseEntity.ok(cmndClt);
		});
		if (!comndclt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}