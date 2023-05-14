package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
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


	public Partita(Labirinto labirinto){
		this.finita = false;
		this.labirinto= labirinto;
		this.giocatore=new Giocatore();
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente);
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.labirinto.setStanzaVincente(stanzaVincente);
	}
	
	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
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


	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setGiocatore(Giocatore giocatore){
		this.giocatore=giocatore;
	}
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}

}
