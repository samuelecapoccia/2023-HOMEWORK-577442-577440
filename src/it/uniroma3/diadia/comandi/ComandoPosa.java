package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
		else {

			if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				io.mostraMessaggio("Nella borsa non c'è questo attrezzo!");
			}
			else {
				Attrezzo att = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getStanzaCorrente().addAttrezzo(att);
				io.mostraMessaggio("L'oggetto è stato rimesso nella stanza e rimosso dalla borsa!");
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
