package com.nh.HelloWorld;

public class FiboRezultaty {

	public FiboRezultaty() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci ciąg = new Fibonacci();
		//ciąg.ciąg = Fibonacci.generujCiągFibonacciego(20);
		System.out.print(ciąg.generujCiągFibonacciego(20).obliczStosunki().toString());
	}

}
