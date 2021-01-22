package fr.banque.models;

public class CompteRemunere extends Compte implements ICompteRemunere {

	protected double taux;

	public CompteRemunere() {
		super();
	}

	public CompteRemunere(int dNumero, double dSolde, double taux) {
		super(dNumero, dSolde);
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
		return "CompteRemunere [" + super.toString() + ", taux=" + taux + "]";
	}
	
	public double calculerInterets() {
		return this.taux * this.solde;
	}
	
	public void verserInterets() {
		this.ajouter(this.calculerInterets());
	}
}
