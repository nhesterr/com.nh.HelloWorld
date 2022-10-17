/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nh.HelloWorld;

import java.util.StringJoiner;
import java.util.TreeMap;

/**
 *
 * @author nhesterr
 */
public class PseudoFibonacci {
    
        public double γ = (Math.sqrt(5.0)-1.0)/2.0;
        public double γInverted = 1.0/((Math.sqrt(5.0)-1.0)/2.0);
        public double φ = (Math.sqrt(5.0)+1.0)/2.0;
        public double mod = 1.170821114369501;
        
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

	public WyświetlalnyTreeMapIntFloat<Integer, Double> pseudoCiąg = new WyświetlalnyTreeMapIntFloat<>();
	public WyświetlalnyTreeMapIntInt<Integer, Integer> ciągZaokrąglony = new WyświetlalnyTreeMapIntInt<>();
        
        
	public PseudoFibonacci generujPseudoCiągFibonacciego(int długość){
            WyświetlalnyTreeMapIntFloat<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMapIntFloat<>();
            if(długość>1) {
                ciągRoboczy.put(0, .0);
                ciągRoboczy.put(1, mod);
                for(int i = 2; i < długość; i++) {
                    ciągRoboczy.put(i, ciągRoboczy.get(i-1)*φ);
                }
            }
            else if(długość==1) {
                    ciągRoboczy.put(0, .0);
            }
            //System.out.println("Wygenerowano ciąg o długości: "+ciągRoboczy.size());
            this.pseudoCiąg = ciągRoboczy;
            return this;
	}
    
        @Override
        public String toString() {
            return this.pseudoCiąg.toString();
        }
}
