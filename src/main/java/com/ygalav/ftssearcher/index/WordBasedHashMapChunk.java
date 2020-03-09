package com.ygalav.ftssearcher.index;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordBasedHashMapChunk implements Chunk {

    public static final String SPACE = " ";
    private final String sourceName;
    private final String sourceId;

    private Map<Word, Integer> indexMap = new HashMap<>();

    public WordBasedHashMapChunk(String sourceName, String sourceId) {
        this.sourceName = sourceName;
        this.sourceId = sourceId;
    }


    @Override
    public void put(String str) {
        splitToWords(str).forEach(wordStr -> {
            Word word = new CaseInsensitiveWord(wordStr);
            if (indexMap.containsKey(word)) {
                indexMap.put(word, indexMap.get(word) + 1);
            }
            else {
                indexMap.put(word, 1);
            }
        });
    }

    private Stream<String> splitToWords(String str) {
        if (str == null || str.isEmpty()) {
            return Stream.empty();
        }

        return Stream.of(str.split(SPACE)).filter(strng -> strng != null && !strng.isEmpty() && !SPACE.equals(strng));
    }

    @Override
    public Map<Word, Integer> getData() {
        return indexMap;
    }

    @Override
    public boolean contains(String term) {
        Word word = new CaseInsensitiveWord(term);
        return indexMap.containsKey(word);
    }

    @Override
    public String getSourceId() {
        return sourceId;
    }
}

