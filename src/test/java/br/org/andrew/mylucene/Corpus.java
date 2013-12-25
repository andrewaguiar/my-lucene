package br.org.andrew.mylucene;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Corpus {
	private Map<String, Document> documentMap;

	public Corpus(List<Document> documents) {
		documentMap = new LinkedHashMap<String, Document>();
		for (Document document : documents) {
			this.documentMap.put(document.getId(), document);
		}
	}

	public double termFrequencyInverseDocumentFrequency(String termToCheck, Document document) {
		return document.termFrequency(termToCheck) * inverseDocumentFrequency(termToCheck);
	}

	private double inverseDocumentFrequency(String termToCheck) {
		return Math.log(numberOfDocuments() / numberOfDocumentsContainingTerm(termToCheck));
	}

	private double numberOfDocuments() {
		return documentMap.size();
	}

	private double numberOfDocumentsContainingTerm(String termToCheck) {
		double count = 0;
		for (Document document : documentMap.values()) {
			if (document.containsTerm(termToCheck)) {
				count++;
			}
		}
		return count;
	}

	public Collection<Document> getDocuments() {
		return documentMap.values();
	}
}
