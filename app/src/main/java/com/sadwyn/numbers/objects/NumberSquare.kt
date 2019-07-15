package com.sadwyn.numbers.objects

import androidx.annotation.DrawableRes
import com.sadwyn.numbers.R
import kotlin.random.Random


class NumberSquare private constructor(val drawable: Int, val value: Int) : Square() {

    companion object {
        private const val MIN_VAL = -100
        private const val MAX_VAL = 100

        fun create(): Square = NumberSquare(R.drawable.field_bakcground,  Random.nextInt(MIN_VAL, MAX_VAL))
    }
}
