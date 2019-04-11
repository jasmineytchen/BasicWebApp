package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static jdk.nashorn.internal.objects.NativeMath.max;

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
			return String.valueOf(Collections.max(listOfNumbers));
//			return String.valueOf(listOfNumbers.stream().mapToInt(Integer::intValue).max());
		}
		if (query.toLowerCase().contains("multiplied")) {
			String[] pieces = query.replace(",", " ").split(" ");
			List<Integer> listOfNumbers = extractNumbersFromQuery(pieces);
			return String.valueOf(listOfNumbers.get(0) * listOfNumbers.get(1));
		}

		if (query.toLowerCase().contains("square")) {
			String[] pieces = query.replace(",", " ").split(" ");
			List<Integer> listOfNumbers = extractNumbersFromQuery(pieces);

			for(Integer number: listOfNumbers){
				if(Math.sqrt(number) % 1 == 0 && Math.cbrt(number) % 1 == 0){
					return String.valueOf(number);
				}
			}
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
