package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPrendiTest {
	
	private Partita partita;
	private Comando prendi;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private IO io = new IOConsole();

	@BeforeEach
	void setUp() throws Exception {
		Stanza stanza1 = new Stanza("Aula");
		partita = new Partita(new Labirinto());
		attrezzo1 = new Attrezzo("Martello", 6);
		attrezzo2 = new Attrezzo("Incudine", 7);
		prendi = new ComandoPrendi();
		partita.setStanzaCorrente(stanza1);
		stanza1.addAttrezzo(attrezzo1);
	}

	@Test
	void testPrende() {
		prendi.setParametro("Martello");
		prendi.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testNonPrende() {
		prendi.setParametro("Ariete");
		prendi.esegui(partita,io);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testNonPrendeLimiteDiPeso() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		prendi.setParametro("Martello");
		prendi.esegui(partita,io);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}

}
