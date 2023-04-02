package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita1;
	private Partita partita2;
	private Partita partita3;
	private Stanza stanza;

	@BeforeEach
	public void setUp() {
		this.partita1= new Partita();
		this.partita2 = new Partita();
		this.partita3 = new Partita();
		this.stanza = partita3.getLabirinto().getStanzaVincente();
		partita2.setFinita();
		partita3.getLabirinto().setStanzaCorrente(stanza);


	}

	//TEST isFinita

	@Test
	public void testIsNotFinita() {
		assertFalse(partita1.isFinita());
	}

	@Test
	public void testIsFinita() {
		assertTrue(partita2.isFinita());
	}


	//TEST vinta;

	@Test
	public void testVinta(){
		assertTrue(partita3.vinta());
	}

	@Test
	public void testNonVinta(){
		assertFalse(partita1.vinta());
	}


}
