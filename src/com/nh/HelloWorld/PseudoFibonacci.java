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
    
        public static double γ = (Math.sqrt(5.0)-1.0)/2.0;
        public static double γInverted = 1.0/((Math.sqrt(5.0)-1.0)/2.0);
        public static double φ = (Math.sqrt(5.0)+1.0)/2.0;
        public static double ϱ = 1./Math.sqrt(5.0);
        public static double refMod = 1.170821114369501;
        
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
        
        
	public PseudoFibonacci generujPseudoCiągFibonacciego(int długość, double mod){
            WyświetlalnyTreeMapIntFloat<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMapIntFloat<>();
            if(długość>0) {
                ciągRoboczy.put(0, .0);
                if(długość>1) {
                    ciągRoboczy.put(1, 1.);
                    if(długość>2) {
                        ciągRoboczy.put(2, mod);
                        if(długość>3){
                            for(int i = 3; i < długość; i++) {
                                ciągRoboczy.put(i, ciągRoboczy.get(i-1)*φ);
                            }
                        }
                    }
                }
            }
            else if(długość==1) {
                    ciągRoboczy.put(0, .0);
            }
            //System.out.println("Wygenerowano ciąg o długości: "+ciągRoboczy.size());
            this.pseudoCiąg = ciągRoboczy;
            return this;
	}

	public PseudoFibonacci generujPseudoCiąg(int długość, double mod){
            WyświetlalnyTreeMapIntFloat<Integer, Double> ciągRoboczy = new WyświetlalnyTreeMapIntFloat<>();
            if(długość>0) {
                ciągRoboczy.put(0, mod);
                if(długość>1){
                    for(int i = 1; i < długość; i++) {
                        ciągRoboczy.put(i, ciągRoboczy.get(i-1)*φ);
                    }
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
