package SankaSkepp;

import java.util.*;

import java.io.*;

public class Main {
	static int size = 10;
	static String source = "defaultFleet.txt";
	static int computerSkill = 0;
	static ArrayList<String> highscore = new ArrayList<String>();
	static int antalSpelare = 2; // standard två männskliga spelare

	public static void main(String[] args) {
		LinkedList<Skepp> skeppar=null;
		int storlek = 0;
		String namn = null;
	//	Skepp skepp = new Skepp(storlek, namn);
		Spelare spelare = new Spelare(storlek, namn);
		Spelare spelare2 = spelare;
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
						System.out.println();
						System.out.println("Highscore!");
						System.out.println("Namn:Antal rundor");
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							String[] split = line.split(",");

							for (int i = 0; i < split.length; i++) {
								System.out.println(split[i]);
							}

						}
						br.close();
					} catch (IOException e) {
						System.out.println("Hittade ingen fil");
					}
					break;
				case 3: 
					if(antalSpelare==2) {
						spelaSpel();
					}else if(antalSpelare==1) {
						spelaSpelPvE();
					}else {
						spelaSpelEvE();
					}
					break;
				case 4:
					System.out.println("Ange antal mänskliga spelare: ");
					try {
						Scanner intScan = new Scanner(System.in);
						antalSpelare = intScan.nextInt();
						if (antalSpelare > 2) {
							System.out.println("Kan inte ha fler än 2 spelare");
							antalSpelare = 2;
						} else if (antalSpelare < 0) {
							System.out.println("Kan inte ha negativt antal");
							antalSpelare = 0;
						}
					} catch (InputMismatchException error) {
						System.out.println("Ange giltig siffra");
					}

					break;
				case 5: 
					PrintWriter pw = null;
					try {
						pw = new PrintWriter("highscore.txt");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pw.close();
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
		int runda = 1;
		int nummer = 1;
		String namn = null;
		Spelare spelare1 = new Spelare(nummer,namn);
		Spelare spelare2 = new Spelare(nummer, namn);
		System.out.println("Skapa spelets båtar, max storleken är 10");
		spelare1.skapaSkepp();
		spelare2.kopieraSkepp2(spelare1.kopieraSkepp());
		spelare1.setLiv(spelare1.spelareLiv());
		spelare1.setNamn(spelare1.skapaNamn(nummer));
		nummer++;
		spelare2.setLiv(spelare2.spelareLiv());
		spelare2.setNamn(spelare2.skapaNamn(nummer));
		spelare1.newBoard();
		spelare1.newEnemyBoard();
		
		System.out.println("Nu ska "+ spelare1.getNamn() + " placera sina båtar");
		spelare1.placeraSkepp();
				
		spelare2.newBoard();
		spelare2.newEnemyBoard();
		System.out.println("Nu ska " + spelare2.getNamn()+ " placera sina båtar");
		spelare2.placeraSkepp();
		
		System.out.println("LIIIIIV" + spelare1.getLiv() + "Spelare 2liiiiiiiiv" + spelare2.getLiv());
		
		
		
		while ((spelare1.getLiv()!=0) && (spelare2.getLiv() !=0)){
			int x = 0;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Det är " + spelare1.getNamn() +  " tur att skjuta");
			System.out.println(spelare1.getNamn() + "s bräde! ");
			spelare1.printBoard();
			spelare2.printEnemyBoard();
			x = spelare2.skjutKoordinat();
			spelare2.setLiv(spelare2.getLiv()-x);
			System.out.println("\n");
			
			System.out.println("\n\n\n\n\n\n\n\n\n\\n\n\n\n");
			System.out.println("Det är " + spelare2.getNamn() +" tur att skjuta");
			System.out.println(spelare2.getNamn() + "s bräde! ");
			spelare2.printBoard();
			spelare1.printEnemyBoard();
			x = spelare1.skjutKoordinat();
			spelare1.setLiv(spelare1.getLiv()-x);
			System.out.println("\n");
			
			System.out.println("Spealare 1 liv = " + spelare1.getLiv() + "Spelare 2 liv = " + spelare2.getLiv());
		}
		
	}
	
	public static void spelaSpelPvE() {
		int nummer = 1;
		int liv = 0;
		int runda = 1;
		String namn = null;
		Spelare spelare1 = new Spelare(nummer,namn);
		Spelare spelare2 = new Spelare(nummer, namn);
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
		System.out.println("Nu ska spelare 1 placera sina båtar! : ");
		spelare1.placeraSkepp();


		spelare2.newBoard();
		spelare2.newEnemyBoard();
		System.out.println("Nu ska " + spelare2.getNamn() + " placera sina båtar");
		spelare2.placeraSkepp2();

		while ((spelare1.getLiv() !=0) && (spelare2.getLiv() != 0)) {
			int x = 0;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Det är " + spelare1.getNamn() +  " tur att skjuta");
			System.out.println(spelare1.getNamn() + "s bräde! ");
			spelare1.printBoard();
			spelare2.printEnemyBoard();
			x = spelare2.skjutKoordinat();
			spelare2.setLiv(spelare2.getLiv()-x);
			System.out.println("\n");
			
			System.out.println("\n\n\n\n\n\n\n\n\n\\n\n\n\n");

			System.out.println("Det är " + spelare2.getNamn() + " tur att skjuta");
			System.out.println(spelare2.getNamn() + "s bräde!");
			spelare2.printBoard();
			spelare1.printEnemyBoard();
			x = spelare1.skjutKoordinat2();
			spelare1.setLiv(spelare1.getLiv() - x);
			System.out.println("\n");

			System.out.println();
			System.out.println("Statistik runda " + runda);
			// player1
			System.out.println();
			System.out.println(spelare1.getNamn());
			System.out.println("Träffsäkerhet: ");
			System.out.println("Förlustprocent: ");
			// player2
			System.out.println();
			System.out.println(spelare2.getNamn());
			System.out.println("Träffsäkerhet: " + runda);
			System.out.println("Förlustprocent: ");
			System.out.println();
			runda++;
		}

		String winner;
		if (spelare1.getLiv() == 0) {
			winner = spelare1.getNamn();

		} else {
			winner = spelare2.getNamn();
		}
		highscore.add(winner + ":" + runda);
		System.out.println(highscore);
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt", false)));
			writer.append(highscore + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("Hittade inte filen");
		}

		if (spelare1.getLiv() == 0) {
			System.out.println(spelare2.getNamn() + " vann!");
			System.out.println("Det tog " + runda + " rundor.");
		} else {
			System.out.println(spelare1.getNamn() + " vann!");
			System.out.println("Det tog " + runda + " rundor.");
		}
	}

	public static void spelaSpelEvE() {
		Scanner scan = new Scanner(System.in);
		int nummer = 1;
		int liv = 0;
		int runda = 1;
		String namn = null;
		System.out.println("Skapa spelets båtar, max storleken är 10");
		Spelare spelare1 = new Spelare(liv, namn);
		Spelare spelare2 = new Spelare(liv, namn);
		spelare1.skapaSkepp();
		spelare2.kopieraSkepp2(spelare1.kopieraSkepp());
		spelare1.setLiv(spelare1.spelareLiv());
		spelare1.setNamn("COM1");
		nummer++;
		
		spelare2.setLiv(spelare2.spelareLiv());
		spelare2.setNamn("COM2");
		spelare1.newBoard();
		spelare1.newEnemyBoard();
		System.out.println("Nu ska " + spelare1.getNamn() + " placera sina båtar");
		spelare1.placeraSkepp2();

		spelare2.newBoard();
		spelare2.newEnemyBoard();
		System.out.println("Nu ska " + spelare2.getNamn() + " placera sina båtar");
		spelare2.placeraSkepp2();
		
		System.out.println(spelare1.getLiv());
		System.out.println(spelare2.getLiv());
		String hej = scan.nextLine();


		while ((spelare1.getLiv() !=0) && (spelare2.getLiv() != 0)) {
			int x = 0;
			System.out.println("Det är " + spelare1.getNamn() + " tur att skjuta");
			System.out.println(spelare1.getNamn() + "s bräde! ");
			spelare1.printBoard();
			spelare2.printEnemyBoard();
			x = spelare2.skjutKoordinat2();
			spelare2.setLiv(spelare2.getLiv()-x);
			System.out.println(x);
			System.out.println("\n");

			System.out.println("Det är " + spelare2.getNamn() + " tur att skjuta");
			System.out.println(spelare2.getNamn() + "s bräde!");
			spelare2.printBoard();
			spelare1.printEnemyBoard();
			x = spelare1.skjutKoordinat2();
			spelare1.setLiv(spelare1.getLiv()-x);
			System.out.println(x);
			
			System.out.println("SPELARE 1 LIV RUNDA : " + runda +" = " + spelare1.getLiv());
			System.out.println("SPELARE 2 LIV RUNDA : " + runda +" = " +  spelare2.getLiv());
			System.out.println();
			System.out.println("Statistik runda " + runda);
			// player1
			System.out.println();
			System.out.println(spelare1.getNamn());
			System.out.println("Träffsäkerhet: ");
			System.out.println("Förlustprocent: ");
			// player2
			System.out.println();
			System.out.println(spelare2.getNamn());
			System.out.println("Träffsäkerhet: " + runda);
			System.out.println("Förlustprocent: ");
			System.out.println();
			runda++;
			String hej2 = scan.nextLine();
		}

		String winner;
		if (spelare1.getLiv() == 0) {
			winner = spelare1.getNamn();

		} else {
			winner = spelare2.getNamn();
		}
		highscore.add(winner + ":" + runda);
		System.out.println(highscore);
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt", false)));
			writer.append(highscore + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("Hittade inte filen");
		}

		if (spelare1.getLiv() == 0) {
			System.out.println(spelare2.getNamn() + " vann!");
			System.out.println("Det tog " + runda + " rundor.");
		} else {
			System.out.println(spelare1.getNamn() + " vann!");
			System.out.println("Det tog " + runda + " rundor.");
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