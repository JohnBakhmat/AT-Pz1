package com.yevheniibakhmat.at_pz1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    private var divideButton: Button? = null
    private var multiplyButton: Button? = null
    private var minusButton: Button? = null
    private var plusButton: Button? = null
    private var equalButton: Button? = null
    private var clearButton: Button? = null
    private var dotButton: Button? = null
    private var zeroButton: Button? = null
    private var oneButton: Button? = null
    private var twoButton: Button? = null
    private var threeButton: Button? = null
    private var fourButton: Button? = null
    private var fiveButton: Button? = null
    private var sixButton: Button? = null
    private var sevenButton: Button? = null
    private var eightButton: Button? = null
    private var nineButton: Button? = null

    private var expressionTextView: TextView? = null
    private var resultTextView: TextView? = null


    private var expression = "0"
    private var result = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getButtons()
        bindEvents()
    }

    private fun updateExpression() {
        expressionTextView?.text = expression

    }

    private fun updateResult() {
        //if can be int show  int
        val isResultInt = result == floor(result)

        resultTextView?.text =
            if (isResultInt)
                result.toInt().toString()
            else result.toString()
    }

    private fun getButtons() {
        divideButton = findViewById(R.id.divide)
        multiplyButton = findViewById(R.id.multiply)
        minusButton = findViewById(R.id.minus)
        plusButton = findViewById(R.id.plus)
        equalButton = findViewById(R.id.equals)
        clearButton = findViewById(R.id.clear)
        dotButton = findViewById(R.id.dot)
        zeroButton = findViewById(R.id.zero)
        oneButton = findViewById(R.id.one)
        twoButton = findViewById(R.id.two)
        threeButton = findViewById(R.id.three)
        fourButton = findViewById(R.id.four)
        fiveButton = findViewById(R.id.five)
        sixButton = findViewById(R.id.six)
        sevenButton = findViewById(R.id.seven)
        eightButton = findViewById(R.id.eight)
        nineButton = findViewById(R.id.nine)

        expressionTextView = findViewById(R.id.expression)
        resultTextView = findViewById(R.id.result)
    }

    private fun bindEvents() {

        divideButton?.setOnClickListener {
            expression += "/"
            updateExpression()
        }

        multiplyButton?.setOnClickListener {
            expression += "*"
            updateExpression()

        }

        minusButton?.setOnClickListener {
            expression += "-"
            updateExpression()

        }

        plusButton?.setOnClickListener {
            expression += "+"
            updateExpression()

        }


        clearButton?.setOnClickListener {
            expression = ""
            updateExpression()

        }

        dotButton?.setOnClickListener {
            expression += "."
            updateExpression()

        }

        zeroButton?.setOnClickListener {
            expression += "0"
            updateExpression()

        }

        oneButton?.setOnClickListener {
            expression += "1"
            updateExpression()

        }

        twoButton?.setOnClickListener {
            expression += "2"
            updateExpression()

        }

        threeButton?.setOnClickListener {
            expression += "3"
            updateExpression()

        }

        fourButton?.setOnClickListener {
            expression += "4"
            updateExpression()

        }

        fiveButton?.setOnClickListener {
            expression += "5"
            updateExpression()

        }

        sixButton?.setOnClickListener {
            expression += "6"
            updateExpression()

        }

        sevenButton?.setOnClickListener {
            expression += "7"
            updateExpression()

        }

        eightButton?.setOnClickListener {
            expression += "8"
            updateExpression()

        }

        nineButton?.setOnClickListener {
            expression += "9"
            updateExpression()
        }

        equalButton?.setOnClickListener {
            result = Calculator().evaluate(expression)
            updateResult()
        }
    }
}