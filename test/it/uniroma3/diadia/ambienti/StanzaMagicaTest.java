package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class StanzaMagicaTest {
	
	private Partita partita;
	private StanzaMagica stanza1;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Comando comando1;
	private Comando comando2;
	private Labirinto labirinto;
	private IO io;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		labirinto = Labirinto.newBuilder("labirintoMagico.txt").getLabirinto();
		partita = new Partita(labirinto);
		comando1 = new ComandoPosa();
		comando2 = new ComandoPosa();
		comando1.setIo(io);
		comando2.setIo(io);
		stanza1 = new StanzaMagica("Aula",1);
		attrezzo1 = new Attrezzo("spada", 4);
		attrezzo2 = new Attrezzo("pala", 3);
		partita.setStanzaCorrente(stanza1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
	}

	@Test
	void testStanzaMagicaInverteNome() {
		comando1.setParametro("spada");
		comando1.esegui(partita);
		comando2.setParametro("pala");
		comando2.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("alap"));
	}
	
	@Test
	void testStanzaMagicaRaddoppiaPeso() {
		comando1.setParametro("spada");
		comando1.esegui(partita);
		comando2.setParametro("pala");
		comando2.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getAttrezzo("alap").getPeso(), 6);
	}
	
	@Test
	void testStanzaNonArrivaAllaSogliaMagica() {
		comando1.setParametro("spada");
		comando1.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	@Test
	void testStanzaNonRaddoppiaPeso() {
		comando1.setParametro("spada");
		comando1.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getAttrezzo("spada").getPeso(), 4);
	}

}
