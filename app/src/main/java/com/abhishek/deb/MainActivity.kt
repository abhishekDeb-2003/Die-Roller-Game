package com.abhishek.deb

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var diceView: ImageView // This is a global variable
    private lateinit var rollBtn: Button
    private lateinit var animationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollBtn = findViewById(R.id.roll_btn)
        diceView = findViewById(R.id.dice_view)
        animationView = findViewById(R.id.animation_view)

        rollBtn.text = resources.getText(R.string.roll_txt)

        rollBtn.setOnClickListener {
            rollTheDice()
        }

    }

    private fun rollTheDice() {

        diceView.visibility = View.GONE
        animationView.visibility = View.VISIBLE

        animationView.playAnimation()
        if (animationView.isAnimating) {
            animationView.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    Log.e("Animation:", "start")
                    rollBtn.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animator) {
                    diceView.visibility = View.VISIBLE
                    animationView.visibility = View.GONE
                    rollBtn.isEnabled = true

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

                override fun onAnimationCancel(animation: Animator) {
                    Log.e("Animation:", "cancel")
                }

                override fun onAnimationRepeat(animation: Animator) {
                    Log.e("Animation:", "repeat")
                }
            })
        }

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