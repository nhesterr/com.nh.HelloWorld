package com.nh.HelloWorld;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class RocketScienceFunc {

	static Tajmer czasDystrybucji = new Tajmer();
	static Tajmer czasWyświetlania = new Tajmer();
	static Tajmer czasUśredniania = new Tajmer();
	
	public RocketScienceFunc() {
	}

	public static double średnia(ArrayList<Integer> tablica) {
		var otoczka = new Object() {double f = .0;};
		czasUśredniania.przywróć();
		double tl = (double)tablica.size();
		tablica.forEach(element -> otoczka.f += element);
		otoczka.f = otoczka.f / tl;
		czasUśredniania.zawieś();
		return otoczka.f;
	}
	
	public static TreeMap<Integer, Integer> dystrybucja_10(ArrayList<Integer> tablica) {
		czasDystrybucji.przywróć();
		var otoczka = new Object() {TreeMap<Integer, Integer> wyniki = new TreeMap<Integer, Integer>();};
		int wyników = 10;

		for(int i = 0; i < wyników; i++) {
			otoczka.wyniki.put(i, 0);
		}
		tablica.forEach((element) -> otoczka.wyniki.replace(element/10, otoczka.wyniki.get(element/10)+1));
		czasDystrybucji.zawieś();
		return otoczka.wyniki;
	}
	
	public static ArrayList<Integer> lotyRakietowe(int lotów) {
		ArrayList<Integer> rezultaty = new ArrayList<Integer>();
		Tajmer czas = new Tajmer();
		czas.start();
		for(int i = 0; i < lotów; i++) {
			for(int j = 0; j < 100; j++) {
				if(j >= ThreadLocalRandom.current().nextInt(0, 100)) {
					rezultaty.add(j+1);
					break;
				}
			}
		}
		czas.koniec("Loty Rakietowe wygenerowane w");
		return rezultaty;
	}
	
	public static ArrayList<Integer> testLiczbLosowych(int prób) {
		ArrayList<Integer> rezultaty = new ArrayList<Integer>();
		Tajmer czas = new Tajmer();
		czas.start();
		for(int i = 0; i < prób; i++) {
			rezultaty.add(ThreadLocalRandom.current().nextInt(0, 100));
		}
		czas.koniec("Test Losowości wygenerowany w");
		return rezultaty;
	}	
	
	public static void wyświetl(ArrayList<Integer> rezultaty) {
		double średnia = średnia(rezultaty);
		
		czasWyświetlania.przywróć();
		System.out.println("Średnia: " + String.valueOf(średnia));
		czasWyświetlania.zawieś();
		
		TreeMap<Integer, Integer> dystrybucja = dystrybucja_10(rezultaty);
		
		czasWyświetlania.przywróć();
		for(Map.Entry<Integer, Integer> element : dystrybucja.entrySet()) {
			System.out.println("Koszyk: " + element.getKey() + ", elementów: " + element.getValue());
		}
		czasWyświetlania.zawieś();
	}
	
	public static void main(String[] args) {
		Tajmer czas = new Tajmer();
		czas.start();
		ArrayList<Integer> rezultaty = testLiczbLosowych(1000000);
		wyświetl(rezultaty);
		rezultaty = lotyRakietowe(1000000);
		wyświetl(rezultaty);
		czasDystrybucji.koniec("Czas dystrybucji:");
		czasWyświetlania.koniec("Czas wyświetlania:");
		czasUśredniania.koniec("Czas uśredniania:");
		czas.koniec("Czas całkowity:");
		
	}

}
