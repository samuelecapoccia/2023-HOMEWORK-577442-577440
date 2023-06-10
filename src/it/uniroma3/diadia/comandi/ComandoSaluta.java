package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	
	private static final String MESSAGGIO_CON_CHI = "Chi dovrei salutare?...";
	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			this.messaggio = personaggio.saluta();
			this.getIo().mostraMessaggio(messaggio);
		}
		else
			this.getIo().mostraMessaggio(MESSAGGIO_CON_CHI);	
	}
	
}
