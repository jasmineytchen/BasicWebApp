package com.develogical.ArithmeticAnswerKeeper;

import java.util.List;

public class Addition implements  ArithmeticFormula{

	@Override
	public int calculate(List<Integer> listOfNumbers) {
		return listOfNumbers.stream().mapToInt(Integer::intValue).sum();
	}
}


