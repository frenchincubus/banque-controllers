package fr.banque.models;

public interface ICompteRemunere extends ICompte {
	
	public double calculerInterets();
	public void verserInterets();
	public double getTaux();
	public void setTaux(double unTaux);

}
