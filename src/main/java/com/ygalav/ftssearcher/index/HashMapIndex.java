package com.ygalav.ftssearcher.index;

import com.ygalav.ftssearcher.index.Chunk;
import com.ygalav.ftssearcher.index.Index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapIndex implements Index {

    private Map<String, Map<Word, Integer>> indexMap = new HashMap<>();

    @Override
    public void appendChunk(Chunk chunk) {
        indexMap.put(chunk.getSourceId(), (Map<Word, Integer>) chunk.getData());
    }

    @Override
    public boolean contains(String sourceId) {
        return indexMap.containsKey(sourceId);
    }
}
