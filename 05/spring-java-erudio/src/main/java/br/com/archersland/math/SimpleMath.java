package br.com.archersland.math;

public class SimpleMath {
	
	public Double sum(Double numberOne, Double numberTwo) {				
		return numberOne + numberTwo;
	}
	
	public Double div(Double numberOne, Double numberTwo) {		
		return numberOne / numberTwo;
	}
	
	public Double minus(Double numberOne, Double numberTwo) {		
		return numberOne - numberTwo;
	}
	
	public Double multiply(Double numberOne, Double numberTwo) {		
		return numberOne * numberTwo;
	}
	
	public Double med(Double numberOne, Double numberTwo) {		
		return (numberOne + numberTwo)/2;
	}
	
	public Double sqrt(Double number) {		
		return Math.sqrt(number);
	}	
}
