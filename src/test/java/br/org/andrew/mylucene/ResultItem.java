package br.org.andrew.mylucene;

import java.sql.ResultSet;

public class ResultItem {

	private Document document;
	private Double score;

	public ResultItem(Document document, Double score) {
		this.document = document;
		this.score = score;
	}

	public Document getDocument() {
		return document;
	}

	public Double getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return document.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ResultSet)) {
			return false;
		}
		return ((ResultItem) obj).document.equals(document);
	}
}
