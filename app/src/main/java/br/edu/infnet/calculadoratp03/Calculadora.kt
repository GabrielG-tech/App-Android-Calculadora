package br.edu.infnet.calculadoratp03

class Calculadora {
    // Available operations
    enum class Operator { ADD, SUB, DIV, MUL }


    fun add(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand + secondOperand
    }

    fun sub(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand - secondOperand
    }

    fun div(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand / secondOperand
    }

    fun mul(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand * secondOperand
    }

}