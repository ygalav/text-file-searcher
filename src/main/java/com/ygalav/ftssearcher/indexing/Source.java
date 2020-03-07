package com.ygalav.ftssearcher.indexing;

import java.util.Iterator;

/**
 * File level abstraction over the data we re indexing.
 * As a concept allows reading data by chunks if needed.
 */
public abstract class Source implements Iterator<String> { }
