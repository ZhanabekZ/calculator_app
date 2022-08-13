package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if (isNewOp)
            editText.setText("")
        isNewOp = false

        var butClick = editText.text.toString()
        var butSelect = view as Button
        when (butSelect.id) {
            but1.id -> { butClick += "1" }
            but2.id -> { butClick += "2" }
            but3.id -> { butClick += "3" }
            but4.id -> { butClick += "4" }
            but5.id -> { butClick += "5" }
            but6.id -> { butClick += "6" }
            but7.id -> { butClick += "7" }
            but8.id -> { butClick += "8" }
            but9.id -> { butClick += "9" }
            but0.id -> { butClick += "0" }
            butDot.id -> { butClick += "." }
            butPlusMinus.id -> { butClick = "-$butClick" }

        }
        editText.setText(butClick)

    }

    fun operatorEvent(view: android.view.View) {
        isNewOp = true
        oldNumber = editText.text.toString()


        var butSelect = view as Button
        when (butSelect.id) {
            butMultiply.id -> {op = "*"}
            butPlus.id -> {op = "+"}
            butDivide.id -> {op = "/"}
            butMinus.id -> {op = "-"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber = editText.text.toString()
        var result = 0.0
        when (op) {
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
        }
        val df = DecimalFormat("#####.############")

        editText.setText(df.format(result).toString())

    }


        fun percentEvent(view: android.view.View) {

        var result = editText.text.toString().toDouble() / 100
        editText.setText(result.toString())
        isNewOp = true

    }
    fun acEvent(view: android.view.View) {
        editText.setText("0")
        isNewOp = true
    }


}