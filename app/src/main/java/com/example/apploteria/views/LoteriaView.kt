package com.example.apploteria.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.apploteria.ViewModels.LoteriaViewModel

fun LoteriaView(viewModel: LoteriaViewModel){
    val lottoNumbers = viewModel.lottoNumbers.value

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (lottoNumbers.isEmpty){
            Text(text = "Loteria", fontSize = 40.sp, fontWeight = fontWeight.Bold)
        }else{
            LotteryNumbers(numbers = lottoNumbers)
        }
        Button(onClick = { viewModel.generateLottoNumbers() }){
            Text(text = "Generar", fontSize = 20.sp, fontWeight = fontWeight.Bold)
        }
    }
}

@Composable
fun LotteryNumbers(numbers: List<Int>){
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 0.dp
        )
    ){
        items(numbers) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape)
            ){
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}