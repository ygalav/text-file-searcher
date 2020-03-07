package com.ygalav.ftssearcher;

/**
 * Represents the whole index of data indexed.
 * Completely independent from the Source of data and from the repository,
 * can contain data from multiple repositories and sources
 */
public interface Index {
    void appendChunk(Chunk chunk);
}
