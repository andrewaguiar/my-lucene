package br.org.andrew.mylucene;

import java.util.List;

public class Document {

	private String id;
	private Terms terms;

	public Document(String id, List<String> terms) {
		this.id = id;
		this.terms = new Terms(terms);
	}

	public String getId() {
		return id;
	}

	public double termFrequency(String termToCheck) {
		return numberOfOccurrencesOfTerm(termToCheck) / numberOfTerms();
	}

	public boolean containsTerm(String termToCheck) {
		return terms.getNumberOfOccurences(termToCheck) > 0;
	}

	public double numberOfTerms() {
		return (double) terms.numberOfTerms();
	}

	private int numberOfOccurrencesOfTerm(String termToCheck) {
		return terms.getNumberOfOccurences(termToCheck);
	}

	public Terms getTerms() {
		return terms;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Document)) {
			return false;
		}
		return ((Document) obj).id.equals(id);
	}

	@Override
	public String toString() {
		return "Document[" + id + "]";
	}
}
