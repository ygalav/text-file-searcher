package com.ygalav.ftssearcher.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the search result
 */
public class SearchResult {

    private List<Document> documents = new ArrayList<>();

    private int totalCount = 0;

    public static final SearchResult EMPTY_RESULT = new SearchResult();

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
