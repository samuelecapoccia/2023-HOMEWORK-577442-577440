package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzione) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(direzioneBloccata.equals(dir) && !this.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(dir);
	}

	@Override
	public String getDescrizione() {
		String descrizioneBloccata = new String("Questa stanza è bloccata andando verso: "+direzioneBloccata+". \nPer accedervi hai bisogno dell'attrezzo: "
				+ attrezzoSbloccante+". Prendilo e posalo in questa stanza!");
		if(!this.hasAttrezzo(attrezzoSbloccante)) 
			return descrizioneBloccata;

		return super.getDescrizione();
	}

}
