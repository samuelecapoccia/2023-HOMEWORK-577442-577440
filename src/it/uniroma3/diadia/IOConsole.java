package it.uniroma3.diadia;
import java.util.Scanner;


public class IOConsole implements IO{
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in); 
		String riga = scannerDiLinee.nextLine(); 
		//scannerDiLinee.close();
		return riga;
	}
}

