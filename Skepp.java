package SankaSkepp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Skepp{
	/*
	 * private String [] batett; private String [] battva; private String [] battre;
	 * private String [] batfour; private String [] batfem;
	 */
	public String namn;
	public int storlek;
	static LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	LinkedList<Koordinater> skeppKoordinater = new LinkedList<Koordinater>();
	LinkedList<Koordinater> båtKoordinater = new LinkedList<Koordinater>();

	public Skepp(int storlek, String namn, LinkedList<Koordinater> båtKoordinater) {
		this.storlek = storlek;
		this.namn = namn;
		this.båtKoordinater = båtKoordinater;

	}

	public LinkedList<Koordinater> getSkeppKoordinater() {
		return skeppKoordinater;
	}

	public void setSkeppKoordinater(LinkedList<Koordinater> skeppKoordinater) {
		this.skeppKoordinater = skeppKoordinater;
	}

	public int getStorlek() {
		return storlek;
	}

	public void setStorlek(int storlek) {
		this.storlek = storlek;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}


	public static void addSkepp(Skepp c) {
		skeppar.add(c);
	}
	/*public static void addKoordinat(String c) {
		koordinater.add(c);
	}*/

	public static void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}
	
	/*public static void printKoordinat() {
		for (String obj : koordinater) {
			System.out.println(obj);
		}
	}*/

	public String toString() {
		return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
	}
	
	/*public void skapaSkepp(Skepp skepp) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Här kan du skapa ett skepp. Vad ska ditt skepp heta?");
		String namn = scan.nextLine();
		skepp.setNamn(namn);
		System.out.println("Välj en storlek på ditt skepp!");
		int storlek = scan.nextInt();
		skepp.setStorlek(storlek);
	}*/
	
	public void placeraSkepp(Skepp c, boolean val) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nu ska du placera dina skepp. Välj koordinater a-j och sedan position 0-9! ");
		for(Skepp obj : skeppar) {
			System.out.println("Vart vill du placera " + getNamn() + "?");
			String koordinat = scan.nextLine();
			if (val = true) {
			//	kollaBoard(koordinat);
				char yLed = koordinat.charAt(0);
				//char yBak = yLed-1;
				char xLed = koordinat.charAt(1);
				
			}
			
		}
	}
	
	
	public boolean kollaBoard(String koordinater, boolean val) {
		char yLed = koordinater.charAt(0);
		char yBak = (char) (koordinater.charAt(0)-1);
		char xLed = koordinater.charAt(1);
		char xBak = (char) (koordinater.charAt(1)-1);
		
		if (val = true) {
			if (xLed + getStorlek()>10) {
				System.out.println("Båten är för stor");
				return false;
			}
		//	for (Koordinater nycklar : map.keySet()) {
						
		//	}
		}
		else {
		
		}
		return true;
		
	}

	/*public String[] addaFlotta() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nu ska du lägga till pjäser i flottan!");
		String[] båtEtt = { "ett", "två" };
		String[] båtTvå = { "ett", "två", "tre" };
		String[] båtTre = { "ett", "två", "tre", "fyra" };
		String[] båtFyra = { "ett", "två", "tre", "fyra", "fem" };
		System.out.println("Lägg till båt 1 som är av storlek 2! ");
		for (int i = 0; i < båtEtt.length; i++) {
			System.out.println("Vart ska första biten sitta? ");
			String indexEtt = scan.nextLine();
			båtEtt[0] = indexEtt;
			System.out.println("Vart ska andra delen ligga?");
			String indexTva = scan.nextLine();
			båtEtt[1] = indexTva;
		}
		for (int i = 0; i < båtTvå.length; i++) {
			System.out.println("Vart ska första biten sitta? ");
			String indexEtt = scan.nextLine();
			båtTvå[0] = indexEtt;
			System.out.println("Vart ska andra delen ligga?");
			String indexTva = scan.nextLine();
			båtEtt[1] = indexTva;
		}
		return båtTvå;
	}*/


}