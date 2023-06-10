package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class LabirintoTest {

	private Labirinto labirinto;

	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(this.labirinto.getStanzaVincente().getNome(),"Biblioteca");
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(this.labirinto.getStanzaIniziale().getNome(),"Atrio");
	}
	
	@Test
	public void testStanzaAdiacente() {
		assertEquals(this.labirinto.getStanzaVincente().getStanzaAdiacente(Direzione.valueOf("sud")).getNome(), "Atrio");
	}

}
