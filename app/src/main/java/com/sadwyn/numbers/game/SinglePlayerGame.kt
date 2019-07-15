package com.sadwyn.numbers.game

import com.sadwyn.numbers.objects.NumberSquare
import java.util.concurrent.atomic.AtomicInteger

class SinglePlayerGame(gameEventListener: GameEventListener) : Game(gameEventListener) {

    override fun getScore(): Int {
        return score.toInt()
    }

    private val updatingThread = android.os.Handler()

    override fun play() {
        score = AtomicInteger(0)
        gameEventListener.onGameStarted()
        updatingThread.post(runnableCallback())
    }

    private fun runnableCallback(): Runnable {
        return object : Runnable {
            override fun run() {
                updatedPlayField()
                gameEventListener.onTick(grid)
                updatingThread.postDelayed(this, frequency)
            }
        }
    }

    private fun updatedPlayField() {
        var i = 0
        while (i < 25) {
            grid[i] = NumberSquare.create()
            i++
        }
    }

    override fun updateScore(value: Int) {
        score.addAndGet(value)
    }

    override fun pause() {
        updatingThread.removeCallbacks(runnableCallback())
    }

    override fun resume() {
    }
}
