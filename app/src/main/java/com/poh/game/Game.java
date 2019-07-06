package com.poh.game;

import com.poh.playObjects.Square;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Game {
    protected int duration = 15;
    protected int frequency = 2;
    protected AtomicInteger score;
    public static final int VERTICAL_SIZE = 5;
    public static final int HORIZONTAL_SIZE = 5;
    protected Class[] possiblePlayObjects;

    public abstract void play();
}
