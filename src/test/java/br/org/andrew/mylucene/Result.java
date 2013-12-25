package br.org.andrew.mylucene;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Result {
	private List<ResultItem> resultItems;
	private String termToSearch;

	public Result(String termToSearch) {
		this.termToSearch = termToSearch;
		this.resultItems = new LinkedList<ResultItem>();
	}

	public List<ResultItem> getResultItems() {
		List<ResultItem> result = new LinkedList<ResultItem>(resultItems);
		Collections.sort(result, new Comparator<ResultItem>() {
			@Override
			public int compare(ResultItem o1, ResultItem o2) {
				return o2.getScore().compareTo(o1.getScore());
			}
		});
		return result;
	}

	public String getTermToSearch() {
		return termToSearch;
	}

	public boolean add(ResultItem resultItem) {
		return resultItems.add(resultItem);
	}
}
