package fr.banque.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Client {

	protected String nom;
	protected String prenom;
	protected int age;
	protected int numero;
//	protected Compte[] comptes;
//	private List<Compte> comptes;
	private Map<Integer, Compte> comptes;
	
	public Client () {}
	
	/**
	 * Constructeur avec les param�tres nom pr�nom age et num�ro client
	 * instancie un array de comptes avec 5 cases vides
	 * @param cNom
	 * @param cPrenom
	 * @param cAge
	 * @param cNumero
	 */
	public Client(String cNom, String cPrenom, int cAge, int cNumero) {
		this.nom = cNom;
		this.prenom =cPrenom;
		this.age = cAge;
		this.numero = cNumero;
//		this.comptes = new Compte[5];
//		this.comptes = new ArrayList<Compte>();
		this.comptes = new Hashtable<Integer, Compte>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Map<Integer,Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Map<Integer, Compte> comptes) {
		this.comptes = comptes;
	}
	
	/**
	 * Recherche un compte � partir du num�ro de compte
	 * affiche un message si pas de compte trouv�
	 * @param unNumero num�ro du compte � rechercher
	 * @return compte | null
	 */
	public Compte getCompte (int unNumero) {
		for (Map.Entry<Integer, Compte> compte : this.comptes.entrySet()) {
//			if ( compte != null && compte.getNumero() == unNumero) {
//				return compte;
//			}	
			if ( compte.getKey() == unNumero) {
				return compte.getValue();
			}
		}
		System.out.println("Aucun compte trouv� !");
		return null;
	}
	
	/**
	 * Ajoute un compte dans une case vide
	 * Si pas de place disponible, affiche un message
	 * @param compte le compte � ajouter
	 */
	public void addCompte (Compte compte) throws BanqueException {
//		boolean added = false;
//		for (int i=0; i<this.comptes.length; i++) {
//			if (this.comptes[i] == null) {
//				this.comptes[i] = compte;
//				added = true;
//				return;
//			}		
//		}
//		if (!added)
//			throw new BanqueException("pas de place disponible !");
//		this.comptes.add(compte);
		this.comptes.put(compte.getNumero(), compte);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + comptes.hashCode();
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (age != other.age)
			return false;
		if (!this.comptes.equals(obj))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", comptes="
				+ comptes + "]";
	}
	
	
}
