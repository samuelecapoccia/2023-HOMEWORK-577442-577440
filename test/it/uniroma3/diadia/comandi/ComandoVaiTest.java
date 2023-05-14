package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class ComandoVaiTest{
	
	private Stanza stanza1;
	private Stanza stanza2;
	private Partita partita;
	private Comando vai;
	private IO io = new IOConsole();

	@BeforeEach
	void setUp() throws Exception {
		stanza1 = new Stanza("Sala");
		stanza2 = new Stanza("Dio");
		vai = new ComandoVai();
		partita = new Partita(new Labirinto());
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud", stanza2);
	}
	
	@Test
	void testVaiNull() {
		vai.esegui(partita, io);
		assertEquals(stanza1, partita.getStanzaCorrente());
	}

	@Test
	void testDirezioneCorretta() {
		vai.setParametro("sud");
		vai.esegui(partita,io);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}
	
	@Test 
	void testDirezioneErrata() {
		vai.setParametro("nord");
		vai.esegui(partita,io);
		assertNotEquals(stanza2, partita.getStanzaCorrente());
	}


}
