package com.ygalav.ftssearcher.search;

import java.util.List;

/**
 * Abstraction over the searcher, encapsulates an effective algorythm of searching data
 */
public interface Searcher {
    SearchResult doSearch(SearchQuery query);

    List<String> tokenize(String text);
}
