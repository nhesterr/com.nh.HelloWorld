package com.nh.HelloWorld;

import java.util.StringJoiner;
import java.util.TreeMap;

public class Fibonacci {

	public TreeMap<Integer, Integer> ciąg = new TreeMap<Integer, Integer>();
	
	public class WyświetlalnyTreeMap<K, V> extends TreeMap<K, V> {

		private static final long serialVersionUID = 1L;
	    @Override
	    public String toString() {
	        StringJoiner sj = new StringJoiner("|");
	        sj.add("ref: "+String.format("%4.5f", (Math.sqrt(5)-1.0)/2.0));
	        forEach((key, value) -> sj.add(String.format("%4.5f", value)));
	        return sj.toString();
	    }
	}
	
	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public static int fibonacci(int pozycja) {
		switch(pozycja) {
			case 0: return 0;
			case 1: return 1;
			default: return fibonacci(pozycja-1) + fibonacci(pozycja-2);
		}
	}
	
	public Fibonacci generujCiągFibonacciego(int długość){
		TreeMap<Integer, Integer> ciągRoboczy = new TreeMap<Integer, Integer>();
		if(długość>1) {
			ciągRoboczy.put(0, 0);
			ciągRoboczy.put(1, 1);
			for(int i = 2; i < długość; i++) {
				ciągRoboczy.put(i, ciągRoboczy.get(i-1)+ciągRoboczy.get(i-2));
			}
		}
		else if(długość==1) {
			ciągRoboczy.put(0, 0);
		}
		System.out.println("Wygenerowano ciąg o długości: "+ciągRoboczy.size());
		this.ciąg = ciągRoboczy;
		return this;
	}

	public WyświetlalnyTreeMap<Integer, Double> obliczStosunki(){
		WyświetlalnyTreeMap<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMap<Integer, Double>();
		System.out.println("Długość ciągu do obliczeń stosunków: "+this.ciąg.size());
		for(int i = 1; i < this.ciąg.size(); i++) {
			ciągRoboczy.put(i-1, (double)this.ciąg.get(i-1)/(double)this.ciąg.get(i));
			//System.out.println(String.format("%4.2f", (double)this.ciąg.get(i-1)/(double)this.ciąg.get(i)));
		}
		return ciągRoboczy;
	}
	
	@Override
	public String toString() {
		var otoczka = new Object(){	String s = "";};
		this.ciąg.forEach((k, v) -> otoczka.s+=String.format("%4.2f", v));
		return otoczka.s;
	}
}
