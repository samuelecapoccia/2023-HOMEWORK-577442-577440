package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale, stanzaVincente;

	private Labirinto(String nomeFile) 
			throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(nomeFile);
		caricatore.carica();
		this.setStanzaIniziale(caricatore.getStanzaIniziale());
		this.stanzaVincente = caricatore.getStanzaVincente();
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
		return new LabirintoBuilder(labirinto);
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}  
	
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public static class LabirintoBuilder{
		private Labirinto labirinto;
		private Map<String,Stanza> mappa;
		private Stanza ultima;

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.mappa = new HashMap<>();
		}

		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
			Stanza stanzaIniziale = new Stanza(nomeStanza);
			this.labirinto.setStanzaCorrente(stanzaIniziale);
			this.mappa.put(nomeStanza, stanzaIniziale);
			this.ultima = stanzaIniziale;
			return this;
		}
		
		public LabirintoBuilder addStanza(String nomeStanza) {
			if(!this.mappa.containsKey(nomeStanza)) {
				Stanza stanza = new Stanza(nomeStanza);
				this.mappa.put(nomeStanza, stanza);
				this.ultima=stanza;
			}
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanza) {
			Stanza vincente = new Stanza(nomeStanza);
			this.labirinto.setStanzaVincente(vincente);
			this.mappa.put(nomeStanza, vincente);
			this.ultima = vincente;
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
			StanzaMagica stanzaMagica = new StanzaMagica(nomeStanza,sogliaMagica);
			this.mappa.put(nomeStanza, stanzaMagica);
			this.ultima = stanzaMagica;
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nomeStanza, String illuminazione) {
			StanzaBuia stanzaBuia = new StanzaBuia(nomeStanza, illuminazione);
			this.mappa.put(nomeStanza, stanzaBuia);
			this.ultima = stanzaBuia;
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nomeStanza, String attrezzoSbloccante, Direzione direzioneBloccata) {
			StanzaBloccata stanzaBloccata = new StanzaBloccata(nomeStanza, attrezzoSbloccante, direzioneBloccata);
			this.mappa.put(nomeStanza, stanzaBloccata);
			this.ultima = stanzaBloccata;
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			if(this.ultima!=null) {
				this.ultima.addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
			}
			return this;
		}
		
		/*public LabirintoBuilder addAdiacenza(String nomeStanza, String nomeStanzaAdiacente, String direzione) {
			if(this.mappa.containsKey(nomeStanza) && this.mappa.containsKey(nomeStanzaAdiacente))
				this.mappa.get(nomeStanza).impostaStanzaAdiacente(direzione, this.mappa.get(nomeStanzaAdiacente));
			return this;
		}*/
		
		/*public LabirintoBuilder addAdiacenza(String nomeStanza, String nomeStanzaAdiacente, String direzione) {
		    if (this.mappa.containsKey(nomeStanza) && this.mappa.containsKey(nomeStanzaAdiacente)) {
		        Stanza stanza = this.mappa.get(nomeStanza);
		        Stanza stanzaAdiacente = this.mappa.get(nomeStanzaAdiacente);
		        stanza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		        stanzaAdiacente.impostaStanzaAdiacente(oppostaDirezione(direzione), stanza);
		    }
		    return this;
		}*/
		
		public LabirintoBuilder addAdiacenza(String nomeStanza, String nomeStanzaAdiacente, Direzione direzione) {
		    if (this.mappa.containsKey(nomeStanza) && this.mappa.containsKey(nomeStanzaAdiacente)) {
		        Stanza stanza = this.mappa.get(nomeStanza);
		        Stanza stanzaAdiacente = this.mappa.get(nomeStanzaAdiacente);
		        stanza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		    }
		    return this;
		}


		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		public Map<String,Stanza> getMappaStanze(){
			return this.mappa;
		}
	}
	
}

