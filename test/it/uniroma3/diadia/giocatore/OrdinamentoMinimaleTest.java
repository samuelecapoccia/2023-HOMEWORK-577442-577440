package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class OrdinamentoMinimaleTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzo1 = new Attrezzo("A", 3);
		this.attrezzo2 = new Attrezzo("B", 5);
		this.borsa.addAttrezzo(this.attrezzo1);
		this.borsa.addAttrezzo(this.attrezzo2);
	}

	@Test
	void testGetContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> ordinato = this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = ordinato.iterator();
		assertTrue(it.next().equals(this.attrezzo1)&& it.next().equals(this.attrezzo2));
	}
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinata = this.borsa.getContenutoOrdinatoPerPeso();
		assertTrue(ordinata.get(0).equals(attrezzo1) && ordinata.get(1).equals(attrezzo2));
	}
	
	@Test
	void testGetSortedSetOrdinatoPerPeso() {
		Set<Attrezzo> set = new TreeSet<>(new ComparatoreAttrezziPesoNome());
		set.add(attrezzo1);
		set.add(attrezzo2);
		assertArrayEquals(set.toArray(), borsa.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPesoDuePesiDiversi() {
		Map<Integer, Set<Attrezzo>> map = this.borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Attrezzo> it = map.get(0).iterator();
		assertTrue(it.hasNext());
		assertEquals(it.next(),this.attrezzo1);
		it = map.get(2).iterator();
		assertEquals(it.next(), this.attrezzo2);
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPesoDuePesiUguali() {
		this.borsa.removeAttrezzo("A");
		this.attrezzo1 = new Attrezzo("A", 5);
		this.borsa.addAttrezzo(attrezzo1);
		Map<Integer, Set<Attrezzo>> map = this.borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Attrezzo> it = map.get(1).iterator();
		assertTrue(it.next().equals(attrezzo1) && it.next().equals(attrezzo2));
	}
	

}
