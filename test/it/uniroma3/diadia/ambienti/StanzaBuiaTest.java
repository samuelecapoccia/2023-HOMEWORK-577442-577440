package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo torcia;

	@BeforeEach
	void setUp() throws Exception {
		stanza = new StanzaBuia("Stanza Buia", "Torcia");
		torcia = new Attrezzo("Torcia", 2);
	}

	@Test
	void testGetDescrizioneConAttrezzoCheIllumina() {
		stanza.addAttrezzo(torcia);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneSenzaAttrezzoCheIllumina() {
		String buio = new String("Qui c'è un buio pesto!");
		assertEquals(stanza.getDescrizione(), buio);
	}

}
