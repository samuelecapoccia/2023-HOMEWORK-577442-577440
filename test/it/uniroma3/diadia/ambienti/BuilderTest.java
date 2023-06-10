package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BuilderTest {
	private Labirinto.LabirintoBuilder labirintoBuilder;

	@BeforeEach
	public void setUp() throws Exception {
		this.labirintoBuilder = new LabirintoBuilder("labirinto.txt");
	}


	@Test
	public void testStanzaIniziale() {
		this.labirintoBuilder.addStanzaIniziale("start");
		assertEquals(new Stanza("start"),this.labirintoBuilder.getMappaStanze().get("start"));
	}
	
	@Test
	public void testStanzaMagica() {
		this.labirintoBuilder.addStanzaMagica("magica", 1);
		this.labirintoBuilder.getMappaStanze().get("magica").addAttrezzo(new Attrezzo("a1",1));
		this.labirintoBuilder.getMappaStanze().get("magica").addAttrezzo(new Attrezzo("AB",1));
		assertEquals(this.labirintoBuilder.getMappaStanze().get("magica").getAttrezzo("BA"),new Attrezzo("BA",2));
	}

	@Test
	public void testStanzaVincente() {
		this.labirintoBuilder.addStanzaVincente("end");
		assertEquals(new Stanza("end"),this.labirintoBuilder.getMappaStanze().get("end"));
	}

	
	@Test
	public void testAddAdiacenza() {
		this.labirintoBuilder.addStanzaIniziale("start");
		this.labirintoBuilder.addStanza("aEst");
		this.labirintoBuilder.addAdiacenza("start", "aEst", Direzione.valueOf("est"));
		assertEquals(new Stanza("aEst"),this.labirintoBuilder.getMappaStanze().get("start").getStanzaAdiacente(Direzione.valueOf("est")));
	}
	
	@Test
	public void testStanzaBloccataConSbloccante() {
		this.labirintoBuilder.addStanzaBloccata("bloccata", "chiave", Direzione.valueOf("nord"));
		this.labirintoBuilder.addAttrezzo("chiave", 1);
		Stanza bloccata = this.labirintoBuilder.getMappaStanze().get("bloccata");
		Stanza aNord = new Stanza("aNord");
		this.labirintoBuilder.addStanza("aNord");
		this.labirintoBuilder.addAdiacenza("bloccata", "aNord", Direzione.valueOf("nord"));
		assertEquals(aNord,bloccata.getStanzaAdiacente(Direzione.valueOf("nord")));
	}
	
	@Test
	public void testStanzaBloccataSenzaSbloccante() {
	    this.labirintoBuilder.addStanzaBloccata("bloccata", "chiave", Direzione.valueOf("nord"));
	    this.labirintoBuilder.addAdiacenza("bloccata", "bloccata", Direzione.valueOf("nord"));
	    assertEquals("bloccata", this.labirintoBuilder.getMappaStanze().get("bloccata").getStanzaAdiacente(Direzione.valueOf("nord")).getNome());
	}

	
	@Test
	public void testStanzaBuioConLuce() {
		this.labirintoBuilder.addStanzaBuia("buia", "lanterna");
		this.labirintoBuilder.addAttrezzo("lanterna", 1);
		StanzaBuia buia = new StanzaBuia("buia","lanterna");
		buia.addAttrezzo(new Attrezzo("lanterna",1));
		assertEquals(buia.getDescrizione(),this.labirintoBuilder.getMappaStanze().get("buia").getDescrizione());
		
	}
	
	@Test
	public void testStanzaBuioSenzaLuce() {
		this.labirintoBuilder.addStanzaBuia("buia", "lanterna");
		assertEquals("Qui c'è un buio pesto!",this.labirintoBuilder.getMappaStanze().get("buia").getDescrizione());	
	}
	
	
	@Test
	public void testAddStanza() {
		this.labirintoBuilder.addStanza("prova");
		assertTrue(this.labirintoBuilder.getMappaStanze().size() == 1 && this.labirintoBuilder.getMappaStanze().containsKey("prova"));
	}
	
	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzo = new Attrezzo("attrezzo",1);
		this.labirintoBuilder.addStanzaIniziale("start");
		this.labirintoBuilder.getMappaStanze().get("start").addAttrezzo(attrezzo);
		assertTrue(this.labirintoBuilder.getMappaStanze().get("start").getAttrezzi().containsValue(attrezzo));
		
	}
}