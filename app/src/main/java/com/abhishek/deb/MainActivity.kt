package com.abhishek.deb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var diceView: ImageView // This is a global variable
    private lateinit var rollBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollBtn = findViewById(R.id.roll_btn)
        diceView = findViewById(R.id.dice_view)

        rollBtn.text = "Let's Roll"

        rollBtn.setOnClickListener {
            rollTheDice()
        }

    }

    private fun rollTheDice() {

        val drawableRes = when (nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        diceView.setImageResource(drawableRes)

    }
}