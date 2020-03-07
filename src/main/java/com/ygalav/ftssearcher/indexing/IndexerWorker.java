package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.Chunk;

/**
 * Concrete worker that is able to perform indexing of the source and produce the Chunk
 */
public interface IndexerWorker {

    Chunk doIndex(Source source);

}
