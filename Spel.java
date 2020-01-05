package SankaSkepp;

import java.util.LinkedList;
import java.util.Scanner;

public class Spel {
	public LinkedList<Spelare> spelarLista = new LinkedList<Spelare>();
	public LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	public LinkedList<Skepp> skeppar2 = new LinkedList<Skepp>();
	Scanner scan = new Scanner(System.in);

	public Spel() {

	}

	public void startaSpel() {
		System.out.println("Hur många spelare vill du ha?");
		int antalSpelare = scan.nextInt();
		if (antalSpelare == 0) {
			spelaSpelEvE(antalSpelare);
		}
		if (antalSpelare == 1) {
			spelaSpelPvE(antalSpelare);
		}
		if (antalSpelare > 1) {
			spelaSpel(antalSpelare);
		}

	}

	public void spelaSpel(int antalSpelare) {
		System.out.println(antalSpelare);
		nySpelare(antalSpelare);
		System.out.println(spelarLista.size());

		boolean c = false;
		boolean d = false;

		int i = 0;
		int skepp2 = 1;
		while (c == false) {
			for (i = 0; i < antalSpelare; i++) {
				if (i == antalSpelare) {
					i = 0;
				}
				System.out.println(skepp2);
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}
				int x = 0;

				System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
				System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

				spelarLista.get(i).printBoard();
				spelarLista.get(skepp2).printEnemyBoard();
				x = spelarLista.get(skepp2).skjutKoordinat();
				spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
				System.out.println("\n");
				System.out.println(spelarLista.get(skepp2).getLiv());

				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;

				}

				skepp2 = skepp2 + 1;
				continue;
			}

			System.out.println("Runda avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println(spelarLista);
			i = 0;
			skepp2 = 1;

			if (antalSpelare == 1) {
				System.out.println(spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!!");
				break;
			}

		}

	}

	public boolean fleraSpelare(Spelare obj) {

		if (obj.getLiv() == 0) {
			System.out.println(obj.getNamn() + " är död!");
			return true;
		} else {
			return false;
		}
	}
	

	public  void spelaSpelPvE(int antalSpelare) {
		nySpelare(antalSpelare);
		int botAntal = nyBot();
		antalSpelare = antalSpelare + botAntal;
		boolean c = false;
		int i = 0;
		int skepp2 = 1;
		while (c == false) {
			for (i = 0; i < antalSpelare; i++) {
				int x = 0;
				
				if (i == antalSpelare) {	
					i = 0;
				}
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}
				if (i==0) {
					System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
					System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

					spelarLista.get(i).printBoard();
					spelarLista.get(skepp2).printEnemyBoard();
					x = spelarLista.get(skepp2).skjutKoordinat();
					spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
					System.out.println("\n");
					System.out.println(spelarLista.get(skepp2).getLiv());
				}
				
				
				if (i==1) {
					System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
					System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

					spelarLista.get(i).printBoard();
					spelarLista.get(skepp2).printEnemyBoard();
					x = spelarLista.get(skepp2).skjutKoordinat2();
					spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
					System.out.println("\n");
					System.out.println(spelarLista.get(skepp2).getLiv());
				}		

				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;
				}

				skepp2 = skepp2 + 1;
				continue;
			}

			System.out.println("Runda avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println(spelarLista);
			i = 0;
			skepp2 = 1;

			if (antalSpelare == 1) {
				System.out.println(spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!!");
				break;
			}

		}
	}

	public void spelaSpelEvE(int antalSpelare) {
		Scanner scan = new Scanner(System.in);
		int botAntal = nyBot();
		int botAntal2 = nyBot();
		botAntal = botAntal + botAntal2;
		antalSpelare = botAntal;
		boolean c = false;
		int i = 0;
		int skepp2 = 1;
		int runda = 1;
		int maxRunda = 100;
		while ((c == false) && (runda<maxRunda)) {
			for (i = 0; i < antalSpelare; i++) {
				int x = 0;
				
				if (i == antalSpelare) {	
					i = 0;
				}
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}
				
				System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
				System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

				spelarLista.get(i).printBoard();
				spelarLista.get(skepp2).printEnemyBoard();
				x = spelarLista.get(skepp2).skjutKoordinat2();
				spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
				System.out.println("\n");
				System.out.println(spelarLista.get(skepp2).getLiv());
				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;
				}
				
				skepp2 = skepp2 + 1;
				continue;
			}
			runda++;
			System.out.println("Runda "+ runda+" avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println(spelarLista);
			i = 0;
			skepp2 = 1;

			if (antalSpelare == 1) {
				System.out.println(spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!! Det tog " + runda + " rundor!");
			
				break;
			}

		}

	}
	public int nyBot() {
		String namn = "COM1";
		int liv = 0;
		Spelare spelare = new Spelare(liv, namn);
		spelare.newBoard();
		spelare.newEnemyBoard();
		if (spelarLista.isEmpty()) {
			spelare.skapaSkepp();
		}
		else {
			for (Spelare obj : spelarLista) {
				spelare.kopieraSkepp2(obj.kopieraSkepp());
			}
		}

		spelarLista.add(spelare);
		spelare.setLiv(spelare.spelareLiv());
		spelare.placeraSkepp2();
		return 1;
		
	}
	
	public void nySpelare(int spelarNummer) {		
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i<=spelarNummer; i++) {
			System.out.println("Välj namn spelare "+i+"!");
			String namn = scan.nextLine();
			int liv = 0;
			Spelare spelare = new Spelare(liv,namn);
			spelare.newBoard();
			spelare.newEnemyBoard();
			if (spelarLista.isEmpty()) {
				spelare.skapaSkepp();
			}
			else {
				for (Spelare obj : spelarLista) {
					spelare.kopieraSkepp2(obj.kopieraSkepp());
				}
			}
			spelarLista.add(spelare);
			spelare.setLiv(spelare.spelareLiv());
			spelare.placeraSkepp();
		}
	}
}
