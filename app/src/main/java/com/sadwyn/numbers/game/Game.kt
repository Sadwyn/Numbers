package com.sadwyn.numbers.game

import com.sadwyn.numbers.objects.Square
import java.util.concurrent.atomic.AtomicInteger

abstract class Game(val gameEventListener: GameEventListener) {
    protected var frequency: Long = 1000
    protected lateinit var score: AtomicInteger
    protected var grid: Array<Square?> = Array(25) {null}

    abstract fun updateScore(value: Int)
    abstract fun getScore() : Int
    abstract fun play()
    abstract fun pause()
    abstract fun resume()
}
