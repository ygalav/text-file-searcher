package com.ygalav.ftssearcher;

import com.ygalav.ftssearcher.index.Index;
import com.ygalav.ftssearcher.indexing.*;
import com.ygalav.ftssearcher.search.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please type your search phrase or 'exit' to stop");

        if (args.length == 0) {
            System.out.println("No directory to index found");
            return;
        }

        ChunkFactory chunkFactory = new ChunkFactory();
        WorkerFactory workerFactory = new WorkerFactory(chunkFactory);
        IndexFactory indexFactory = new IndexFactory();
        Indexer indexer = new DefaultSequentialIndexer(workerFactory, indexFactory);

        String directoryPath = args[0];
        Repository repository = new DataFolderRepository(directoryPath);
        Index index = indexer.performIndexing(repository);

        while (true) {
            System.out.print("search >>: ");
            String searchPhrase = scanner.nextLine();

            SearchQuery searchQuery = new SearchQuery(searchPhrase, 10);
            Searcher searcher = new DefaultSearcher(index, new DefaultScorer());
            SearchResult searchResult = searcher.doSearch(searchQuery);

            System.out.println("Found results total : " + searchResult.getTotalCount());

            searchResult.getDocuments().forEach(document -> {
                System.out.println(document.getId() + " score: " + document.getScore());
            });
            if ("exit".equalsIgnoreCase(searchPhrase)) {
                System.out.println("Thanks for the session,. exiting.");
                break;
            }
        }


    }
}
