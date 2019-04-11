package com.develogical;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class QueryProcessor {

	public String process(String query) {

		System.out.println(query);

		if (query.toLowerCase().contains("shakespeare")) {
			return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
					"English poet, playwright, and actor, widely regarded as the greatest " +
					"writer in the English language and the world's pre-eminent dramatist.";
		}
		if (query.toLowerCase().contains("name")) {
			return "mexico-bandido";
		}

		if (query.toLowerCase().contains("plus")) {
			String[] pieces = query.split(" ");
			List<Integer> listOfNumbers = extractNumbersFromQuery(pieces);
			return String.valueOf(listOfNumbers.stream().mapToInt(Integer::intValue).sum());
		}

		if (query.toLowerCase().contains("largest")) {
			String[] pieces = query.replace(",", " ").split(" ");

			List<Integer> listOfNumbers = extractNumbersFromQuery(pieces);
			return String.valueOf(listOfNumbers.stream().mapToInt(Integer::intValue).max().getAsInt());
		}
		return "";
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
