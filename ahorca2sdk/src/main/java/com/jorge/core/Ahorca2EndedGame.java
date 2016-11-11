package com.jorge.core;

import com.jorge.game.BasicAhorca2WordsGame;

/**
 * Created by Jorge on 10/11/2016.
 */

public class Ahorca2EndedGame {

    private BasicAhorca2WordsGame basicAhorca2WordsGame;
    private long timeElapsed;

    public Ahorca2EndedGame(BasicAhorca2WordsGame basicAhorca2WordsGame, long timeElapsed) {
        this.basicAhorca2WordsGame = basicAhorca2WordsGame;
        this.timeElapsed = timeElapsed;
    }

    public BasicAhorca2WordsGame getBasicAhorca2WordsGame() {
        return basicAhorca2WordsGame;
    }

    public void setBasicAhorca2WordsGame(BasicAhorca2WordsGame basicAhorca2WordsGame) {
        this.basicAhorca2WordsGame = basicAhorca2WordsGame;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
