package com.jorge.test;

import com.jorge.core.Ahorca2Words;
import com.jorge.game.BasicAhorca2WordsGame;
import com.jorge.core.providers.FakeWordsProvider;
import com.jorge.core.providers.WordsProvider;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jorge on 11/11/2016.
 */
public class FakeWordsProviderTest {
    WordsProvider wordsProvider;

    @Before
    public void init(){
        wordsProvider = new FakeWordsProvider();
    }

    @Test
    public void getWords() throws Exception {
        Ahorca2Words words = wordsProvider.getWords();
        assertNotNull(words);
    }

    @Test
    public void random() throws Exception {
        for (int i = 0; i < 1000000; i++){
            assertTrue(((FakeWordsProvider)wordsProvider).random() >= 0);
        }
    }
}