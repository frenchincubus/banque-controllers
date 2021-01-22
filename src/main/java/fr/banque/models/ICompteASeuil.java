package fr.banque.models;

public interface ICompteASeuil extends ICompte {
	
	/**
	 * permet de retirer un montant tant que le solde ne passe pas sous le seuil
	 * @param uneValeur
	 */
	public void retirer(double uneValeur) throws BanqueException;
	
	/**
	 * Retourne le montant du seuil
	 * @return
	 */
	public double getSeuil();
	
	/**
	 * Modifie le seuil de retrait du compte � seuil 
	 * @param unSeuil
	 */
	public void setSeuil(double unSeuil);

}
