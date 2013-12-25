package br.org.andrew.mylucene;

import java.util.HashMap;
import java.util.List;

public class Terms {
	private int numberOfTerms;
	private HashMap<String, Counting> mapOfTerms;

	public Terms(List<String> terms) {
		this.numberOfTerms = terms.size();
		this.mapOfTerms = createMapOfTerms(terms);
	}

	public double numberOfTerms() {
		return numberOfTerms;
	}

	public int getNumberOfOccurences(String termToCheck) {
		Counting counting = mapOfTerms.get(termToCheck);
		if (counting == null) {
			return 0;
		}
		return counting.getValue();
	}

	private HashMap<String, Counting> createMapOfTerms(List<String> terms) {
		HashMap<String, Counting> mapOfTerms = new HashMap<String, Counting>();
		for (String term : terms) {
			Counting counting = mapOfTerms.get(term);
			if (counting == null) {
				counting = new Counting();
				mapOfTerms.put(term, counting);
			}
			counting.increment();
		}
		return mapOfTerms;
	}

	private static class Counting {
		private int value;

		public void increment() {
			value++;
		}

		public int getValue() {
			return value;
		}
	}
}
