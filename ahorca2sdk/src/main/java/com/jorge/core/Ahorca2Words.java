package com.jorge.core;

import com.jorge.game.BasicGame;

/**
 * Created by Jorge on 10/11/2016.
 */

public class Ahorca2Words implements BasicGame {
    private Word word1;
    private Word word2;

    public Ahorca2Words(Word word1, Word word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public Word getWord1() {
        return word1;
    }

    public Word getWord2() {
        return word2;
    }

    public Ahorca2Words getUnderScored() {
        return new Ahorca2Words(word1.getUnderscored(), word2.getUnderscored());
    }

    @Override
    public boolean isPresent(String a) {
        return word1.isPresent(a) || word2.isPresent(a);
    }

    @Override
    public boolean replace(String a) {
            return isPresent(a) && word1.replace(a) | word2.replace(a);
    }

    @Override
    public boolean isFinished() {
        return word1.isCompleted() && word2.isCompleted();
    }

    @Override
    public String toString() {
        return "Ahorca2Words{" +
                "word1=" + word1 +
                ", word2=" + word2 +
                '}';
    }
}
