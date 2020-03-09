package com.ygalav.ftssearcher.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Represents part of the data indexed and later can be merged into the index
 */
public interface Chunk {
    void put(String str);
    Object getData();
    boolean contains(String string);
    String getSourceId();
}
