package com.ygalav.ftssearcher.index;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class WordBasedHashMapChunkTest {

    @Test
    public void shouldPutAllWordsFromString() {
        //Given
        WordBasedHashMapChunk testInstance = new WordBasedHashMapChunk("anyName", "anyId");
        String testString = "THIS is a & $ test String WithDIFFERENT cased words";
        String[] upperCasedWords = testString.toUpperCase().split(" ");
        //When
        testInstance.put(testString);
        //Then
        Assert.assertTrue(Stream.of(upperCasedWords).allMatch(testInstance::contains));
    }

    @Test
    public void shouldIgnoreSpacesBetweenWords() {
        String testString = "THIS is a & $ test         String  with some extra spaces     ";
        WordBasedHashMapChunk testInstance = new WordBasedHashMapChunk("anyName", "anyId");

        //When
        testInstance.put(testString);

        //Then
        Assert.assertTrue(Stream.of(testString.split(" "))
                .filter(s -> !s.isEmpty() && !s.equals(" "))
                .allMatch(testInstance::contains));
    }

    public void shouldContainWordsForMultipleAddedStrings(){}
}