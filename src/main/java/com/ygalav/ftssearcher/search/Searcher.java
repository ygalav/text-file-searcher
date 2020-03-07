package com.ygalav.ftssearcher.search;

/**
 * Abstraction over the searcher, encapsulates an effective algorythm of searching data
 */
public interface Searcher {
    SearchResult doSearch(SearchQuery query);
}
