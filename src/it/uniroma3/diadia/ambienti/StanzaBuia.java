package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String illuminazione;

	public StanzaBuia(String nome, String illuminazione) {
		super(nome);
		this.illuminazione = illuminazione;
	}
	
	@Override
	public String getDescrizione() {
		String descrizioneBuia = new String("Qui c'è un buio pesto!");
		if(!this.hasAttrezzo(illuminazione))
			return descrizioneBuia;
		return super.getDescrizione(); 
	}

}
