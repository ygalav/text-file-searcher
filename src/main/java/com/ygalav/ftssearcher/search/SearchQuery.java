package com.ygalav.ftssearcher.search;

/**
 * Represents the search query, can contain meta-data [pagination, etc...]
 */
public class SearchQuery {

    private String text;
    private int limit;

    public SearchQuery(String text, int limit) {
        this.text = text;
        this.limit = limit;
    }

    public String getText() {
        return text;
    }

    public int getLimit() {
        return limit;
    }
}
