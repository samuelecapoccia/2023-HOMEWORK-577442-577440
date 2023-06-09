package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
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
		
		static final private int NUMERO_MASSIMO_ATTREZZI = 10;

		/*private String nome;
		private Attrezzo[] attrezzi;
		private int numeroAttrezzi;
		private Stanza[] stanzeAdiacenti;
		private int numeroStanzeAdiacenti;
		private String[] direzioni;*/
		
		protected String nome;
		protected Map<String, Attrezzo> attrezzi;
		protected Map<String, Stanza> stanzeAdiacenti;
		protected List<String> direzioni;

		/** 
		 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
		 * @param nome il nome della stanza
		 */
		public StanzaProtected(String nome) {
			this.nome = nome;
			this.direzioni = new ArrayList<>(Arrays.asList("nord", "sud", "ovest", "est"));
			this.stanzeAdiacenti = new HashMap<>(4);
			this.attrezzi = new HashMap<>(10);
			}

		/**
		 * Imposta una stanza adiacente.
		 *
		 * @param direzione direzione in cui sara' posta la stanza adiacente.
		 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
		 */
		public boolean impostaStanzaAdiacente(String direzione, Stanza stanza) {
			//boolean aggiornato = false;
			/*for(int i=0; i<this.direzioni.size(); i++)
				if (direzione.equals(this.direzioni.get(i))) {
					this.stanzeAdiacenti.add(stanza);
					aggiornato = true;
				}*/
			if(this.direzioni.contains(direzione))
				this.stanzeAdiacenti.put(direzione, stanza);
			else
				return false;
			return true;
			
			/*if (!aggiornato)
				if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
					this.direzioni[numeroStanzeAdiacenti] = direzione;
					this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
					this.numeroStanzeAdiacenti++;
				}*/
		}

		/**
		 * Restituisce la stanza adiacente nella direzione specificata
		 * @param direzione
		 */
		public Stanza getStanzaAdiacente(String direzione) {
			/*Stanza stanza = null;
			for(int i=0; i<this.numeroStanzeAdiacenti; i++)
				if (this.direzioni[i].equals(direzione))
					stanza = this.stanzeAdiacenti[i];
			return stanza;*/
			return this.stanzeAdiacenti.get(direzione);
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
			Set<String> direzioni = this.stanzeAdiacenti.keySet();
			for (String direzione : direzioni)
				//if (direzione!=null)
					stampa.append(direzione + " ");

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


		public Set<String> getDirezioni() {
			return this.stanzeAdiacenti.keySet();
		}

	}
