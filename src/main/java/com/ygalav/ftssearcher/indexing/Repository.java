package com.ygalav.ftssearcher.indexing;

import java.util.Iterator;

/**
 * Abstraction over the source of data that we are going to read.
 * Represents higher version abstraction over the data. Ex: [folder, DropBox account, Gmail, etc...]
 */
public abstract class Repository implements Iterator<Source> { }
