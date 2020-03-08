package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.index.Chunk;
import com.ygalav.ftssearcher.index.Index;
import org.junit.Test;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class DefaultSequentialIndexerTest {

    @Test
    public void shouldIndexAllSourcesFromTheRepositoryAndAppendChunksAccordingly() {
        //Given
        //Mock dependencies
        IndexFactory indexFactory = mock(IndexFactory.class);
        WorkerFactory workerFactory = mock(WorkerFactory.class);

        //Mock sources
        Source source_1 = ofSource(randomStr(), randomStr(), Collections.emptyIterator());
        Source source_2 = ofSource(randomStr(), randomStr(), Collections.emptyIterator());
        Repository repository = ofRepository(source_1, source_2);

        //Mock chunks that will be returned from workers
        Chunk chunk_1 = mock(Chunk.class);
        Chunk chunk_2 = mock(Chunk.class);

        //Mock workers
        IndexerWorker worker = mock(IndexerWorker.class);
        when(workerFactory.createWorker(any(Repository.class))).thenReturn(worker);

        //Mock workers to return expected chunks
        when(worker.doIndex(source_1)).thenReturn(chunk_1);
        when(worker.doIndex(source_2)).thenReturn(chunk_2);

        //Mock index creation
        Index index = mock(Index.class);
        when(indexFactory.createIndex()).thenReturn(index);

        //When
        DefaultSequentialIndexer testInstance = new DefaultSequentialIndexer(workerFactory, indexFactory);
        testInstance.performIndexing(repository);

        //Then
        verify(workerFactory, times(2)).createWorker(repository);
        verify(index).appendChunk(chunk_1);
        verify(index).appendChunk(chunk_2);
    }

    private static String randomStr() {
        return UUID.randomUUID().toString();
    }

    public Repository ofRepository(Source... sources) {
        return new Repository() {

            Iterator<Source> sourcesItr = Arrays.asList(sources).iterator();

            @Override
            public boolean hasNext() {
                return sourcesItr.hasNext();
            }

            @Override
            public Source next() {
                return sourcesItr.next();
            }
        };
    }

    public Source ofSource (String name, String id, Iterator<String> data) {
        return new Source() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getId() {
                return id;
            }

            @Override
            public boolean hasNext() {
                return data.hasNext();
            }

            @Override
            public String next() {
                return data.next();
            }
        };
    }




}