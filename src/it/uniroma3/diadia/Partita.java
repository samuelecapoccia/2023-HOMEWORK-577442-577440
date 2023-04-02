package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;


	public Partita(){
		this.finita = false;
		this.labirinto= new Labirinto();
		this.giocatore=new Giocatore();
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	
	public boolean vinta() {
		return this.getLabirinto().getStanzaCorrente()== this.getLabirinto().getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	
	public boolean isFinita() {
		return finita || vinta() || (getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	
	public void setFinita() {
		this.finita = true;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setGiocatore(Giocatore giocatore){
		this.giocatore=giocatore;
	}

}
