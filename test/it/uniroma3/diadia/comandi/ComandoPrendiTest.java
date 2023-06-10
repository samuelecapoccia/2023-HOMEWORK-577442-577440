package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

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
	private Labirinto labirinto;
	private Comando prendi;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private IO io;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		Stanza stanza1 = new Stanza("Aula");
		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo1 = new Attrezzo("Martello", 6);
		attrezzo2 = new Attrezzo("Incudine", 7);
		prendi = new ComandoPrendi();
		prendi.setIo(io);
		partita.setStanzaCorrente(stanza1);
		stanza1.addAttrezzo(attrezzo1);
	}

	@Test
	void testPrende() {
		prendi.setParametro("Martello");
		prendi.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testNonPrende() {
		prendi.setParametro("Ariete");
		prendi.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testNonPrendeLimiteDiPeso() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		prendi.setParametro("Martello");
		prendi.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}

}
