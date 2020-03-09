package com.ygalav.ftssearcher.indexing;

import java.io.File;
import java.io.FileNotFoundException;
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
            throw new IllegalArgumentException("The path provided does not lead to the existing directory");
        }
        File[] directoryFiles = directory.listFiles();
        if (directoryFiles == null) {
            directoryContents = Collections.emptyIterator();
            return;
        }

        directoryContents = Stream.of(directoryFiles).filter(file -> !file.isDirectory()).iterator();
    }

    @Override
    public boolean hasNext() {
        return directoryContents.hasNext();
    }

    @Override
    public Source next() {
        Source source;
        File nextFile = directoryContents.next();
        try {
            source = new LocalFileSource(nextFile);
        } catch (FileNotFoundException e) {
            source = new Source.EmptySource();
        }
        return source;
    }
}
