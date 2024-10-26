package com.example.calculadorakurumi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.calculadorakurumi.calculator.ui.CalculatorScreen
import com.example.calculadorakurumi.calculator.ui.CalculatorViewModel
import com.example.calculadorakurumi.ui.theme.CalculadoraKurumiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraKurumiTheme {
                CalculatorScreen(calculatorViewModel)
            }
        }
    }
}
