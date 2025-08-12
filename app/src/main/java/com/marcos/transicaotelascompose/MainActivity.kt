package com.marcos.transicaotelascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcos.transicaotelascompose.ui.theme.TransicaoTelasComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransicaoTelasComposeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Cyan),
        navController = navController,
        startDestination = StringsTelas.TELA_1
    ) {
        composable(StringsTelas.TELA_1) {
            Tela1 { navController.navigate(StringsTelas.TELA_2) }
        }
        composable(StringsTelas.TELA_2) {
            Tela2 { navController.popBackStack() }
        }
    }
}

@Composable
fun Tela1(onNavigate: () -> Unit) {

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Tela1")
        Button(onClick = onNavigate) { Text("ir para Tela2") }
    }
}

@Composable
fun Tela2(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Tela2")
        Button(onClick = onBack) { Text("Voltar") }
    }
}