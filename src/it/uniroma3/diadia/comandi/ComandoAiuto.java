package it.uniroma3.diadia.comandi;




import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0;i< elencoComandi.length; i++) 
		io.mostraMessaggio(elencoComandi[i]+" ");
		
	}

	@Override
	public void setParametro(String parametro) {
		
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

