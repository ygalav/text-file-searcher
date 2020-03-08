package com.ygalav.ftssearcher.indexing;

import com.ygalav.ftssearcher.index.HashMapIndex;
import com.ygalav.ftssearcher.index.Index;

public class IndexFactory {
    public Index createIndex() {
        return new HashMapIndex();
    }
}
