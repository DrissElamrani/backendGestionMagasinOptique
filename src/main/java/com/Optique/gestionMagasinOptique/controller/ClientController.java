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

import com.Optique.gestionMagasinOptique.Exception.ClientIntrouvableException;
import com.Optique.gestionMagasinOptique.dao.ClientDao;
import com.Optique.gestionMagasinOptique.dao.JournalUserDao;
import com.Optique.gestionMagasinOptique.model.Client;
//import com.Optique.gestionMagasinOptique.model.UserJournals;
import com.Optique.gestionMagasinOptique.model.LigneReglmClt;

/**
 * @author pcuser9
 *
 */
@RestController
@RequestMapping("/optique")
@CrossOrigin
public class ClientController {

	/**
	 * Client
	 * 
	 */
	@Autowired
	private ClientDao clientDao;

	public ClientDao getClientDao() {
		return clientDao;
	}
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}
	public String getDateNow() {
	Date date=new Date();
	SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = formatdate.format(date);
	return dateNow;
	}
	// get List Clients
	@GetMapping(value = "/clients/list")
	public List<Client> listClients() {
		List<Client> listClient = clientDao.listClient();
		return listClient;
	}

	// get client by id
	@GetMapping(value = "/clients/{id}")
	public ResponseEntity<Client> afficherUnClient(@PathVariable int id) {
		Client clt = clientDao.findById(id);
		if (clt == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(clt);
	}
	// ajouter un clients
	@PostMapping(value = "/clients/create")
	public ResponseEntity<Void> ajouterClient(@RequestBody Client client) {
		client.setDateCreation(getDateNow());
		String nom=client.getNom().substring(0, 2);
		String prenom=client.getPrenom().substring(0, 2);
		String annee=client.getDateCreation().substring(0, 4);
		String num=nom+prenom+"_"+annee;
		client.setNumero(num);
		client.setStatus("1");
		Client clt = clientDao.save(client);
		if (clt == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clt.getIdClt())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
//	modifier un client By id
	@PutMapping("/clients/{id}/update")
	ResponseEntity<Client> updateClient(@RequestBody Client newClient, @PathVariable Integer id) {
		Optional<Object> clt = clientDao.findById(id).map(client -> {
			client.setNom(newClient.getNom());
			client.setPrenom(newClient.getPrenom());
			client.setEmail(newClient.getEmail());
			client.setMutuelle(newClient.getMutuelle());
			client.setRemarque(newClient.getRemarque());
			client.setTelephone(newClient.getTelephone());
			client.setAddresse(newClient.getAddresse());
			client.setDateModification(getDateNow());
			Client clt1 = clientDao.save(client);

			return ResponseEntity.ok(clt1);
		});
		if (!clt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
////	supprimerS un client By id
//	@DeleteMapping("/clients/{id}/delete")
//	ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
//		Optional<Client> findClientbyid = clientDao.findById(id);
//		if (findClientbyid.isPresent()) {
//			clientDao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.noContent().build();
//	}
	
	
//	supprimerS un clients By id
	@DeleteMapping("/clients/{id}/delete")
	ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
		Optional<Object> clt = clientDao.findById(id).map(client -> {
			client.setStatus("0");
			Client clt1 = clientDao.save(client);

			return ResponseEntity.ok(clt1);
		});
		if (!clt.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}
}