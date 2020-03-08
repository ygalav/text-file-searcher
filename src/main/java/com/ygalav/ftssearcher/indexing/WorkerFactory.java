package com.ygalav.ftssearcher.indexing;

/**
 * Responsible for creation of workers based on Repository type
 * Also decouples Worker and Indexer and allows to inject dependencies dynamically
 */
public class WorkerFactory {

    public IndexerWorker createWorker(Repository repository) {
        return new DefaultIndexerWorker();
    }

}
