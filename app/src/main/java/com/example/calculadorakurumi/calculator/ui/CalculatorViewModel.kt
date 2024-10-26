package com.example.calculadorakurumi.calculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {

    // SCREEN PANEL
    private val _panel = MutableLiveData<String>()
    val panel: LiveData<String> = _panel

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun onOperationSelected(data: String) {
        val panelValue = _panel.value ?: "0"
        val resultValue = _result.value ?: "0"

        when (data) {
            "suma" -> appendOperation("+")
            "resta" -> appendOperation("-")
            "division" -> appendOperation("/")
            "multiplicacion" -> appendOperation("*")
            "igual" -> calculateResult(resultValue, panelValue)
        }
    }

    private fun appendOperation(operation: String) {
        _result.value = _panel.value + operation
        resetPanel()
    }

    private fun calculateResult(resultValue: String, panelValue: String) {
        val operation = resultValue.last().toString()
        val auxSplit = resultValue.dropLast(1).split(operation)
        val num1 = auxSplit[0].toDoubleOrNull() ?: 0.0
        val num2 = panelValue.toDoubleOrNull() ?: 0.0

        _panel.value = when (operation) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> (num1 / num2).toString()
            else -> "0"
        }
        _result.value = "0"
    }

    private fun resetPanel() {
        _panel.value = "0"
    }

    private fun resetResult(){
        _result.value = "0"
    }

    fun onAcSelected() {
        resetResult()
        resetPanel()
    }

    fun onCSelected() {
        resetPanel()
    }

    fun onDeleteSelected() {
        _panel.value = _panel.value?.dropLast(1).takeIf { !it.isNullOrEmpty() } ?: "0"
    }

    fun onNumberSelected(data: String) {
        val aux = _panel.value ?: "0"
        if(aux.contains("null")){
            _panel.value = "0"
        }
        _panel.value = if (_panel.value == "0") {
            if (data == ".") "0." else data
        } else if ((_panel.value?.length ?: 0) <= 11) {
            _panel.value + data
        } else {
            _panel.value
        }
    }
}