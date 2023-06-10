package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	private String nomeAttrezzo;
	private final static String NOME_COMANDO = "Comando Prendi";

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null)
			this.getIo().mostraMessaggio("Quale attrezzo vuoi prendere?");
		else {

			if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				this.getIo().mostraMessaggio("In questa stanza non c'è questo attrezzo!");
			}
			else {
				Attrezzo att = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				
				if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() > partita.getGiocatore().getBorsa().getPesoMax())
					this.getIo().mostraMessaggio("Capienza nella borsa terminata, l'attrezzo pesa troppo!");
				else {
				partita.getStanzaCorrente().removeAttrezzo(att);
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				this.getIo().mostraMessaggio("L'attrezzo è stato posto nella borsa!");
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
		return NOME_COMANDO;
	}
}
