package com.ygalav.ftssearcher.search;

import com.ygalav.ftssearcher.index.Index;
import com.ygalav.ftssearcher.index.Word;

import java.util.*;

public class DefaultSearcher implements Searcher {

    private static final String DEFAULT_TOKEN = " ";

    private final Index index;
    private Scorer scorer;

    public DefaultSearcher(Index index, Scorer scorer) {
        this.index = index;
        this.scorer = scorer;
    }

    @Override
    public SearchResult doSearch(SearchQuery query) {
        String text = query.getText();

        if (text == null || text.isEmpty()) {
            return SearchResult.EMPTY_RESULT;
        }

        List<String> tokenizedStr = tokenize(text);
        List<Document> searchResDocuments = new ArrayList<>();
        Map<String, Map<Word, Integer>> indexMap = index.getIndexMap();
        for (String id : indexMap.keySet()) {
            Map<Word, Integer> documentMapCopy = new HashMap<>(indexMap.get(id));
            Document document = new Document();
            document.setId(id);
            document.setTerms(new ArrayList<>());
            for (String term : tokenizedStr) {
                Word word = Word.of(term);
                if (documentMapCopy.containsKey(word) && documentMapCopy.get(word) > 0) {
                    documentMapCopy.put(word, documentMapCopy.get(word) - 1);
                    document.getTerms().add(term);
                }
            }
            if (document.getTerms().size() > 0) {
                double score = scorer.calculateScore(tokenizedStr, document);
                document.setScore(score);
                searchResDocuments.add(document);
            }
        }

        searchResDocuments.sort(Comparator.comparingDouble(Document::getScore).reversed());

        int limit = query.getLimit();
        List<Document> topDocuments = searchResDocuments;
        if (limit > 0 && searchResDocuments.size() > limit) {
            topDocuments = searchResDocuments.subList(0, limit);
        }

        SearchResult searchResult = new SearchResult();
        searchResult.setDocuments(topDocuments);
        searchResult.setTotalCount(searchResDocuments.size());
        return searchResult;
    }

    @Override
    public List<String> tokenize(String text) {
        return Arrays.asList(text.split(DEFAULT_TOKEN));
    }
}
