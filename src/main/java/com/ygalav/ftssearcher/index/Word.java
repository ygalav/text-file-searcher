package com.ygalav.ftssearcher.index;

public interface Word {
    static Word of(String s) {
        return new CaseInsensitiveWord(s);
    }
}
