package fr.banque.models;

public class CompteASeuil extends Compte implements ICompteASeuil {

	protected double seuil;

	public CompteASeuil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteASeuil(int dNumero, double dSolde, double seuil) {
		super(dNumero, dSolde);
		this.seuil = seuil;
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double unSeuil) {
		this.seuil = unSeuil;
	}

	@Override
	public String toString() {
		return "CompteASeuil [" + super.toString() + ", seuil=" + seuil + "]";
	}
	
	@Override
	public void retirer (double uneValeur) throws BanqueException {
		if (this.solde - uneValeur > this.seuil) {
			super.retirer(uneValeur);
		} else {
			throw new BanqueException("Le montant � retirer est sup�rieur au seuil autoris�");
		}
	}
}
