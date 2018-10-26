package com.jorge.core

import com.jorge.game.BasicGame

/**
 * Created by Jorge on 10/11/2016.
 */

class Ahorca2Words(val word1: Word, val word2: Word) : BasicGame {

    val underScored: Ahorca2Words
        get() = Ahorca2Words(word1.underscored, word2.underscored)

    override fun isPresent(a: String): Boolean {
        return word1.isPresent(a) || word2.isPresent(a)
    }

    override fun replace(a: String): Boolean {
        return isPresent(a) && word1.replace(a) or word2.replace(a)
    }

    override fun isFinished(): Boolean {
        return word1.isCompleted && word2.isCompleted
    }

    override fun toString(): String {
        return "Ahorca2Words{" +
                "word1=" + word1 +
                ", word2=" + word2 +
                '}'
    }
}
