package SankaSkepp;

import java.util.*;

import java.io.*;

public class Main {
	static int size = 10;
	static String source = "defaultFleet.txt";
	static int antalSpelare = 0;
	static int computerSkill = 0;
	

	public static void main(String[] args) {
		int storlek = 0;
		String namn = null;
	//	Skepp skepp = new Skepp(storlek, namn);
		Spelare spelare = new Spelare(storlek, namn);
		int result = 0;
		while (!(result == -1)) {
			printMenu();
			try {
				Scanner scan = new Scanner(System.in);
				int val = scan.nextInt();
				switch (val) {
				case 1:
					break;
				case 2:
					try {
						BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
						// String line = br.readLine();

						// br.close();
						System.out.println(br.readLine());
						System.out.println(br.readLine());
					} catch (IOException e) {
						System.out.println("Hittade ingen fil");
					}

					break;
				case 3: 
					spelaSpel();
					break;
				case 4:
			//		Spelare spelare = new Spelare();
					spelare.skapaSkepp();

				//	spelare.printSkepp();
					
				//	System.out.println(skepp.get(0));
					break;
				case 0:
					System.exit(0);
					break;

				default:
					System.out.println("Ange rätt siffra!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Ange siffra!");
			}
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void spelaSpel() {
		int nummer = 1;
		int liv = 0;
		String namn = null;
		Spelare spelare1 = new Spelare(liv, namn);
		spelare1.setLiv(spelare1.spelareLiv());
		spelare1.setNamn(spelare1.skapaNamn(nummer));
		nummer++;
		Spelare spelare2 = new Spelare(liv, namn);
		spelare2.setLiv(spelare2.spelareLiv());
		spelare2.setNamn(spelare2.skapaNamn(nummer));
		spelare1.newBoard();
		spelare1.newEnemyBoard();
		spelare1.printSkepp();
		System.out.println("Nu ska "+ spelare1.getNamn() + " placera sina båtar");
		System.out.println(spelare1.getLiv());
		spelare1.placeraSkepp();
		spelare1.printSkepp();
				
		spelare2.newBoard();
		spelare2.newEnemyBoard();
		System.out.println("Nu ska " + spelare2.getNamn()+ " placera sina båtar");
		spelare2.placeraSkepp();
		
		while (spelare1.getLiv()!=0 && spelare2.getLiv()!=0){
			int x = 0;
			System.out.println("Det är " + spelare1.getNamn() +  " tur att skjuta");
			x = spelare2.skjutKoordinat();
			System.out.println(x);
			spelare2.setLiv(spelare2.getLiv()-x);
			System.out.println("\n");
			System.out.println(spelare2.getLiv());
			spelare1.printBoard();

			System.out.println("Det är " + spelare2.getNamn() +" tur att skjuta");
			x = spelare1.skjutKoordinat();
			spelare1.setLiv(spelare1.getLiv()-1);
			System.out.println("\n");
			spelare2.printBoard();
		}
		
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("Välkommen till Sänka Skepp!");
		System.out.println("===========================");
		System.out.println("Skapad av Martin och Paul");
		System.out.println("===========================");
		System.out.println("Meny:");
		// System.out.println("1. Ändra storlek på spelplan. Nuvarande: " + size);
		// System.out.println("2. Ändra antal mänskliga spelare. Nuvarande: "+
		// nofHumanPlayers);
		// System.out.println("3. Välj flotta. Nuvarande:" + source);
		System.out.println("1. Lista skepp i flottan");
		System.out.println("2. Se highscore");
		System.out.println("3. Starta spelet!");
		System.out.println("4. Skapa en egen flotta ");
		System.out.println("0. Avsluta");
		// System.out.println("Ange ditt val som ett heltal, bekräfta med enter:");
	}

}