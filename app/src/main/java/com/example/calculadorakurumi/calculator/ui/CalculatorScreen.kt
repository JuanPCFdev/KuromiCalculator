package com.example.calculadorakurumi.calculator.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadorakurumi.R

@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel) {

    val handjetFamily = FontFamily(
        Font(R.font.handjet_black, FontWeight.Black),
        Font(R.font.handjet_bold, FontWeight.Bold),
        Font(R.font.handjet_extra_bold, FontWeight.ExtraBold),
        Font(R.font.handjet_extra_light, FontWeight.ExtraLight),
        Font(R.font.handjet_light, FontWeight.Light),
        Font(R.font.handjet_medium, FontWeight.Medium),
        Font(R.font.handjet_regular, FontWeight.Normal),
        Font(R.font.handjet_semi_bold, FontWeight.SemiBold),
        Font(R.font.handjet_thin, FontWeight.Thin),
    )

    val data: String by calculatorViewModel.panel.observeAsState(initial = "0")
    val result: String by calculatorViewModel.result.observeAsState(initial = "0")

    Box(modifier = Modifier.fillMaxSize().padding(bottom = 20.dp)) {
        BackgroundKuromi()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            DataPanel(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                handjetFamily,
                data,
                result
            )
            Spacer(modifier = Modifier.height(50.dp))
            KeyBoard(
                Modifier
                    .fillMaxWidth()
                    .weight(3f),
                calculatorViewModel
            )
        }
    }
}

@Composable
fun DataPanel(modifier: Modifier, handjetFamily: FontFamily, text: String, result: String) {
    Box(
        modifier = modifier
            .background(Color(0xB3FFFFFF))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = result,
                fontSize = 24.sp,
                fontFamily = handjetFamily,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = text,
                fontSize = 64.sp,
                fontFamily = handjetFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun KeyBoard(modifier: Modifier, calculatorViewModel: CalculatorViewModel) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.ac
            ) { calculatorViewModel.onAcSelected() }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.c
            ) { calculatorViewModel.onCSelected() }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.delete
            ) { calculatorViewModel.onDeleteSelected() }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.division
            ) { calculatorViewModel.onOperationSelected("division") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.seven
            ) { calculatorViewModel.onNumberSelected("7") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.eight
            ) { calculatorViewModel.onNumberSelected("8") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.nine
            ) { calculatorViewModel.onNumberSelected("9") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.multi
            ) { calculatorViewModel.onOperationSelected("multiplicacion") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.four
            ) { calculatorViewModel.onNumberSelected("4") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.five
            ) { calculatorViewModel.onNumberSelected("5") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.six
            ) { calculatorViewModel.onNumberSelected("6") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.resta
            ) { calculatorViewModel.onOperationSelected("resta") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.one
            ) { calculatorViewModel.onNumberSelected("1") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.two
            ) { calculatorViewModel.onNumberSelected("2") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.three
            ) { calculatorViewModel.onNumberSelected("3") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.suma
            ) { calculatorViewModel.onOperationSelected("suma") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            ButtonKuromi(
                modifier = Modifier
                    .weight(2f),
                painter = R.drawable.cero
            ) { calculatorViewModel.onNumberSelected("0") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.point
            ) { calculatorViewModel.onNumberSelected(".") }
            Spacer(modifier = Modifier.width(5.dp))
            ButtonKuromi(
                modifier = Modifier
                    .weight(1f),
                painter = R.drawable.igual
            ) { calculatorViewModel.onOperationSelected("igual") }
        }

    }
}

@Composable
fun ButtonKuromi(modifier: Modifier, painter: Int, number: () -> Unit) {
    OutlinedButton(
        modifier = modifier
            .fillMaxSize(),
        onClick = { number() },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color(0xB3FFFFFF)
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun BackgroundKuromi() {
    Image(
        painter = painterResource(id = R.drawable.kuromi_background),
        contentDescription = "KuromiBackground",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}
