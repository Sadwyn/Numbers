package com.sadwyn.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.sadwyn.numbers.game.Game
import com.sadwyn.numbers.game.GameEventListener
import com.sadwyn.numbers.game.SinglePlayerGame
import com.sadwyn.numbers.objects.NumberSquare
import com.sadwyn.numbers.objects.Square
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GameEventListener {
    private lateinit var gridLayout: GridLayout
    private lateinit var game: Game
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridLayout = findViewById(R.id.glPlayField)
        game = SinglePlayerGame(this)
    }

    override fun onResume() {
        super.onResume()
        game.play()
    }

    override fun onTick(grid: Array<Square?>) {
        runOnUiThread {
            for (i in 0..24) {
                val square = (gridLayout[i] as TextView)
                if (grid[i] is NumberSquare) {
                    val numberSquare = grid[i] as NumberSquare
                    square.text = numberSquare.value.toString()
                    square.background = ContextCompat.getDrawable(this, numberSquare.drawable)
                    square.setOnClickListener {
                        game.updateScore(square.text.toString().toInt())
                        tvScore.text = getString(R.string.score, game.getScore())
                    }
                }
            }
        }
    }

    override fun onGameStarted() {
        runOnUiThread {
            tvScore.text = getString(R.string.score, game.getScore())
        }
    }

    override fun onGameStopped() {
       //make saving of user rating
    }

    override fun onGamePaused() {
        //show Menu
    }

    override fun onGameResumed() {
        //resuming game process
    }

    override fun onLose() {
        finish() // replace with UI for losing
    }

}
