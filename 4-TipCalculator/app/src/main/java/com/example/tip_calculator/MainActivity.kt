package com.example.tip_calculator

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tip_calculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calcButton.setOnClickListener { calculateTip() }
        binding.costTextInput.setOnKeyListener{ view, keycode, _ -> hideKeyboard(view, keycode)}

    }

    private fun hideKeyboard(view: View, keyCode: Int): Boolean{
        if(keyCode== KeyEvent.KEYCODE_ENTER){
            val inputMethodManager  = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }


    private fun calculateTip() {
        var inputCost  = binding.costTextInput.text.toString().toDoubleOrNull()
        if(inputCost==null) inputCost = 0.0
        var tipAmount = inputCost * when (binding.tipRadioGroup.checkedRadioButtonId) {
            R.id.first_tip_radio -> 1.2
            R.id.second_tip_radio -> 1.1
            else -> 1.05
        }

        if (binding.roundTipSwitch.isChecked) tipAmount = kotlin.math.ceil(tipAmount)

        val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
        binding.tipAmountText.text = getString(R.string.tip_amount, formattedTip)


    }
}
