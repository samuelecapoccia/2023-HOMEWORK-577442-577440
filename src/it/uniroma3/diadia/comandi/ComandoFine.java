package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	
	private final static String NOME_COMANDO = "Comando Fine";
	final static String MESSAGGIO_FINALE = "Grazie di aver giocato!";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(MESSAGGIO_FINALE);  // si desidera smettere
		
	}

	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
