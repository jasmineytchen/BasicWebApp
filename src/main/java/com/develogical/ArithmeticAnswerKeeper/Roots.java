package com.develogical.ArithmeticAnswerKeeper;

import java.util.List;

public class Roots implements  ArithmeticFormula{

	@Override
	public int calculate(List<Integer> listOfNumbers) {

		int initNum = 0;
		for (Integer number : listOfNumbers) {
			if (Math.sqrt(number) % 1 == 0 && Math.cbrt(number) % 1 == 0) {
				initNum = number;
			}
		}
		return initNum;
	}
}


