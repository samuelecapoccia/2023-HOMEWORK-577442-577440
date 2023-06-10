package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {
	
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private Map<String, Attrezzo> attrezzi;
	private Map<Direzione, Stanza> stanzeAdiacenti;
	//private List<Direzione> direzioni;
	private AbstractPersonaggio personaggio;

	/** 
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		//this.direzioni = new ArrayList<>(nord);Arrays.asList("nord", "sud", "ovest", "est"));
		this.stanzeAdiacenti = new HashMap<>(4);
		this.attrezzi = new HashMap<>(NUMERO_MASSIMO_ATTREZZI);
		}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public boolean impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		//if(this.direzioni.contains(direzione)) 
		if(!stanzeAdiacenti.containsKey(direzione)){
			this.stanzeAdiacenti.put(direzione, stanza);
			return true;
		}
		else
			return false;
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		//return this.stanzeAdiacenti.get(direzione);
	    Stanza adiacente = this.stanzeAdiacenti.get(direzione);
	    if (adiacente != null) {
	        return adiacente;
	    } else {
	        return null; // oppure una stringa vuota o un valore che rappresenta l'assenza di una stanza adiacente
	    }

	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI)
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
		else 
			return false;
		return true;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	
	public String toString() {
		StringBuilder stampa = new StringBuilder();
		stampa.append(this.nome);
		stampa.append("\nUscite:\n");
		Set<Direzione> direzioni = this.stanzeAdiacenti.keySet();
		for (Direzione direzione : direzioni) {
				stampa.append(direzione + " ");
		}
		stampa.append("\nAttrezzi nella stanza:");

		for (Attrezzo att : this.attrezzi.values()){
			stampa.append(att.toString());
		}

		return stampa.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo))
			return this.attrezzi.get(nomeAttrezzo);
		else
			return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome(), attrezzo);
	}


	public Set<Direzione> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}
	
	public Map<Direzione,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	public List<Stanza> getStanzeAdiacenti(){
		List<Stanza> listaStanze = new ArrayList<>();
		for(Stanza s : stanzeAdiacenti.values()) {
			listaStanze.add(s);
		}
		return listaStanze;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null||o.getClass()!=this.getClass())
			return false;
		Stanza that = (Stanza) o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
}