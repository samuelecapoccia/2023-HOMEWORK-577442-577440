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
	//private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
		//this.numeroAttrezzi = 0;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		//if (this.numeroAttrezzi==10)
		//return false;

		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}


	public int getPesoMax() {
		return this.pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		/*Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i]==null)
				return a;
			else if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a; */

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
		/*Attrezzo a = null;
		int i=0;
		while(i<this.numeroAttrezzi && a==null) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = this.attrezzi[i];
				this.attrezzi[i]=null; 
				this.attrezzi[i] = this.attrezzi[i+1];
				this.numeroAttrezzi--;
			}
			i++;
		}

		return a; */
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


	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
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

	}

}
