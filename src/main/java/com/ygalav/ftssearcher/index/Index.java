package com.ygalav.ftssearcher.index;

import com.ygalav.ftssearcher.search.Document;

import java.util.List;
import java.util.Map;

/**
 * Represents the whole index of data indexed.
 * Completely independent from the Source of data and from the repository,
 * can contain data from multiple repositories and sources
 */
public interface Index {
    void appendChunk(Chunk chunk);
    boolean contains(String sourceId);

    //This method to be re-worked to return normal abstraction
    Map<String, Map<Word, Integer>> getIndexMap();
}
