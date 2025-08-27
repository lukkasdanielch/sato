package com.example.aula20_08

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.aula20_08.ui.theme.Aula2008Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula2008Theme {
                /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(10.dp)
                            .fillMaxSize()
                    ) {
                        TelaLogin {
                            // Quando clicar em Entrar → abre a MainActivity2
                            val intent = Intent(this@MainActivity, SegundaTela::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun TelaLogin(onLogin: () -> Unit) {
        Card(
            colors = CardDefaults.cardColors(Color.Black),
            modifier = Modifier.fillMaxSize().height(180.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
                    .padding(18.dp)
            ) {


                var usuario by remember { mutableStateOf("") }
                var senha by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Person,
                        "img perfil",
                        modifier = Modifier.size(70.dp),
                        Color.White
                    )
                    /*Image(
                    painter = painterResource(id = R.drawable.sato),
                    contentDescription = "Logo do app",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp)
                        .padding(top = 16.dp),
                    contentScale = ContentScale.Fit
                )*/
                    TextField(

                        value = usuario,
                        onValueChange = { usuario = it },
                        label = { Text("usuario") },
                        modifier = Modifier.fillMaxWidth(),


                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = senha,
                        onValueChange = { senha = it },
                        label = { Text("Senha") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        onClick = { onLogin() }) {
                        Text("Entrar")
                    }


                }

            }

        }
    }
}




