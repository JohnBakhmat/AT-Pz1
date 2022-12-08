package com.yevheniibakhmat.at_pz1

class Calculator {
    private val delimiter = "|"
    fun evaluate(expression:String) : Double {
        var exp = expression.replace(" ", "")

        if(exp.isEmpty()) return 0.0
        if(exp.startsWith("-"))
            exp = "0$exp"

        val expToSplit = exp.replace(Regex("[+/*-]"), "$delimiter$0$delimiter")
        val expSplit = expToSplit.split(delimiter).toMutableList()

        while(expSplit.size > 1){

                for (i in 1 until expSplit.size - 1 step 2){
                    if (expSplit[i] != "*" && expSplit[i] != "/") continue
                    val operation = expSplit[i]
                    val a = expSplit[i - 1].toDouble()
                    val b = expSplit[i + 1].toDouble()
                    val result = simplify(a, b, operation)
                    expSplit[i] = result.toString()
                    expSplit.removeAt(i + 1)
                    expSplit.removeAt(i - 1)

                    if (!(expSplit.contains("*") || expSplit.contains("/"))) break
                }

                for (i in 1 until expSplit.size - 1 step 2){
                    val operation = expSplit[i]
                    val a = expSplit[i - 1].toDouble()
                    val b = expSplit[i + 1].toDouble()
                    val result = simplify(a, b, operation)
                    expSplit[i] = result.toString()
                    expSplit.removeAt(i + 1)
                    expSplit.removeAt(i - 1)
                    break;
                }
        }
        return expSplit[0].toDouble()
    }


    private fun simplify (a:Double, b:Double, operation:String) : Double {
        return when (operation) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> 0.0
        }
    }
    private fun <T> MutableList<T>.prepend(element: T) {
        add(0, element)
    }
}