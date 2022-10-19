package com.nh.HelloWorld;

import java.util.StringJoiner;
import java.util.TreeMap;

public class Fibonacci {
	
        public double gamma = (Math.sqrt(5.0)-1.0)/2.0;
        
	public class WyświetlalnyTreeMapIntFloat<K, V> extends TreeMap<K, V> {

		private static final long serialVersionUID = 1L;
	    @Override
	    public String toString() {
	        StringJoiner sj = new StringJoiner("|");
	        //sj.add("ref: "+String.format("%4.5f", gamma));
	        forEach((key, value) -> sj.add(String.format("%4.5f", value)));
	        return sj.toString();
	    }
	}
	
	public class WyświetlalnyTreeMapIntInt<K, V> extends TreeMap<K, V> {

		private static final long serialVersionUID = 1L;
	    @Override
	    public String toString() {
	        StringJoiner sj = new StringJoiner("|");
	        //sj.add("ref: "+String.format("%4.5f", gamma));
	        forEach((key, value) -> sj.add(value.toString()));
	        return sj.toString();
	    }
	}

	public WyświetlalnyTreeMapIntInt<Integer, Long> ciąg = new WyświetlalnyTreeMapIntInt<>();
        
	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public static int fibonacci(int pozycja) {
            return switch (pozycja) {
                case 0 -> 0;
                case 1 -> 1;
                default -> fibonacci(pozycja-1) + fibonacci(pozycja-2);
            };
	}
	
	public Fibonacci generujCiągFibonacciego(int długość){
            WyświetlalnyTreeMapIntInt<Integer, Long> ciągRoboczy = new WyświetlalnyTreeMapIntInt<>();
            if(długość>1) {
                ciągRoboczy.put(0, (long)0);
                ciągRoboczy.put(1, (long)1);
                for(int i = 2; i < długość; i++) {
                    ciągRoboczy.put(i, ciągRoboczy.get(i-1)+ciągRoboczy.get(i-2));
                }
            }
            else if(długość==1) {
                ciągRoboczy.put(0, (long)0);
            }
            System.out.println("Wygenerowano ciąg o długości: "+ciągRoboczy.size());
            this.ciąg = ciągRoboczy;
            return this;
	}

	public WyświetlalnyTreeMapIntFloat<Integer, Double> obliczStosunki(){
		WyświetlalnyTreeMapIntFloat<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMapIntFloat<>();
		//System.out.println("Długość ciągu do obliczeń stosunków: "+this.ciąg.size());
		for(int i = 1; i < this.ciąg.size(); i++) {
			ciągRoboczy.put(i-1, (double)this.ciąg.get(i-1)/(double)this.ciąg.get(i));
			//System.out.println(String.format("%4.2f", (double)this.ciąg.get(i-1)/(double)this.ciąg.get(i)));
		}
		return ciągRoboczy;
	}
        
        public WyświetlalnyTreeMapIntFloat<Integer, Double> dodajPrzecinek(){
            WyświetlalnyTreeMapIntFloat<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMapIntFloat<>();
            for(int i = 0; i < this.ciąg.size(); i++) {
                ciągRoboczy.put(i, this.ciąg.get(i).doubleValue());
                //System.out.println("Klucz: "+i+", wartość: "+this.ciąg.get(i));
            }
            return ciągRoboczy;
        }
        
        @Override
        public String toString() {
            return this.ciąg.toString();
        }
}
