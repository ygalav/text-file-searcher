package com.ygalav.ftssearcher.indexing;

import java.util.Iterator;

/**
 * File level abstraction over the data we re indexing.
 * As a concept allows reading data by chunks if needed.
 */
public abstract class Source implements Iterator<String> {

    public abstract String getName();

    public abstract String getId();

    public static final Source EMPTY_SOURCE = new Source() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getId() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }
    };
}
