package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	private final static String NOME_COMANDO = "Comando Aiuto";

	
	@Override
	public void esegui(Partita partita) {
		for(int i=0;i< elencoComandi.length; i++) 
		this.getIo().mostraMessaggio(elencoComandi[i]+" ");
		this.getIo().mostraMessaggio("");
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}

}

