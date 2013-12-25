package br.org.andrew.mylucene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Document> documents = new ArrayList<Document>();
		documents.add(getDocument("1", "dog", "dog", "dog"));
		documents.add(getDocument("2", "dog", "dog", "ok"));
		documents.add(getDocument("3", "cat", "strawberry", "yes"));
		documents.add(getDocument("4", "bee", "pear", "ok"));
		documents.add(getDocument("5", "cow", "banana", "ok"));
		documents.add(getDocument("6", "bull", "guava", "ok"));
		documents.add(getDocument("7", "hornet", "raspberry", "ok"));
		documents.add(getDocument("8", "gnat", "grape", "ok"));
		documents.add(getDocument("9", "wasp", "pineapple", "ok"));
		documents.add(getDocument("10", "badbug", "cherry", "ok"));
		documents.add(getDocument("11", "dog", "cherry", "ok"));
		documents.add(getDocument("12", "dog", "ok", "ok"));
		documents.add(getDocument("13", "ok", "ok", "ok"));

		Corpus corpus = new Corpus(documents);

		Result result = new Search(corpus).query("ok");

		for (ResultItem resultItem : result.getResultItems()) {
			System.out.println(resultItem.getDocument() + ": "
					+ resultItem.getScore());
		}
	}

	private static Document getDocument(String id, String... terms) {
		return new Document(id, Arrays.asList(terms));
	}
}
