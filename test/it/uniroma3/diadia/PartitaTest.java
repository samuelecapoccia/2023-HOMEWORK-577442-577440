package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {

	private Partita partita;
	private Partita partita2;


	@BeforeEach
	public void setUp() {
		this.partita = new Partita(new Labirinto());
		this.partita2 = new Partita(new Labirinto());
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
