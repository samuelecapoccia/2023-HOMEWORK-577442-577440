package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class ComandoVaiTest{
	
	private Stanza stanza1;
	private Labirinto labirinto;
	private Stanza stanza2;
	private Partita partita;
	private Comando vai;
	private IO io;
	
	
	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		stanza1 = new Stanza("Sala");
		stanza2 = new Stanza("Camera");
		vai = new ComandoVai();
		vai.setIo(io);
		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		partita = new Partita(labirinto);
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente(Direzione.sud, stanza2);
	}
	
	@Test
	void testVaiNull() {
		vai.esegui(partita);
		assertEquals(stanza1, partita.getStanzaCorrente());
	}

	@Test
	void testDirezioneCorretta() {
		vai.setParametro("sud");
		vai.esegui(partita);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}
	
	@Test 
	void testDirezioneErrata() {
		vai.setParametro("nord");
		vai.esegui(partita);
		assertNotEquals(stanza2, partita.getStanzaCorrente());
	}


}
