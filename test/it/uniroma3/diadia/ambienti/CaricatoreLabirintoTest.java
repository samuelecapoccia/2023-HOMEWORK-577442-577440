package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class CaricatoreLabirintoTest {
	
	private final String monolocale = 
			"Stanze:atrio\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:atrio\n"+
			"Vincente:atrio\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";
	
	private final String bilocale = 
			"Stanze:atrio,N10\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:atrio\n"+
			"Vincente:N10\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:spada 5 atrio\n"+
			"Uscite:atrio nord N10, N10 sud atrio\n";
	
	private CaricatoreLabirinto caricatore;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMonolocale() throws FormatoFileNonValidoException,FileNotFoundException {
		caricatore = new CaricatoreLabirinto(new StringReader(monolocale));
		caricatore.carica();
		assertEquals("atrio", this.caricatore.getStanzaIniziale().getNome());
		assertEquals("atrio", this.caricatore.getStanzaVincente().getNome());
	}
	
	@Test
	void testBilocale() throws FormatoFileNonValidoException,FileNotFoundException {
		caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
		caricatore.carica();
		assertEquals("atrio", this.caricatore.getStanzaIniziale().getNome());
		assertEquals("N10", this.caricatore.getStanzaVincente().getNome());
	}
	
	@Test
	void testAttrezzoBilocale() throws FormatoFileNonValidoException,FileNotFoundException {
		caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
		caricatore.carica();
		Attrezzo attrezzo = new Attrezzo("spada", 5);
		assertEquals(attrezzo, this.caricatore.getStanzaIniziale().getAttrezzo("spada"));
	}
	@Test
	public void test() throws FileNotFoundException, FormatoFileNonValidoException {
		caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
		caricatore.carica();
		assertEquals("N10", this.caricatore.getStanzaIniziale().getStanzaAdiacente(Direzione.valueOf("nord")).getNome());
	}

}
