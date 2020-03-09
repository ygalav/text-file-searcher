package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.index.Chunk;

import java.util.Objects;

public class DefaultIndexerWorker implements IndexerWorker {

    private final ChunkFactory chunkFactory;

    public DefaultIndexerWorker(ChunkFactory chunkFactory) {
        this.chunkFactory = chunkFactory;
    }


    @Override
    public Chunk doIndex(Source source) {
        Objects.requireNonNull(source, "Source can't be null");
        if (source instanceof Source.EmptySource) {
            return null;
        }
        Chunk chunk = chunkFactory.createChunk(source.getId(), source.getName());
        while (source.hasNext()) {
            chunk.put(source.next());
        }
        return chunk;
    }
}
