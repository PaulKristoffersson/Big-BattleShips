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
			spelaSpelEvE();
		}
		if (antalSpelare == 1) {
			spelaSpelPvE();
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
	

	public  void spelaSpelPvE() {
		int nummer = 1;
		int liv = 0;
		System.out.println("Skapa spelets båtar, max storleken är 10");
		spelare1.skapaSkepp();
		spelare2.kopieraSkepp2(spelare1.kopieraSkepp());
		spelare1.setLiv(spelare1.spelareLiv());
		spelare1.setNamn(spelare1.skapaNamn(nummer));
		nummer++;
		spelare2.setLiv(spelare2.spelareLiv());
		spelare2.setNamn("COM1");
		spelare1.newBoard();
		spelare1.newEnemyBoard();

		// spelare 1
		System.out.println("Nu ska " + spelare1.getNamn() + " placera sina båtar");
		spelare1.placeraSkepp();
		spelare2.newBoard();
		spelare2.newEnemyBoard();
		System.out.println("Nu ska " + spelare2.getNamn() + " placera sina båtar");
		spelare2.placeraSkepp2();

		while ((spelare1.getLiv() != 0) && (spelare2.getLiv() != 0)) {
			int x = 0;
			// spelare 1
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Det är " + spelare1.getNamn() + " tur att skjuta");
			System.out.println(spelare1.getNamn() + "s bräde! ");
			spelare1.printBoard();
			spelare2.printEnemyBoard();
			x = spelare2.skjutKoordinat();
			spelare2.setLiv(spelare2.getLiv() - x);
			System.out.println("\n");

			// spelare 2
			System.out.println("\n\n\n\n\n\n\n\n\n\\n\n\n\n");
			System.out.println("Det är " + spelare2.getNamn() + " tur att skjuta");
			System.out.println(spelare2.getNamn() + "s bräde!");
			spelare2.printBoard();
			spelare1.printEnemyBoard();
			x = spelare1.skjutKoordinat2();
			spelare1.setLiv(spelare1.getLiv() - x);
			System.out.println("\n");

			statistik();
			runda++;
		}

		highscore();
	}

	public void spelaSpelEvE() {
		Scanner scan = new Scanner(System.in);
		int nummer = 1;
		int maxrunda = 100;
		System.out.println("Skapa spelets båtar, max storleken är 10");
		for (Spelare obj : spelarLista) {
			
		
		while ((spelare1.getLiv() != 0) && (spelare2.getLiv() != 0) && (runda < maxrunda)) {
			int x = 0;
			// spelare1
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Det är " + spelare1.getNamn() + " tur att skjuta");
			System.out.println(spelare1.getNamn() + "s bräde! ");
			spelare1.printBoard();
			spelare2.printEnemyBoard();
			x = spelare2.skjutKoordinat2();
			spelare2.setLiv(spelare2.getLiv() - x);
			System.out.println("\n");
			// spelare2
			System.out.println("\n\n\n\n\n\n\n\n\n\\n\n\n\n");
			System.out.println("Det är " + spelare2.getNamn() + " tur att skjuta");
			System.out.println(spelare2.getNamn() + "s bräde! ");
			spelare2.printBoard();
			spelare1.printEnemyBoard();
			x = spelare1.skjutKoordinat2();
			spelare1.setLiv(spelare1.getLiv() - x);
			System.out.println("\n");

			statistik();

			runda++;
		}
	}

		highscore();

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
