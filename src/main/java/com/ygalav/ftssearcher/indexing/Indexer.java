package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.Index;

/**
 * Abstraction over indexing Algorythm
 * Produces the whole index and encapsulates effective
 * strategies how to perform the indexing itself
 */
public interface Indexer {
    Index performIndexing(Repository repository);
}
