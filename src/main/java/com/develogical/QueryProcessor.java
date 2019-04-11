package com.develogical;

import java.util.*;

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

		if (query.toLowerCase().contains("eiffel")) {
			return "Paris";
		}

		if (query.toLowerCase().contains("banana")) {
			return "yellow";
		}

		if (query.toLowerCase().contains("bond")) {
			return "Sean Connery";
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

		List<Integer> listOfPrimeNumber = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
		Set<Integer> primeNumberSet = new HashSet<Integer>(listOfPrimeNumber);
		if (query.toLowerCase().contains("prime")) {
			String[] pieces = query.replace(",", " ").split(" ");
			List<Integer> listOfNumbers = extractNumbersFromQuery(pieces);

			for(Integer number: listOfNumbers){
				if (listOfPrimeNumber.contains(number)){
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
