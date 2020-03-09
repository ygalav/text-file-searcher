package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.index.Chunk;
import com.ygalav.ftssearcher.index.WordBasedHashMapChunk;

public class ChunkFactory {

    public Chunk createChunk(String name, String id) {
        return new WordBasedHashMapChunk(name, id);
    }
}
