package fr.banque.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.banque.models.Client;

@RestController
@RequestMapping("clients")
public class ClientController {

private List<Client> clients = initClient();
	
	public List<Client> initClient() {
		List<Client> users = new ArrayList<>();
		
		users.add(new Client("Dupond", "Jean", 35, 1));
		users.add(new Client("Dupond", "Mathieu", 35, 2));
		users.add(new Client("Dupont", "John", 40, 3));
		users.add(new Client("Albert", "Luc", 68, 4));
		
		return users;
	}
	
	@GetMapping()
	public List<Client> findAll() {
		return this.clients;
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable int id) {
		Client user;
		if (id > this.clients.size() - 1)
			user = null;
		else 
			user = this.clients.get(id);
		return user;
	}
	
	@PostMapping()
	public Client save(@RequestBody Client client) {
		if (client instanceof Client)
			this.clients.add(client);
		return client;
	}
	
	@PutMapping("/{id}")
	public Client update(@RequestBody Client client, @PathVariable int id) {
		Client localClient = this.findById(id);
		localClient.setNom(client.getNom());
		localClient.setPrenom(client.getPrenom());
		localClient.setAge(client.getAge());
		localClient.setNumero(client.getNumero());
		return localClient;
	}
	
	@DeleteMapping("/{id}")
	public Client delete(@PathVariable int id) {
		Client user = this.clients.remove(id);
		return user;
	}
	
	@GetMapping("nom/{nom}")
	public Client findByNom(@PathVariable String nom) {
		Client lUser = null;
		for (Client user : this.clients) {
			if(user.getNom().toLowerCase().equals(nom.toLowerCase())) {
				lUser = user;
			}
		}
		return lUser;
	}
	
	@GetMapping("noms/{nom}")
	public List<Client> findManyByNom(@PathVariable String nom) {
		List<Client> lUsers = null;

		lUsers = this.clients.stream()
				.filter(line -> nom.toLowerCase().equals(line.getNom().toLowerCase()))
				.collect(Collectors.toList());
		return lUsers;
	}
}
