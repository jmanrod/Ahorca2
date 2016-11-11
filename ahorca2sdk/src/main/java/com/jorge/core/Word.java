package com.jorge.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jorge on 10/11/2016.
 */

public class Word {

    private static final String UNDERSCORE = "_";
    public static final String WHITESPACE = " ";
    private String word;
    private String wordUnderscodered;

    public Word(String word) {
        this.word = word;
        wordUnderscodered = getUnderscore();
    }

    public Word getUnderscored() {
        return new Word(getUnderscore());
    }

    private String getUnderscore() {
        StringBuilder underScored = new StringBuilder();
        for (int i = 0; i< word.length(); i++){
            underScored.append(UNDERSCORE);
//            underScored.append(WHITESPACE);
        }
//        underScored.delete(underScored.length() - 1, underScored.length());
        return underScored.toString();
    }

    public boolean isPresent(String a) {
        if(a==null || a.length()==0) return false;
        return word.toLowerCase().contains(a.toLowerCase());
    }

    public String getWord() {
        return word;
    }

    public String getWordUnderscodered() {
        return wordUnderscodered;
    }

    public boolean replace(String letter) {
        if(isPresent(letter)){
            Pattern pattern = Pattern.compile(letter.toLowerCase());
            Matcher matcher = pattern.matcher(word.toLowerCase());
            StringBuilder stringBuilderUnderscored = new StringBuilder(wordUnderscodered);
            while (matcher.find()){
                stringBuilderUnderscored.setCharAt(matcher.start(),letter.toLowerCase().charAt(0));
            }
            wordUnderscodered = stringBuilderUnderscored.toString();
            return true;
        }
        return false;
    }

    public boolean isCompleted() {
        return word.equalsIgnoreCase(wordUnderscodered);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", wordUnderscodered='" + wordUnderscodered + '\'' +
                '}';
    }
}
