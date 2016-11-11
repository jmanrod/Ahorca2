package com.jorge.game;

import com.jorge.core.Ahorca2Words;
import com.jorge.core.Word;

import java.util.Date;

/**
 * Created by Jorge on 11/11/2016.
 */

public class TimedAhorca2WordsGame extends BasicAhorca2WordsGame {

    private final Date start;

    public TimedAhorca2WordsGame(Ahorca2Words ahorca2Words, Date start) {
        super(ahorca2Words);
        this.start = start;
    }

}
