package com.jorge.test;

import com.jorge.core.Word;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jorge on 10/11/2016.
 */
public class WordTest {

    private Word word;

    @Before
    public void init() {
        word = new Word("asdasdasda");
    }

    @Test
    public void wordShouldReturnUnderscored() throws Exception {
        Word underscored = word.getUnderscored();
        assertTrue(word.getWord().length() == underscored.getWord().length());
    }

    @Test
    public void wordShouldCheckIfAletterIsPresent() throws Exception {
        assertTrue(word.isPresent("A"));
        assertTrue(word.isPresent("d"));
        assertTrue(word.isPresent("D"));
        assertTrue(word.isPresent("a"));
        assertFalse(word.isPresent("c"));
    }

    @Test
    public void wordShouldReplaceAletterOnUnderscoredIfIsPresent() throws Exception {
        String letter = "A";
        if(word.isPresent(letter)){
            System.out.println(word.getWordUnderscodered());
            assertTrue(word.replace(letter));
            System.out.println(word.getWordUnderscodered());
        }
    }

    @Test
    public void wordShouldCheckIfWordIsCompleted() throws Exception {
        String test = "asd";
        for (int i = 0; i < test.length(); i++){
            assertFalse(word.isCompleted());
            word.replace(String.valueOf(test.charAt(i)));
        }
        assertTrue(word.isCompleted());
    }
}