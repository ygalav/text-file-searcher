package com.ygalav.ftssearcher.index;

import java.util.Objects;

public final class CaseInsensitiveWord implements Word {

    private String word;

    public CaseInsensitiveWord(String word) {
        this.word = word.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseInsensitiveWord caseInsensitiveWord1 = (CaseInsensitiveWord) o;

        return Objects.equals(word, caseInsensitiveWord1.word);
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
