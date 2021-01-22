package fr.banque.models;

public class CompteASeuilRemunere extends CompteASeuil implements ICompteRemunere {

	protected double taux;
	
	public CompteASeuilRemunere() {}
	
	public CompteASeuilRemunere (int numero, double solde, double seuil, double taux) {
		super(numero, solde, seuil);
		this.taux = taux;
	}
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double unTaux) {
		this.taux = unTaux;
	}

	@Override
	public String toString() {
		return "CompteRemunere [" + super.toString() + ", taux=" + this.taux + "]";
	}
	
	public double calculerInterets() {
		return this.taux * this.solde;
	}
	
	public void verserInterets() {
		this.ajouter(this.calculerInterets());
	}

}
