/*package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;

	@BeforeEach
	void setUp() throws Exception {
		fabbrica = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(),fabbrica.costruisciComando("ciao").getNome());
	}

	@Test
	void testComandoConParametro() {
		comando = new ComandoPrendi();
		comando.setParametro("osso");
		Comando attuale = fabbrica.costruisciComando("prendi osso");
		assertEquals(comando.getNome(),attuale.getNome());
		assertEquals(comando.getParametro(), attuale.getParametro());
	}
	
	@Test
	void testComandoSenzaParametro() {
		comando = new ComandoAiuto();
		assertEquals(comando.getNome(),fabbrica.costruisciComando("aiuto").getNome());
	}

}*/
