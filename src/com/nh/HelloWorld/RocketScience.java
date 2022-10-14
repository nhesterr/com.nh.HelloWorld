package com.nh.HelloWorld;

import java.util.concurrent.ThreadLocalRandom;

public class RocketScience {

	public RocketScience() {
		// TODO Auto-generated constructor stub
	}
	
	public static double średnia(int tablica[]) {
		double f = .0;
		int tl = tablica.length;
		for(int i = 0; i < tl; i++) {
			f = f + tablica[i];
		}
		//System.out.println("Proto f: " + String.valueOf(f));
		f = f / tl;
		
		return f;
	}
	
	public static int[] dystrybucja_10(int tablica[]) {
		int[] wyniki = new int[10];
		int wl = wyniki.length;
		int tl = tablica.length;
		// System.out.println("tl: "+tl);
		
		for(int i = 0; i < wl; i++) {
			wyniki[i] = 0;
		}
		for(int i = 0; i < tl; i++) {
			if(tablica[i]/10 > 10) {
				System.out.println("Indeks: "+i+", wartość: "+tablica[i]);
			}
			wyniki[tablica[i]/10]++;
		}		
		return wyniki;
	}
	
	public static int[] lotyRakietowe(int lotów) {
		int rezultaty[] = new int[lotów];
		long czasStart = System.nanoTime();
		for(int i = 0; i < lotów; i++) {
			for(int j = 0; j < 100; j++) {
				if(j >= ThreadLocalRandom.current().nextInt(0, 100)) {
					rezultaty[i] = j + 1;
					break;
				}
			}
		}
		long czasStop = System.nanoTime();
		double czasTrwania = (double)(czasStop - czasStart)/1000000;
		String sCzasTrwania = String.format("%4.2f", czasTrwania);
		System.out.println("Loty Rakietowe wygenerowane w " + sCzasTrwania + "ms.");
		return rezultaty;
	}
	
	public static int[] testLiczbLosowych(int prób) {
		int rezultaty[] = new int[prób];
		long czasStart = System.nanoTime();
		for(int i = 0; i < prób; i++) {
			rezultaty[i] = ThreadLocalRandom.current().nextInt(0, 100);
		}
		long czasStop = System.nanoTime();
		double czasTrwania = (double)(czasStop - czasStart)/1000000;
		String sCzasTrwania = String.format("%4.2f", czasTrwania);
		System.out.println("Test Losowości wygenerowany w " + sCzasTrwania + "ms.");
		return rezultaty;
	}	
	
	public static void wyświetl(int[] rezultaty) {
		double średnia = średnia(rezultaty);
		System.out.println("Średnia: " + String.valueOf(średnia));
		
		int[] dystrybucja = dystrybucja_10(rezultaty);
		for(int i = 0; i < 10; i++) {
			System.out.println("Koszyk: " + i + ", elementów: " + dystrybucja[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rezultaty[] = testLiczbLosowych(1000000);
		
		wyświetl(rezultaty);
		
		rezultaty = lotyRakietowe(1000000);

		wyświetl(rezultaty);
		
	}

}
