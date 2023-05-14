package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoVaiAmpioTest {
	LabirintoBuilder builder;
	Partita partita;
	ComandoVai vai;
	IOConsole io;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.builder = new LabirintoBuilder();
		this.vai = new ComandoVai();
		this.io = new IOConsole();
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.builder = null;
		this.vai = null;
	}

	@Test
	public void testMonolocale() {
		this.builder.addStanzaIniziale("start");
		this.vai.setParametro("nord");
		this.partita = new Partita(this.builder.getLabirinto());
		assertEquals(this.partita.getStanzaCorrente(),this.builder.getMappaStanze().get("start"));
		this.vai.esegui(partita,io);
		assertEquals(this.partita.getStanzaCorrente(),this.builder.getMappaStanze().get("start"));
	}
	
	@Test
	public void testBilocale() {
		this.builder.addStanzaIniziale("start");
		this.builder.addStanzaVincente("end");
		this.builder.addAdiacenza("start", "end", "nord");
		this.builder.addAdiacenza("end", "start", "sud");
		this.partita = new Partita(this.builder.getLabirinto());
		vai.setParametro("nord");
		vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("end"),this.partita.getStanzaVincente());
		vai.setParametro("sud");
		vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("start"),this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testTrilocale() {
		this.builder.addStanzaIniziale("start");
		this.builder.addStanzaVincente("end");
		this.builder.addStanza("middle");
		this.builder.addAdiacenza("start", "end", "nord");
		this.builder.addAdiacenza("end", "start", "sud");
		this.builder.addAdiacenza("middle", "start", "est");
		this.builder.addAdiacenza("start", "middle", "ovest");
		this.builder.addAdiacenza("middle", "end", "ovest");
		this.builder.addAdiacenza("end", "middle", "est");
		this.partita = new Partita(this.builder.getLabirinto());
		this.vai.setParametro("nord");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("end"),this.partita.getStanzaVincente());
		this.vai.setParametro("est");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("middle"),this.partita.getStanzaCorrente());
		this.vai.setParametro("ovest");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("end"),this.partita.getStanzaCorrente());
		this.vai.setParametro("sud");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("start"),this.partita.getStanzaCorrente());
		this.vai.setParametro("ovest");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("middle"),this.partita.getStanzaCorrente());
		this.vai.setParametro("est");
		this.vai.esegui(partita,io);
		assertEquals(this.builder.getMappaStanze().get("start"),this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaBuia() {
		this.builder.addStanzaBuia("buia", "torcia");
		this.builder.addStanzaIniziale("start");
		this.builder.addAdiacenza("start", "buia", "nord");
		this.partita = new Partita(this.builder.getLabirinto());
		this.vai.setParametro("nord");
		this.vai.esegui(partita,io);
		assertEquals("Qui c'è un buio pesto!",this.partita.getStanzaCorrente().getDescrizione());
	}
	
	@Test
	public void testStanzaBloccata() {
		this.builder.addStanzaIniziale("start");
		this.builder.addStanzaBloccata("bloccata", "chiave", "est");
		this.builder.addStanza("aEst");
		this.builder.addAdiacenza("start", "bloccata", "nord");
		this.builder.addAdiacenza("bloccata", "aEst", "est");
		this.partita = new Partita(this.builder.getLabirinto());
		this.vai.setParametro("nord");
		this.vai.esegui(partita,io);
		this.vai.setParametro("est");
		this.vai.esegui(partita,io);
		assertEquals(this.partita.getStanzaCorrente(),this.builder.getMappaStanze().get("bloccata"));
	}

}
