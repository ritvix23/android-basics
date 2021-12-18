package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.button)
        val diceImage : ImageView = findViewById(R.id.imageView);
        diceImage.setImageResource(R.drawable.dice_1);
        rollBtn.setOnClickListener {

            val msgText : TextView = findViewById(R.id.textView2)
            val luckyNumber = 4;
            val dice = Dice(6)
            val rollResult = dice.roll();
            val drawableResource = when(rollResult){
                1-> R.drawable.dice_1;
                2-> R.drawable.dice_2;
                3-> R.drawable.dice_3;
                4-> R.drawable.dice_4;
                5-> R.drawable.dice_5;
                else-> R.drawable.dice_6;
            }
            diceImage.setImageResource(drawableResource);
            diceImage.contentDescription = rollResult.toString();
            if(rollResult == luckyNumber) msgText.text = "You Won!";
            else msgText.text = "Try again :(";
        }
    }
}


class Dice(val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}