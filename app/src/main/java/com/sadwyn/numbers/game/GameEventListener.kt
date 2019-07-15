package com.sadwyn.numbers.game

import com.sadwyn.numbers.objects.Square

interface GameEventListener {
    fun onGameStarted()
    fun onGameStopped()
    fun onGamePaused()
    fun onGameResumed()

    fun onTick(grid : Array<Square?>)
    fun onLose()
}