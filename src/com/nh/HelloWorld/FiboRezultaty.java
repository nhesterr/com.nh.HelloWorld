package com.nh.HelloWorld;

public class FiboRezultaty {

	public FiboRezultaty() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci ciąg = new Fibonacci();
		//ciąg.ciąg = Fibonacci.generujCiągFibonacciego(20);
		System.out.println(ciąg.generujCiągFibonacciego(20).toString());
                
		System.out.println(ciąg.generujCiągFibonacciego(20).obliczStosunki().toString());
                
                PseudoFibonacci pseudoCiąg = new PseudoFibonacci();
                //System.out.println("γ: " + pseudoCiąg.γ + " φ: " + pseudoCiąg.φ + " 1/γ: " + pseudoCiąg.γInverted);
                System.out.println(pseudoCiąg.generujPseudoCiągFibonacciego(20).toString());
	}
        
}
