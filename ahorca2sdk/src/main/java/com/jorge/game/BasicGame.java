package com.jorge.game;

import java.io.Serializable;

/**
 * Created by Jorge on 11/11/2016.
 */
public interface BasicGame extends Serializable {
    boolean isPresent(String a);
    boolean replace(String a);
    boolean isFinished();
}
