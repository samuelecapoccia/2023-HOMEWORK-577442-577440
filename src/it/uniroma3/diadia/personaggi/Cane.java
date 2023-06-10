package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_MORSO = "BAU!";
	
	private static final String MESSAGGIO_CIBO = "Bau, **scodinzola**. Il cane ti ha lasciato l'osso come segno di gratitudine!";
	
	private static final String MESSAGGIO_OGGETTO = "è sembrato molto infastidito...Prova a portargli della carne!";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		Attrezzo ciboPreferito = new Attrezzo("carne", 2);
		Attrezzo osso = new Attrezzo("osso", 1);
		if(attrezzo.getNome().equals(ciboPreferito.getNome()) && attrezzo.getPeso() == ciboPreferito.getPeso()) {
			partita.getStanzaCorrente().addAttrezzo(osso);
			return MESSAGGIO_CIBO;
		}
		else {
			partita.getStanzaCorrente().getPersonaggio().agisci(partita);
			return MESSAGGIO_OGGETTO;
		}
	}
	
}
