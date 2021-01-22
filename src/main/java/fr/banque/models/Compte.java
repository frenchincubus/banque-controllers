package fr.banque.models;

public class Compte implements ICompte {
	
	protected int numero;
	protected double solde;
	
	public Compte() {
		
	}
	
	/**
	 * 
	 * @param dNumero
	 * @param dSolde
	 */
	public Compte (int dNumero, double dSolde) {
		this.numero =  dNumero;
		this.solde = dSolde;
	}

	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	private void setSolde(double solde) {
		this.solde = solde;
	}
	
	/**
	 * Cr�dite le solde actuel du montant en param�tre
	 * @param unMontant � ajouter
	 */
	public void ajouter(double unMontant) {
		if ( unMontant > 0)
			this.setSolde(this.solde + unMontant);
	}
	/**
	 * D�bite le solde du montant en param�tre 
	 * @param unMontant
	 */
	public void retirer(double unMontant) throws BanqueException {
		if (unMontant > 0)
			this.setSolde(this.solde - unMontant);
		else throw new BanqueException("erreur sur le montant renseign�");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compte other = (Compte) obj;
		if (numero != other.numero)
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		return true;
	}
	
	

}
