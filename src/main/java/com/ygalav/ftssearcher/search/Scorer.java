package com.ygalav.ftssearcher.search;

import java.util.List;

public interface Scorer {
    double calculateScore(List<String> tokenizedString, Document document);
}
