package com.ygalav.ftssearcher.search;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DefaultScorer implements Scorer {
    @Override
    public double calculateScore(List<String> tokenizedString, Document document) {
        double score = (double) document.getTerms().size() / tokenizedString.size();
        return round(score, 2);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
