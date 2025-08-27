package com.example.aula20_08

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula20_08.ui.theme.Aula2008Theme

class terceiraTela : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula2008Theme {
                Scaffold { innerPadding ->

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(10.dp)
                            .fillMaxSize()
                            .background(Color.Black) //
                    ) {
                        tela3()
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun tela3() {
        var modelo by remember { mutableStateOf("")}
            var placa by remember { mutableStateOf("") }
        Column(modifier = Modifier.padding(10.dp)) {



                    TextField(
                        value = modelo,
                        onValueChange = { modelo = it },
                        label = { Text("Modelo") },
                        modifier = Modifier
                            .fillMaxWidth()

                    )

                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    TextField(
                        value = placa,
                        onValueChange = { placa = it },
                        label = { Text("Placa") },
                        modifier = Modifier
                            .fillMaxWidth()


                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.weight(1f)) { // ocupa o espaço disponível
                GridDeCards()
            }

            Salvar() {
                val intent = Intent(this@terceiraTela, SegundaTela::class.java)
                startActivity(intent)
            }

            }

        }



    @Composable
    fun GridDeCards() {


        LazyVerticalGrid(
            columns = GridCells.Fixed(3), //
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                BotaoAdicionar()
            }

            }



    }



    @Composable
    fun BotaoAdicionar() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            elevation = CardDefaults.cardElevation(6.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { /* ação do botão */ },
                    modifier = Modifier

                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFAA162C),
                        contentColor = Color.White
                    )
                ) {
                    Text("+")
                }
            }
        }
    }
    @Composable
    fun Salvar(onLogin: () -> Unit) {

        Button(
            onClick = { onLogin()},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFAA162C),
                contentColor = Color.White
            )
        ) {
            Text("Salvar")
        }
    }
    }


