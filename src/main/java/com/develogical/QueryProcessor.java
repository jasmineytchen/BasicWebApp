package com.develogical;

import com.develogical.ArithmeticAnswerKeeper.*;

import java.util.HashMap;

public class QueryProcessor {

	private ArithmeticFormula arithmeticFormula;
	private LiteralAnswerKeeper literalFormula = new LiteralAnswerKeeper();

	public String process(String query) {

		System.out.println(query);

		String lowerCaseQuery = query.toLowerCase();
		String[] numeralQuery = query.replace(",", " ").split(" ");
		String[] arithmeticQuery = query.split(" ");

		HashMap<String, String> queryAndAnswer = literalFormula.getQueryAndAnswer();
		for (String key : queryAndAnswer.keySet()) {
			if (lowerCaseQuery.contains(key)) {
				return queryAndAnswer.get(key);
			}
		}

		if (lowerCaseQuery.contains("plus")) {
			return new ArithmeticContext(new Addition()).getResult(arithmeticQuery);
		}

		if (lowerCaseQuery.contains("product")) {
			return new ArithmeticContext(new Multiplication()).getResult(arithmeticQuery);
		}

		if (lowerCaseQuery.contains("largest")) {
			return new ArithmeticContext(new LargestNumber()).getResult(numeralQuery);
		}

		if (lowerCaseQuery.contains("square")) {
			return new ArithmeticContext(new Roots()).getResult(numeralQuery);
		}

		if (lowerCaseQuery.contains("prime")) {
			return new ArithmeticContext(new PrimeNumber()).getResult(numeralQuery);
		}
		return "";
	}
}
