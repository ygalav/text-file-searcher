package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.index.Index;

/**
 * Simple non parallel Indexer that Indexes files OneByOne
 */
public class DefaultSequentialIndexer implements Indexer {

    private final WorkerFactory workerFactory;
    private final IndexFactory indexFactory;

    public DefaultSequentialIndexer(
            WorkerFactory workerFactory,
            IndexFactory indexFactory
    ) {
        this.workerFactory = workerFactory;
        this.indexFactory = indexFactory;
    }

    @Override
    public Index performIndexing(Repository... repositories) {
        Index index = indexFactory.createIndex();
        for (Repository repository : repositories) {
            while (repository.hasNext()) {
                Source source = repository.next();
                IndexerWorker indexerWorker = workerFactory.createWorker(repository);
                index.appendChunk(indexerWorker.doIndex(source));
            }
        }
        return index;
    }
}
