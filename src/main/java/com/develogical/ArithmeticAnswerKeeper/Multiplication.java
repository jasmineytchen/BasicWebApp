package com.develogical.ArithmeticAnswerKeeper;

import java.util.List;

public class Multiplication implements  ArithmeticFormula{

	@Override
	public int calculate(List<Integer> listOfNumbers) {
		return listOfNumbers.get(0) * listOfNumbers.get(1);
	}
}


