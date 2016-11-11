package com.jorge.test;

import com.jorge.core.Ahorca2Words;
import com.jorge.game.BasicAhorca2WordsGame;
import com.jorge.core.Word;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jorge on 10/11/2016.
 */
public class BasicAhorca2WordsGameTest {

    private BasicAhorca2WordsGame basicAhorca2WordsGame;

    @Before
    public void init() {
        Word word = new Word("asdasdasda");
        Word word2 = new Word("asdgdfgda");
        Ahorca2Words ahorca2Words = new Ahorca2Words(word, word2);
        basicAhorca2WordsGame = new BasicAhorca2WordsGame(ahorca2Words);
    }

    @Test
    public void ahorca2WordsShouldCheckIfAletterIsPresentInSomeWord() throws Exception {
        assertTrue(basicAhorca2WordsGame.isPresent("A"));
        assertTrue(basicAhorca2WordsGame.isPresent("g"));
        assertFalse(basicAhorca2WordsGame.isPresent("X"));
        assertFalse(basicAhorca2WordsGame.isPresent("z"));
    }

    @Test
    public void ahorca2WordsShouldReplaceAletterIfIsPresent() throws Exception {
        System.out.println(basicAhorca2WordsGame);
        assertTrue(basicAhorca2WordsGame.replace("A"));
        System.out.println(basicAhorca2WordsGame);
        assertTrue(basicAhorca2WordsGame.replace("g"));
        System.out.println(basicAhorca2WordsGame);
        assertFalse(basicAhorca2WordsGame.replace("X"));
        System.out.println(basicAhorca2WordsGame);
        assertFalse(basicAhorca2WordsGame.replace("z"));
        System.out.println(basicAhorca2WordsGame);
    }

    @Test
    public void ahorca2WordsShouldCheckIfAgameIsEnded() throws Exception {
        String test = "asdgf";
        for (int i = 0; i < test.length(); i++) {
            assertTrue(basicAhorca2WordsGame.replace(String.valueOf(test.charAt(i))));
        }
        assertTrue(basicAhorca2WordsGame.isFinished());
    }
}
