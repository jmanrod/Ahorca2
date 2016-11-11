package com.jorge.game;

import com.jorge.core.Ahorca2Words;
import com.jorge.core.Word;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Jorge on 10/11/2016.
 */

public class BasicAhorca2WordsGame implements Ahorca2WordsGame {

    private final Ahorca2Words ahorca2Words;
    private final Set<String> clickedLetters;

    public BasicAhorca2WordsGame(Ahorca2Words ahorca2Words) {
        this.ahorca2Words = ahorca2Words;
        clickedLetters = new TreeSet<>();
    }

    @Override
    public boolean isPresent(String a) {
        return ahorca2Words.getWord1().isPresent(a) || ahorca2Words.getWord2().isPresent(a);
    }

    @Override
    public boolean replace(String a) {
        return isPresent(a) && ahorca2Words.getWord1().replace(a) | ahorca2Words.getWord2().replace(a);
    }

    @Override
    public boolean isFinished() {
        return ahorca2Words.getWord1().isCompleted() && ahorca2Words.getWord2().isCompleted();
    }

    @Override
    public boolean isLetterAlreadyPressed(String s) {
        return !clickedLetters.add(s.toLowerCase());
    }

    @Override
    public String toString() {
        return "Ahorca2Words{" +
                "word1=" + ahorca2Words.getWord1() +
                ", word2=" + ahorca2Words.getWord2() +
                '}';
    }

    public String getWord1UnderScored() {
        return ahorca2Words.getWord1().getWordUnderscodered();
    }

    public String getWord2UnderScored() {
        return ahorca2Words.getWord2().getWordUnderscodered();
    }
}
