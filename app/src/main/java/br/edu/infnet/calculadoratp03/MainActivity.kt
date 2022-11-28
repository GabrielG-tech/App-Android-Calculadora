package br.edu.infnet.calculadoratp03

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import br.edu.infnet.calculadoratp03.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    private var mCalculadora: Calculadora? = null
    private var mOperandOneEditText: EditText? = null
    private var mOperandTwoEditText: EditText? = null
    private var mResultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // Initialize the Calculadora class and all the views
        mCalculadora = Calculadora()
        mResultTextView = findViewById(R.id.tvResultado)
        // Entradas:
//        mOperandOneEditText = findViewById(R.id.operand_one_edit_text)
//        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text)
    }

    // OnClick method called when the add Button is pressed.
    fun onAdd(view: View?) {
        compute(Calculadora.Operator.ADD)
    }

    // OnClick method called when the subtract Button is pressed.
    fun onSub(view: View?) {
        compute(Calculadora.Operator.SUB)
    }

    // OnClick method called when the divide Button is pressed.
    fun onDiv(view: View?) {
        try {
            compute(Calculadora.Operator.DIV)
        } catch (iae: IllegalArgumentException) {
            Log.e(TAG, "IllegalArgumentException", iae)
            mResultTextView!!.text = getString(R.string.mensagemDeErro)
        }
    }

    // OnClick method called when the multiply Button is pressed.
    fun onMul(view: View?) {
        compute(Calculadora.Operator.MUL)
    }

    private fun compute(operator: Calculadora.Operator) {
        val operandOne: Double
        val operandTwo: Double
        try {
            operandOne = getOperand(mOperandOneEditText)
            operandTwo = getOperand(mOperandTwoEditText)
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            mResultTextView!!.text = getString(R.string.mensagemDeErro)
            return
        }
        val result: String
        result = when (operator) {
            Calculadora.Operator.ADD -> mCalculadora!!.add(operandOne, operandTwo).toString()
            Calculadora.Operator.SUB -> mCalculadora!!.sub(operandOne, operandTwo).toString()
            Calculadora.Operator.DIV -> mCalculadora!!.div(operandOne, operandTwo).toString()
            Calculadora.Operator.MUL -> mCalculadora!!.mul(operandOne, operandTwo).toString()
            else -> getString(R.string.mensagemDeErro)
        }
        mResultTextView!!.text = result
    }

    companion object {
        private const val TAG = "CalculadoraActivity"

        // return the operand value entered in an EditText as double.
        private fun getOperand(operandEditText: EditText?): Double {
            val operandText = getOperandText(operandEditText)
            return java.lang.Double.valueOf(operandText)
        }

        // return the operand text which was entered in an EditText.
        private fun getOperandText(operandEditText: EditText?): String {
            return operandEditText!!.text.toString()
        }
    }
}