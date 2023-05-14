package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private Borsa borsa1;
	private Borsa borsa2;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;

	@BeforeEach
	void setUp() {
		this.borsa1 = new Borsa();
		this.borsa2 = new Borsa();
		this.attrezzo1 = new Attrezzo("Martello", 6);
		this.attrezzo2 = new Attrezzo("Cacciavite", 2);
		this.attrezzo3 = new Attrezzo("Chiave inglese", 5);
		this.attrezzo4 = new Attrezzo("Ariete", 27);
		borsa1.addAttrezzo(attrezzo3);
		borsa2.addAttrezzo(attrezzo1);
		borsa2.addAttrezzo(attrezzo2);
	}

	//TEST addAttrezzo

	@Test
	void testAddAttrezzoPesoBorsaMinoreDi10() {
		assertTrue(borsa1.addAttrezzo(attrezzo2));
	}

	@Test
	void testAddAttrezzoPesoBorsaMaggioreDi10() {
		assertFalse(borsa2.addAttrezzo(attrezzo3));
	}

	@Test
	void testAddAttrezzoPesoMaggiore() {
		assertFalse(borsa1.addAttrezzo(attrezzo4));
	}

	@Test
	void testAddAttrezzoPesoMaggioreI() {
		assertFalse(borsa1.addAttrezzo(attrezzo1));
	}


	//TEST getAttrezzo


	@Test
	void testGetAttrezzoBorsaConUnAttrezzo() {
		assertEquals(attrezzo3, borsa1.getAttrezzo("Chiave inglese"));
	}

	@Test
	void testGetAttrezzoBorsaConDueAttrezzi() {
		assertEquals(attrezzo1, borsa2.getAttrezzo("Martello"));
	}

	@Test
	void testGetAttrezzoNonEsistente() {
		assertNull(borsa1.getAttrezzo("Cacciavite"));
	}

	//TEST removeAttrezzo

	@Test
	void testRemoveAttrezzoBorsaConUnOggetto() {
		assertEquals(attrezzo1, borsa2.removeAttrezzo("Martello"));
	}

	@Test
	void testRemoveAttrezzoBorsaConDueOggetti() {
		assertEquals(attrezzo2, borsa2.removeAttrezzo("Cacciavite"));
	}
	
}
