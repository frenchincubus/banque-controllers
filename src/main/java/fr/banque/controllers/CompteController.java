package fr.banque.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.banque.models.Compte;
import fr.banque.models.CompteASeuil;
import fr.banque.models.CompteASeuilRemunere;
import fr.banque.models.CompteRemunere;
import fr.banque.models.ICompte;

@RestController
@RequestMapping("comptes")
public class CompteController {

private List<Compte> comptes = initCompte();
	
	public List<Compte> initCompte() {
		List<Compte> comptes = new ArrayList<>();
		
		comptes.add(new Compte(1, 5000.0));
		comptes.add(new Compte(2, 953.0));
		comptes.add(new CompteASeuil(3, 1500.0, 200.0));
		comptes.add(new CompteRemunere( 4, 30000.0, 0.5));
		
		return comptes;
	}
	
	@GetMapping()
	public List<Compte> findAll() {
		return this.comptes;
	}
	
	@GetMapping("/{id}")
	public Compte findById(@PathVariable int id) {
		Compte compte;
		if (id > this.comptes.size() - 1)
			compte = null;
		else 
			compte = this.comptes.get(id);
		return compte;
	}
	
	@PostMapping()
	public Compte save(@RequestBody Compte compte) {
			this.comptes.add(compte);
	
		return compte;
	}
	
	@PutMapping("/{id}")
	public Compte update(@RequestBody Compte compte, @PathVariable int id) {
		Compte localCompte = this.findById(id);
		localCompte.ajouter(compte.getSolde());
		if(localCompte instanceof CompteRemunere) {			
			((CompteRemunere) localCompte).setTaux(((CompteRemunere) compte).getTaux());
		}
		else if(localCompte instanceof CompteASeuil) {
			((CompteASeuil) localCompte).setSeuil(((CompteASeuil) compte).getSeuil());
		}
		else if(localCompte instanceof CompteASeuilRemunere) {
			((CompteASeuilRemunere) localCompte).setSeuil(((CompteASeuilRemunere) compte).getSeuil());
			((CompteASeuilRemunere) localCompte).setTaux(((CompteASeuilRemunere) compte).getTaux());
		}
		return localCompte;
	}
	
	@DeleteMapping("/{id}")
	public Compte delete(@PathVariable int id) {
		Compte compte = this.comptes.remove(id);
		return compte;
	}
	
}
