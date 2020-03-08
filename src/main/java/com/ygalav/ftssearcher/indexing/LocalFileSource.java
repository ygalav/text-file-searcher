package com.ygalav.ftssearcher.indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocalFileSource extends Source {

    public static final String PATTERN = " ";
    private final File file;
    private Scanner scanner;
    private final String id;
    private final String name;

    public LocalFileSource(File file) throws FileNotFoundException {
        this.file = file;
        this.id = file.getAbsolutePath() ;
        this.name = file.getName();
        scanner = new Scanner(file);
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
