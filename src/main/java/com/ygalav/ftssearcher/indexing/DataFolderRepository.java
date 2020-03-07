package com.ygalav.ftssearcher.indexing;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class DataFolderRepository extends Repository {

    private final Iterator<File> directoryContents;

    public DataFolderRepository(String directoryPathStr) {
        Objects.requireNonNull(directoryPathStr, "Directory path should not be null");

        File directory = new File(directoryPathStr);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Phe path provided does not lead to the existing directory");
        }
        File[] directoryFiles = directory.listFiles();
        if (directoryFiles == null) {
            directoryContents = Collections.emptyIterator();
            return;
        }

        directoryContents = Stream.of(directoryFiles).iterator();
    }

    @Override
    public boolean hasNext() {
        return directoryContents.hasNext();
    }

    @Override
    public Source next() {
        Source source = new LocalFileSource(directoryContents.next());
        return source;
    }
}
