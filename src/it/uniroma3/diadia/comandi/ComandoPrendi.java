package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		else {

			if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				io.mostraMessaggio("In questa stanza non c'è questo attrezzo!");
			}
			else {
				Attrezzo att = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				
				if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() > partita.getGiocatore().getBorsa().getPesoMax())
					io.mostraMessaggio("Capienza nella borsa terminata, l'attrezzo pesa troppo!");
				else {
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(att);
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				io.mostraMessaggio("L'attrezzo è stato posto nella borsa!");
				}
			}
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public String getParametro() {
		return null;
	}
}
