package SankaSkepp;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Spelare {
	private int lengd = 0;
	private String namn = null;
	private int storlek = 10;
	private int index = 0;
	private int liv = 0;
	private int spelare1Liv = 0;
	private int spelare2Liv = 0;
	LinkedList <Koordinater> båtKoordinater = new LinkedList<Koordinater>();
	Skepp skepp = new Skepp(lengd, namn,båtKoordinater);
	LinkedList<Koordinater> skeppKoordinater = new LinkedList<Koordinater>();
	LinkedList<Koordinater> träffadeKoordinater = new LinkedList<Koordinater>();
	private static LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	private static LinkedList<Spelare> spelare = new LinkedList<Spelare>();
	Spelplan plan = new Spelplan();
	Scanner scan = new Scanner(System.in);
	LinkedHashMap<Koordinater, Bitar> map = new LinkedHashMap<Koordinater, Bitar>();
	LinkedHashMap<Koordinater, Bitar> map2 = new LinkedHashMap<Koordinater, Bitar>();
	
	public Spelare(int liv, String namn) {
		this.liv = liv;
		this.namn = namn;
	}
	
	
	public String skapaNamn(int x) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Döp spelare " + x);
		String namn = scan.nextLine();
		return namn;
	}
	
	public int spelareLiv() {
		int liv = 0;
		for (Skepp obj : skeppar) {
			liv = liv + obj.getStorlek();
		}
		return liv;
	}
	
	/*public int spelareLiv(int c) {
		return c;
	}
	
	public boolean leverSpelare(int c) {
		if ( c !=0) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public int getLiv() {
		return liv;
	}

	public void setLiv(int liv) {
		this.liv = liv;
	}

	public void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}
	
	public static void addSkepp(Skepp c) {
		skeppar.add(c);
//		index++;
	}
	
	public void skapaSkepp() {
		Skepp skepp = new Skepp(lengd, namn,båtKoordinater);
		System.out.println("Här skapar du fler skepp!");
		System.out.println("Här kan du skapa ett skepp. Vilken storlek vill du ha?");
		int storlek2 = scan.nextInt();
		skepp.setStorlek(storlek2);
		//spelareLiv(storlek2);
		scan.nextLine();
		System.out.println("Vad ska skeppet heta?");
		String namn2 = scan.nextLine();
		skepp.setNamn(namn2);
		Spelare.addSkepp(skepp);
		printSkepp();
	}	
	
	public String toString() {
		return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
	}
	
	public void printBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}
	
	public Bitar lookup(Koordinater nyckel) {
		return map.get(nyckel);
	}

	public void newBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
		// printBoard();
	}
	
	public void newEnemyBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map2.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
	}
	
	public void printEnemyBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map2.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map2.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}

	public boolean riktning() {
		System.out.println("Ange h för horisontellt eller v för vertikalt: ");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		if (val.equals("h")) {
			return true;
		}else {
			return false;
		}
	}
	
	/*public void markeraSkott() {
		Scanner scan = new Scanner(System.in);
		String koordinater = scan.nextLine();
		skjutSkepp(koordinater);
		while (skjutSkepp(koordinater)!=true) {
			System.out.println("Du har redan skjutit här. Skriv en annan koordinat: ");
			koordinater = scan.nextLine();
			skjutSkepp(koordinater);
		}
		
		printBoard();
	}*/
	
	/*public void markeraSkott(boolean e) {
 
		if (e == true) {
			skjutSkepp();
		}
		printBoard();
	}*/
	
	/*public void skjutSkepp() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vart vill du skjuta? ");
        String koordinater = scan.nextLine();
        char yLed = koordinater.charAt(0);
        int xLed = koordinater.charAt(1)-48;
        
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        
        boolean miss1 = true;
        boolean hit1 = true;
        boolean redan = false;
        
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
        for (Koordinater nycklar : map.keySet()) {
            String kollaNyckel = "" + yLed + xLed;
            //System.out.println(kollaNyckel);
            if(kollaNyckel.equals(nycklar.toString())) {
            	Koordinater replaceCoords = new Koordinater(kollaNyckel);
            	
            	if(lookup(nycklar).toString().contains("#")) {
            		System.out.println("Du träffade!");
            		map.put(replaceCoords, boatpiece3);
            		boolean e = false;
            		markeraSkott(e);
            	}
            	else if(lookup(nycklar).toString().contains("~")) {
            		System.out.println("Du missade!");
            		map.put(replaceCoords, boatpiece2);
            		boolean e = false;
            		markeraSkott(e);
            	}
            	else {
            		System.out.println("Du har redan skjutit här");
            		boolean e = true;
            		markeraSkott(e);
            	}
            	
            	
            }
        }
        
       // printBoard();

    }*/
	

	
	public int markeraSkott(boolean c , boolean d, boolean e, Koordinater replaceCoords) {
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        int x = 0;
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
		if (c == true) {
			System.out.println("Du träffade!");
			map.put(replaceCoords, boatpiece3);
			map2.put(replaceCoords, boatpiece3);
			x = 1;

		}
		
		if (d == true) {
			System.out.println("Du missade!");
			map.put(replaceCoords, boatpiece2);
			map2.put(replaceCoords, boatpiece2);
			x = 0;

		}
		
		if (e == true) {
			System.out.println("Du har redan skjutit här. Skjut igen");
			String koordinater = scan.nextLine();
			skjutSkepp(koordinater);
			x = 0;

		}
		
		printEnemyBoard();
		return x;
	}
	
	public int skjutKoordinat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ange vart du vill skjuta");
		String koordinat = scan.nextLine();
		int x = skjutSkepp(koordinat);
		return x;
	}
	
	public boolean slaktatSkepp() {
		if (skeppKoordinater.equals(träffadeKoordinater)) {
			return true;
		}
		else {
			return false;
		}
			
		/*for (Koordinater obj : skeppKoordinater) {
			for (Koordinater obj2 : träffadeKoordinater) {
				
				if (obj.equals(null)) {
					x = true;
				} else {
					x = false;
				}
			}
		}*/
	}
	
	public void kollaSkepp(String kollaNyckel) {
		String namn = "yo";
		for(Koordinater obj : skeppKoordinater) {
			//if(yLed== obj.toString().charAt(0) && xLed == obj.toString().charAt(1)) {
			if (kollaNyckel.equals(obj.toString())) {
				System.out.println("hejeheeheejhsaheahseh");
				System.out.println(obj);
				träffadeKoordinater.add(obj);
				System.out.println(skeppKoordinater);
				if (slaktatSkepp() == true ){
					System.out.println("båt " + skeppKoordinater.indexOf(obj) + " Är sänkt");
				}				
			}
		}
	}
	
	public int skjutSkepp(String koordinater) {
        char yLed = koordinater.charAt(0);
        int xLed = koordinater.charAt(1)-48;
        int x = 0;
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        
        boolean miss1 = true;
        boolean hit1 = true;
        boolean redan = false;
        
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
        for (Koordinater nycklar : map.keySet()) {
            String kollaNyckel = "" + yLed + xLed;
            //System.out.println(kollaNyckel);
            if(kollaNyckel.equals(nycklar.toString())) {
            	Koordinater replaceCoords = new Koordinater(kollaNyckel);
            	
            	if(lookup(nycklar).toString().contains("#")) {
            	//	System.out.println("Du träffade!");
            		//map.put(replaceCoords, boatpiece3);
            		boolean c = true;
            		boolean d = false;
            		boolean e = false;
            		x = markeraSkott(c,d,e, replaceCoords);
            		
            		kollaSkepp(kollaNyckel);
            		
            	}
            	else if(lookup(nycklar).toString().contains("~")) {
            		//map.put(replaceCoords, boatpiece2);
            		boolean c = false;
            		boolean d = true;
            		boolean e = false;
            		markeraSkott(c,d,e, replaceCoords);
            		x=0;
            	}
            	else {
            		boolean c = false;
            		boolean d = false;
            		boolean e = true;
            		markeraSkott(c,d,e, replaceCoords);
            		x =0;
            	}	
            }
        }
		return x;

        
        
       // printBoard();

    }

	public boolean kollaBoard(String koordinater, boolean val, int storlek) {

		char yLed = koordinater.charAt(0);
		char yBak = (char) (koordinater.charAt(0) - 1);
		char xLed = koordinater.charAt(1);
		char xBak = (char) (koordinater.charAt(1) - 1);
		
		if (koordinater.toString().charAt(0) == 'A') {
			yBak = 'A';
		}
		
		if (koordinater.toString().charAt(1) == '0') {
			xBak = '0';
		}
		
		if (val == true) {
			if (xLed + storlek -48 > 10) {
				System.out.println("Båten är för stor");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaYled = "" + yBak + xBak;
				System.out.println(kollaYled);
				if (kollaYled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Du har närliggande båtar. Båtarna måste ha minst 1 ruta emellan varandra");
						return false;
					}
					xBak++;
					if (xBak == storlek + 1 + xLed) {
						yBak++;
						for (int i = 0; i < storlek; i++) {
							xBak--;
						}
					}
				}
			}
		}

		else {
			if (storlek + yLed - 65 > 10) {
				System.out.println("Please place the boats on the board");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaXled = "" + yBak + xBak;

				if (kollaXled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Please place the boat further away from the other boats");
						return false;
					}

					xBak++;

					if (xBak == (char) (xLed + 2)) {
						yBak++;
						for (int i = 0; i < 3; i++) {
							if (xBak == '0') {
								break;
							}
							xBak--;
						}
					}

				}

				if (yBak == (char) (yLed + storlek + 1)) {
					break;
				}
			}

		}

		return true;

	}

	public void addBoat(String koordinater, boolean riktning, int storlek,Skepp obj,String namn) {
		LinkedList<Koordinater> båtKoordinater = new LinkedList<Koordinater>();
		char yLed = koordinater.charAt(0);
		int xLed = koordinater.charAt(1);
		char hashtag = '#';
		Bitar boatPiece = new Bitar(hashtag);
		
		if (riktning == true) { 
			int boatLength = storlek + xLed; 
				for(Koordinater nycklar : map.keySet()) {
				
					if (xLed == boatLength) {
						break;
					}
					
					String kollaNycklar = nycklar.toString();
					
					if((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
						Koordinater replaceCoords = new Koordinater(kollaNycklar);
						map.put(replaceCoords, boatPiece);
						skeppKoordinater.add(new Koordinater(kollaNycklar));
						båtKoordinater.add(new Koordinater(kollaNycklar));
						xLed++;
					}
					
					
					kollaNycklar = "";	
				}
			
		}else { 
			int lengthCounter = 0;
			
			for(Koordinater nycklar : map.keySet()) {
			
				if (storlek == lengthCounter) {
					break;
				}
				
				String kollaNycklar = nycklar.toString();
				
				if((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
					Koordinater replaceCoords = new Koordinater(kollaNycklar);
					map.put(replaceCoords, boatPiece);
					skeppKoordinater.add(new Koordinater(kollaNycklar));
					yLed++;
					lengthCounter++;
				}
				
				kollaNycklar = "";	
			}
		
		}
		skeppar.add(new Skepp(storlek,namn,båtKoordinater));
		System.out.println(skeppar);
		
		System.out.println(skeppKoordinater);
		
	}
	
	public void placeraSkepp(){
		printBoard();
		Scanner scan = new Scanner(System.in);
		for(Skepp obj: skeppar) {
			System.out.println("Vart vill du placera " + obj.getNamn() + "?");
			String koordinat = scan.nextLine();
			boolean riktning = riktning();
			while (kollaBoard(koordinat, riktning,obj.getStorlek())!=true) {
				System.out.println("Placera om " + obj.getNamn());
				koordinat = scan.nextLine();
				riktning = riktning();

			}
			addBoat(koordinat, riktning, obj.getStorlek(),obj, obj.getNamn());
			printBoard();
			
		}
	}
}
