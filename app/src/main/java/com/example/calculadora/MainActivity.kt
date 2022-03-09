package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var operator: Char = '0'
    var firstValue: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //val miBoton: Button = findViewById<Button>(R.id.button0)

        binding.buttonClear.setOnClickListener{
            binding.editTextNumber.text.clear()
        }
        binding.buttonDelete.setOnClickListener{
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))

        }
        binding.buttonPorcentaje.setOnClickListener{
            binding.editTextNumber.setText(porcentaje(operator))

        }
        binding.buttonigual.setOnClickListener {
            when(operator){
                '+' -> { binding.editTextNumber.setText("${firstValue + binding.editTextNumber.text.toString().toDouble()}")
                }
                '-' -> { binding.editTextNumber.setText("${firstValue - binding.editTextNumber.text.toString().toDouble()}")
                }
                '×' -> { binding.editTextNumber.setText("${firstValue * binding.editTextNumber.text.toString().toDouble()}")
                }
                '÷' -> { binding.editTextNumber.setText("${firstValue / binding.editTextNumber.text.toString().toDouble()}")
                }
                else-> binding.editTextNumber.setText("ERROR")
            }
            operator = '0'
            firstValue = 0.0

        }
    }

    fun porcentaje(operatorToUse: Char) : String{
        when(operatorToUse){
            '+' -> {return "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '-' -> {return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '0' -> {return "${binding.editTextNumber.text.toString().toDouble()/100}"}
            else -> {return "ERROR"}
        }

    }

    fun getOperator(view: View){
        val button = view as Button

        operator = button.text.get(0)


        operator = when(button.id){
            binding.buttonDivision.id -> {'÷'}
            binding.buttonMultiplicacion.id -> {'×'}
            binding.buttonResta.id -> {'-'}
            binding.buttonSuma.id -> {'+'}
            else -> {'0'}
        }

        firstValue = binding.editTextNumber.text.toString().toDouble()
        binding.editTextNumber.text.clear()

    }

    fun numberButtonClicked(view: View){
        val button = view as Button

        if(button.id.equals(binding.buttonDecimal.id)){
            if(!binding.editTextNumber.text.contains('.')){
                binding.editTextNumber.text.append(button.text)
            }
        }else{
            binding.editTextNumber.text.append(button.text)
        }
        //binding.editTextNumber.text.append(button.text)
/*
        when(button.id){
            binding.buttonDecimal.id -> {
                if(!binding.editTextNumber.text.contains('.')){
                    binding.editTextNumber.text.append(".")
                }
            }
            binding.button0.id -> {binding.editTextNumber.text.append("0")}
            binding.button1.id -> {binding.editTextNumber.text.append("1")}
            binding.button2.id -> {binding.editTextNumber.text.append("2")}
            binding.button3.id -> {binding.editTextNumber.text.append("3")}
            binding.button4.id -> {binding.editTextNumber.text.append("4")}
            binding.button5.id -> {binding.editTextNumber.text.append("5")}
            binding.button6.id -> {binding.editTextNumber.text.append("6")}
            binding.button7.id -> {binding.editTextNumber.text.append("7")}
            binding.button8.id -> {binding.editTextNumber.text.append("8")}
            binding.button9.id -> {binding.editTextNumber.text.append("9")}
            else -> {
                Toast.makeText(this, "else",Toast.LENGTH_SHORT).show()
            }
        }
        */




    }
}