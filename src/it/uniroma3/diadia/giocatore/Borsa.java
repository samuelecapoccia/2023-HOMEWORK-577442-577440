package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}


	public int getPesoMax() {
		return this.pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}


	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi.values())
			if(a==null)
				return peso;
			else
				peso += a.getPeso();
		return peso;
	}


	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo))
			return this.attrezzi.remove(nomeAttrezzo);
		else
			return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			List<Attrezzo> listaOrdinata = this.getContenutoOrdinatoPerPeso();
			for (Attrezzo a : listaOrdinata)
				s.append(a.toString()+" ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	} 

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ordinata = new ArrayList<>();
		ordinata.addAll(this.attrezzi.values());
		Collections.sort(ordinata, new ComparatoreAttrezziPesoNome());
		return ordinata;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> ordinato = new TreeSet<>(new ComparatoreAttrezziPesoNome());
		ordinato.addAll(this.attrezzi.values());
		return ordinato;
	}


	/*public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		boolean trovato = false;
		for(Attrezzo a: this.attrezzi.values()) {
			trovato = false;
			for(int peso: map.keySet()) {
				if(a.getPeso() == peso) {
					map.get(peso).add(a);
					trovato = true;
				}
			}
			if(!trovato) {
				map.put(a.getPeso(), new TreeSet<Attrezzo>());
				map.get(a.getPeso()).add(a);
			}
		}
		return map;

	}*/
	
	/*public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> map = new HashMap<>();

	    for (Attrezzo a : this.attrezzi.values()) {
	        int peso = a.getPeso();
	        Set<Attrezzo> attrezziConLoStessoPeso = map.getOrDefault(peso, new TreeSet<>());
	        attrezziConLoStessoPeso.add(a);
	        map.put(peso, attrezziConLoStessoPeso);
	    }

	    return map;
	}*/
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> map = new HashMap<>();
	    for (Attrezzo a : this.attrezzi.values()) {
	        int peso = a.getPeso();
	        if (map.containsKey(peso)) {
	            map.get(peso).add(a);
	        } else {
	            Set<Attrezzo> set = new TreeSet<>();
	            set.add(a);
	            map.put(peso, set);
	        }
	    }
	    return map;
	}



}
