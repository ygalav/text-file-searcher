package com.ygalav.ftssearcher.indexing;

import java.io.File;

public class LocalFileSource extends Source {

    private final File file;
    public LocalFileSource(File file) {
        this.file = file;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public String getName() {
        return file.getName();
    }
}
