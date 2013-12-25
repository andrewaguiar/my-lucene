package br.org.andrew.mylucene;

public class Search {
	private Corpus corpus;

	public Search(Corpus corpus) {
		this.corpus = corpus;
	}

	public Result query(String termToQuery) {
		Result result = new Result(termToQuery);

		for (Document document : corpus.getDocuments()) {
			double score = corpus.termFrequencyInverseDocumentFrequency(termToQuery, document);
			if (score > 0.0) {
				result.add(new ResultItem(document, score));
			}
		}

		return result;
	}
}
