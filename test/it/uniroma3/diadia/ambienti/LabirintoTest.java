package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;


class LabirintoTest {

	private Stanza stanza1;
	private Partita partita;

	@BeforeEach
	void setUp() {
		this.stanza1 = new Stanza("Stanza1");
		this.partita = new Partita();
		partita.getLabirinto().setStanzaCorrente(stanza1);
	}

	@Test
	void testSetStanzaCorrente() {
		assertEquals(stanza1, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}

}
