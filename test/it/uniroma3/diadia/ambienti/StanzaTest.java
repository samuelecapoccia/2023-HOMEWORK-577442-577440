package it.uniroma3.diadia.ambienti;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
//test di impostaStanzaAdiacente, getStanzaAdiacente, addAttrezzo, removeAttrezzo

class StanzaTest {

	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanza3;


	@BeforeEach
	public void setUp() {
		this.stanza1=new Stanza("stanza 1");
		this.stanza2 = new Stanza("stanza 2");
		this.stanza3 = new Stanza("stanza 3");
		this.attrezzo1 = new Attrezzo("Zappa", 23);
		this.attrezzo2 = new Attrezzo ("Pala", 4);
		this.attrezzo3 = new Attrezzo ("Martello", 2);
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("sud"), stanza2);
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("nord"), stanza3);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		stanza2.addAttrezzo(attrezzo2);
	}



	//TEST GetStanzaAdiacente

	@Test
	void testGetStanzaAdiacenteGiàEsistenteSud() {
		assertEquals(stanza2, stanza1.getStanzaAdiacente(Direzione.valueOf("sud")));
	}

	@Test
	void testGetStanzaAdiacenteNonEsistente() {
		assertNull(stanza1.getStanzaAdiacente(Direzione.valueOf("est")));
	}

	//TEST AddAttrezzo

	@Test
	void testAddAttrezzoMartello() {
		assertTrue(stanza1.addAttrezzo(attrezzo3));
	}

	@Test
	void testAddAttrezzoDoppione() {
		assertTrue(stanza1.addAttrezzo(attrezzo2));
	}

	@Test
	void testAddAttrezzoAltraStanza() {
		assertTrue(stanza2.addAttrezzo(attrezzo1));
	}


	//TEST GetAttrezzo

	@Test
	void testGetAttrezzoEsistenteInUnaStanza() {
		assertEquals(attrezzo1, stanza1.getAttrezzo("Zappa"));
	}

	@Test
	void testGetAttrezzoNonEsistenteInUnaStanza() {
		assertNull(stanza2.getAttrezzo("Zappa"));
	}

	@Test
	void testGetAttrezzoEsistenteInUnaStanzaConDueAttrezzi() {
		assertEquals(attrezzo2, stanza1.getAttrezzo("Pala"));
	}


	//TEST RemoveAttrezzo

	@Test
	void testRemoveAttrezzoPresenteInUnaStanza() {
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
	}

	@Test
	void testRemoveAttrezzoNonPresenteInUnaStanza() {
		assertFalse(stanza3.removeAttrezzo(attrezzo2));
	}

	@Test
	void testRemoveAttrezzoStanzaConDueAttrezzi() {
		assertTrue(stanza1.removeAttrezzo(attrezzo2));
	}
	
	@Test 
	void testHasAttrezzo() {
		assertTrue(this.stanza1.hasAttrezzo("Zappa"));
	}

}
