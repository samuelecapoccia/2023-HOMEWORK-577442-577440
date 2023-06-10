package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	private IO io;
	
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando"; 
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0)); 
			nomeClasse += nomeComando.substring(1);
			comando = (Comando)Class.forName(nomeClasse).newInstance(); 
			comando.setParametro(parametro);
			comando.setIo(io);
		} catch (Exception e) {
			comando = new ComandoNonValido();
		}
		return comando;
	}
}
