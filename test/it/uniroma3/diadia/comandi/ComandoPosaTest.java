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

class ComandoPosaTest {
		private Partita partita;
		private Labirinto labirinto;
		private Comando posa;
		private Attrezzo attrezzo1;
		private Stanza stanza;
		private IO io;
		
	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		partita = new Partita(labirinto);
		stanza = new Stanza("stanza");
		attrezzo1 = new Attrezzo("Martello", 1);
		posa = new ComandoPosa();
		posa.setIo(io);
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		
	}

	@Test
	void testPosaAttrezzoEsistente() {
		posa.setParametro("Martello");
		posa.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testPosaAttrezzoNonEsistente() {
		posa.setParametro("Ariete");
		posa.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Martello"));
	}
	

}
