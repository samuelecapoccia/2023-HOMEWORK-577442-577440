package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita,IO io) {
		Stanza stanzaCorrente= partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.direzione==null){
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione!");
			return;
		}

		prossimaStanza =stanzaCorrente.getStanzaAdiacente(this.direzione);

		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
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
