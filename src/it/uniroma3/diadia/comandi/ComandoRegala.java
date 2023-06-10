package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.getParametro())) {
			Attrezzo regalo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			this.getIo().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(regalo, partita));
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
		}
		else
			this.getIo().mostraMessaggio("L'attrezzo non è presente nella borsa!");
	}

}
