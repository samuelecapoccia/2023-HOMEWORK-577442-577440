package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{
	
	private String nomeAttrezzo;
	private final static String NOME_COMANDO = "Comando Posa";
	

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null)
			this.getIo().mostraMessaggio("Quale attrezzo vuoi posare?");
		else {

			if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				this.getIo().mostraMessaggio("Nella borsa non c'è questo attrezzo!");
			}
			else {
				Attrezzo att = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getStanzaCorrente().addAttrezzo(att);
				this.getIo().mostraMessaggio("L'oggetto è stato rimesso nella stanza e rimosso dalla borsa!");
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
