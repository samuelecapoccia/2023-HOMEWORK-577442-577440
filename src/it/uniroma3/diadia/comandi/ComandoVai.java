package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	private final static String NOME_COMANDO = "Comando Vai";
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente= partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.getParametro()==null){
			this.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione!");
			return;
		}

		prossimaStanza =stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));

		if(prossimaStanza==null) {
			this.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getNome());
	}

	@Override
	public String getNome() {
		return NOME_COMANDO;
	}

}
