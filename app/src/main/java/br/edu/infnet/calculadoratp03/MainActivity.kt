package br.edu.infnet.calculadoratp03

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.edu.infnet.calculadoratp03.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

//    private var mCalculadora: Calculadora? = null
//    private var mOperandOneEditText: EditText? = null
//    private var mOperandTwoEditText: EditText? = null
//    private var mResultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupOnClickListener()

//        // Initialize the Calculadora class and all the views
//        mCalculadora = Calculadora()
//        mResultTextView = binding.tvResultado
//        // Entradas:
//        mOperandOneEditText = findViewById(R.id.operand_one_edit_text)
//        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text)
    }

    private fun setupOnClickListener() {
        binding.btn0.setOnClickListener { AcrescentarUmaExpressao("0", true) }
        binding.btn1.setOnClickListener { AcrescentarUmaExpressao("1", true) }
        binding.btn2.setOnClickListener { AcrescentarUmaExpressao("2", true) }
        binding.btn3.setOnClickListener { AcrescentarUmaExpressao("3", true) }
        binding.btn4.setOnClickListener { AcrescentarUmaExpressao("4", true) }
        binding.btn5.setOnClickListener { AcrescentarUmaExpressao("5", true) }
        binding.btn6.setOnClickListener { AcrescentarUmaExpressao("6", true) }
        binding.btn7.setOnClickListener { AcrescentarUmaExpressao("7", true) }
        binding.btn8.setOnClickListener { AcrescentarUmaExpressao("8", true) }
        binding.btn9.setOnClickListener { AcrescentarUmaExpressao("9", true) }

        binding.btnPonto.setOnClickListener { AcrescentarUmaExpressao(".", true) }

        // Operadores:
        binding.btnSoma.setOnClickListener { AcrescentarUmaExpressao("+", false) }
        binding.btnSubtracao.setOnClickListener { AcrescentarUmaExpressao("-", false) }
        binding.btnMultiplicacao.setOnClickListener { AcrescentarUmaExpressao("*", false) }
        binding.btnDivisao.setOnClickListener { AcrescentarUmaExpressao("/", false) }

        binding.btnLimpar.setOnClickListener {
            binding.tvExpressao.text = ""
            binding.tvResultado.text = ""
        }

        binding.btnBackspace.setOnClickListener {

            val string = binding.tvExpressao.text.toString()

            if(string.isNotBlank()){
                binding.tvExpressao.text = string.substring(0, string.length-1)
            }
            binding.tvResultado.text = ""

        }

        binding.btnIgual.setOnClickListener {

            try {
                val expressao = ExpressionBuilder(binding.tvExpressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    binding.tvResultado.text = longResult.toString()
                else
                    binding.tvResultado.text = resultado.toString()

            } catch(e: Exception) {
                
            }

        }

    }

    private fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean) {

        if (binding.tvResultado.text.isNotEmpty()){
           binding.tvExpressao.text = ""
        }

        if (limpar_dados){
            binding.tvResultado.text = ""
            binding.tvExpressao.append(string)
        } else{
            binding.tvExpressao.append(binding.tvResultado.text)
            binding.tvExpressao.append(string)
            binding.tvResultado.text = ""
        }

    }

//    // OnClick method called when the add Button is pressed.
//    fun onAdd(view: View?) {
//        compute(Calculadora.Operator.ADD)
//    }
//
//    // OnClick method called when the subtract Button is pressed.
//    fun onSub(view: View?) {
//        compute(Calculadora.Operator.SUB)
//    }
//
//    // OnClick method called when the divide Button is pressed.
//    fun onDiv(view: View?) {
//        try {
//            compute(Calculadora.Operator.DIV)
//        } catch (iae: IllegalArgumentException) {
//            Log.e(TAG, "IllegalArgumentException", iae)
//            mResultTextView!!.text = getString(R.string.mensagemDeErro)
//        }
//    }
//
//    // OnClick method called when the multiply Button is pressed.
//    fun onMul(view: View?) {
//        compute(Calculadora.Operator.MUL)
//    }
//
//    private fun compute(operator: Calculadora.Operator) {
//        val operandOne: Double
//        val operandTwo: Double
//        try {
//            operandOne = getOperand(mOperandOneEditText)
//            operandTwo = getOperand(mOperandTwoEditText)
//        } catch (nfe: NumberFormatException) {
//            Log.e(TAG, "NumberFormatException", nfe)
//            mResultTextView!!.text = getString(R.string.mensagemDeErro)
//            return
//        }
//        val result: String
//        result = when (operator) {
//            Calculadora.Operator.ADD -> mCalculadora!!.add(operandOne, operandTwo).toString()
//            Calculadora.Operator.SUB -> mCalculadora!!.sub(operandOne, operandTwo).toString()
//            Calculadora.Operator.DIV -> mCalculadora!!.div(operandOne, operandTwo).toString()
//            Calculadora.Operator.MUL -> mCalculadora!!.mul(operandOne, operandTwo).toString()
//            else -> getString(R.string.mensagemDeErro)
//        }
//        mResultTextView!!.text = result
//    }
//
//    companion object {
//        private const val TAG = "CalculadoraActivity"
//
//        // return the operand value entered in an EditText as double.
//        private fun getOperand(operandEditText: EditText?): Double {
//            val operandText = getOperandText(operandEditText)
//            return java.lang.Double.valueOf(operandText)
//        }
//
//        // return the operand text which was entered in an EditText.
//        private fun getOperandText(operandEditText: EditText?): String {
//            return operandEditText!!.text.toString()
//        }
//    }
}