package com.nh.HelloWorld;

public class FiboRezultaty {

	public FiboRezultaty() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ciąg.ciąg = Fibonacci.generujCiągFibonacciego(20);
		//System.out.println(ciąg.generujCiągFibonacciego(20).obliczStosunki().toString());
                //System.out.println("γ: " + pseudoCiąg.γ + " φ: " + pseudoCiąg.φ + " 1/γ: " + pseudoCiąg.γInverted);
                
                int l = 50;
		Fibonacci ciąg = new Fibonacci();
                PseudoFibonacci pseudoCiąg = new PseudoFibonacci();
		System.out.println(ciąg.generujCiągFibonacciego(l).dodajPrzecinek().toString());
                //System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, 1.).toString());
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, PseudoFibonacci.refMod).toString());
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, 1.170820406656479).toString());
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, 1.170820393256892).toString());
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, 1.1708203932499369083773410781543).toString());
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(l, 1.17082039325).toString());
                System.out.println(pseudoCiąg.generujPseudoCiąg(l, .4472135955).toString());
                System.out.println(pseudoCiąg.generujPseudoCiąg(l, PseudoFibonacci.ϱ).toString());
	}
        
}

//_____.4472135955
//_____.72360679775
//_____.17082039325
//s0: 0.44721359549995793907350626100343
//s1: 0.72360679774997896930383481715087
//s2: 1.1708203932499369083773410781543