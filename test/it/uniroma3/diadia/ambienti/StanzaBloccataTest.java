package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Attrezzo attrezzoSbloccante;
	

	@BeforeEach
	void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("Bloccata", "chiave", Direzione.valueOf("sud"));
		stanza = new Stanza("Sbloccata");
		attrezzoSbloccante = new Attrezzo("chiave", 1);
		stanzaBloccata.impostaStanzaAdiacente(Direzione.valueOf("sud"), stanza);
	}

	@Test
	void testGetStanzaAdiacenteSenzaAttrezzoNellaStanza() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(Direzione.valueOf("sud")));
	}
	
	@Test 
	void testGetStanzaAdiacenteConAttrezzoNellaStanza() {
		stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanza, stanzaBloccata.getStanzaAdiacente(Direzione.valueOf("sud")));
	}
	
	@Test
	void testGetDescrizioneSenzaAttrezzoNellaStanza() {
		String descrizioneBloccata = new String("Questa stanza è bloccata andando verso: sud. \nPer accedervi hai bisogno dell'attrezzo:"
				+ " chiave. Prendilo e posalo in questa stanza!");
		assertEquals(descrizioneBloccata, stanzaBloccata.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzoNellaStanza() {
		stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}

}
