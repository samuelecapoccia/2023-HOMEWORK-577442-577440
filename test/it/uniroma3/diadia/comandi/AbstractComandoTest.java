package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

class AbstractComandoTest {
	
	Partita partita;
	ComandoAiuto comandoA;
	ComandoVai comandoV;
	private IO io;
	

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		comandoA = new ComandoAiuto();
		comandoV = new ComandoVai();
		comandoV.setIo(io);
		partita = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}

	@Test
	void testGetIO() {
		comandoA.setIo(new IOConsole(new Scanner(System.in)));
		assertNotNull(comandoA.getIo());
	}
	
	@Test
	void testGetParametro() {
		comandoV.setParametro("nord");
		assertEquals("nord",comandoV.getParametro());
	}
	
	@Test
	public void testEseguiCasoComandoVai() {
		comandoV.setParametro("nord");
		comandoV.esegui(partita);
		assertTrue(partita.vinta());
	}

}
