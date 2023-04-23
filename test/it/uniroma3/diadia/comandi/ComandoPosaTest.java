package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
		private Partita partita;
		private Comando posa;
		private Attrezzo attrezzo1;
		private IO io = new IOConsole();
		
	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		attrezzo1 = new Attrezzo("Martello", 1);
		posa = new ComandoPosa();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		
	}

	@Test
	void testPosaAttrezzoEsistente() {
		posa.setParametro("Martello");
		posa.esegui(partita,io);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Martello"));
	}
	
	@Test
	void testPosaAttrezzoNonEsistente() {
		posa.setParametro("Ariete");
		posa.esegui(partita,io);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Martello"));
	}
	

}
