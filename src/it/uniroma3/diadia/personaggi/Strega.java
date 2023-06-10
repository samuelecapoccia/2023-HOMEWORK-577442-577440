package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_CATTIVO = "Hahahahahahahahahahahahahahahaha";

	private static final String MESSAGGIO_BUONO = "Ti amo";
	
	private static final String MESSAGGIO_REGALO = "Ti sembro una persona da regali? Muhahahahahahahahahahahahahahaha!";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {

		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s!=null) {
				if(s.getAttrezzi().size() > maxAttrezzi.getAttrezzi().size())
					maxAttrezzi = s;
				if(s.getAttrezzi().size() < minAttrezzi.getAttrezzi().size())
					minAttrezzi = s;
			}
		}

		if(haSalutato) {
			partita.setStanzaCorrente(maxAttrezzi);
			return MESSAGGIO_BUONO;
		}
		else {
			partita.setStanzaCorrente(minAttrezzi);
			return MESSAGGIO_CATTIVO;
		}

	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_REGALO;
	}
}
