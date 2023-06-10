package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {

	private Partita partita;
	private Partita partita2;
	Labirinto labirinto;


	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		this.partita = new Partita(labirinto);
		this.partita2 = new Partita(labirinto);
		partita.setStanzaCorrente(this.partita.getStanzaVincente());
	}

	//TEST isFinita


	@Test
	public void testIsFinita() {
		partita2.setFinita();
		assertTrue(partita2.isFinita());
	}
	
	@Test
	public void testIsFinitaAlternativo() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}

	//TEST vinta;

	@Test
	public void testVinta(){
		assertTrue(partita.vinta());
	}
	
}
