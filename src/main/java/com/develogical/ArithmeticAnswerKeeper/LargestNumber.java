package com.develogical.ArithmeticAnswerKeeper;

import java.util.Collections;
import java.util.List;

public class LargestNumber implements  ArithmeticFormula{

	@Override
	public int calculate(List<Integer> listOfNumbers) {
		return Collections.max(listOfNumbers);
	}
}


