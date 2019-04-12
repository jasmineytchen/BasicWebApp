package com.develogical.ArithmeticAnswerKeeper;

import java.util.*;

public class ArithmeticContext {

	private ArithmeticFormula arithmeticFormula;

	public ArithmeticContext(ArithmeticFormula arithmeticFormula) {
		this.arithmeticFormula = arithmeticFormula;
	}

	public String getResult(String[]arithmeticQuery){
		List<Integer> listOfNumbers=extractNumbersFromQuery(arithmeticQuery);
		int result = arithmeticFormula.calculate(listOfNumbers);
		return String.valueOf("result is " + result);
}


	private List<Integer> extractNumbersFromQuery(String[] pieces) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (String piece : pieces) {
			int parsedPiece;
			try {
				parsedPiece = Integer.parseInt(piece);
			} catch (NumberFormatException nfe) {
				continue;
			}
			numbers.add(parsedPiece);
		}
		return numbers;
	}

}
