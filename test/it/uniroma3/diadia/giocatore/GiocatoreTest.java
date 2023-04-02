package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	private Giocatore giocatore1;

	@BeforeEach
	void setUp() {
		this.giocatore1 = new Giocatore();
		giocatore1.setCfu(140);
	}

	@Test
	void testGetCfu() {
		assertEquals(140, giocatore1.getCfu());
	}

}
