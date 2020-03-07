package com.ygalav.ftssearcher.indexing;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataFolderRepositoryTest {
    private static final String TEST_DIRECTORY_PATH = "src/test/resources/samples";

    @Test
    public void shouldProperlyListInitializeDirectoryAndListAllSources() {
        //Given
        File dir = new File(TEST_DIRECTORY_PATH);
        List<String> filesInTheDir = Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .map(File::getName)
                .collect(Collectors.toList());

        //When,Then
        DataFolderRepository testInstance = new DataFolderRepository(TEST_DIRECTORY_PATH);
        while (testInstance.hasNext()) {
            Source source = testInstance.next();
            Assert.assertTrue(filesInTheDir.remove(source.getName())); //File existed in the list
        }
        Assert.assertTrue(filesInTheDir.isEmpty()); //All files were listed
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionIfFolderPathIsIncorrect() {
        //When
        DataFolderRepository testInstance = new DataFolderRepository(TEST_DIRECTORY_PATH + "/unexisted");
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowAnNullPointerIfFolderPathIsNull() {
        //When
        DataFolderRepository testInstance = new DataFolderRepository(null);
    }


}