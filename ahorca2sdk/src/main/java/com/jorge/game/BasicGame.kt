package com.jorge.game

import java.io.Serializable

/**
 * Created by Jorge on 11/11/2016.
 */
interface BasicGame : Serializable {
    fun isFinished(): Boolean
    fun isPresent(a: String): Boolean
    fun replace(a: String): Boolean
}
