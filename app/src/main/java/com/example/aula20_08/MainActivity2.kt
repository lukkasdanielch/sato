package com.example.aula20_08

import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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

class MainActivity2 : ComponentActivity() {
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
                        TelaComGridEBotao()
                           allan


                    }

                }
            }
        }
    }

    @Composable
    fun TelaComGridEBotao()  {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Campo de pesquisa
            Pesquisar()

            Spacer(modifier = Modifier.height(16.dp))

            // Grid de cards
            Box(modifier = Modifier.weight(1f)) { // ocupa o espaço disponível
                GridDeCards()
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão abaixo do grid
            Botao(){
                val intent = Intent(this@MainActivity2, terceiraTela::class.java)
                startActivity(intent)
            }
        }
    }


    @Composable
    fun Pesquisar() {
        var pesquisar by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth() // 👈 só largura, não altura total
                .padding(16.dp),
        ) {
            TextField(
                value = pesquisar,
                onValueChange = { pesquisar = it },
                label = { Text("Pesquisar") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

    data class Carro(val nome: String, val placa: String, val imagem: Int)


    @Composable
    fun GridDeCards() {
        val listaCarros = listOf(
            Carro("HB20", "MLV3I33", R.drawable.hb20),
            Carro("Onix", "ABC1234", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("celta", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),
            Carro("Gol", "XYZ9876", R.drawable.hb20),
            Carro("Civic", "HJK4567", R.drawable.hb20),

            )

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
            items(listaCarros) { carro ->
                CardCarro(carro)
            }

        }
    }

    @Composable
    fun CardCarro(carro: Carro) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = carro.imagem),
                    contentDescription = carro.nome,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(carro.nome)
                Text(carro.placa, style = MaterialTheme.typography.bodySmall)
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
                        containerColor = Color(0xFF1E88E5),
                        contentColor = Color.White
                    )
                ) {
                    Text("+")
                }
            }
        }
    }
    @Composable
    fun Botao(onLogin: () -> Unit) {

        Button(
            onClick = { onLogin()},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E88E5),
                contentColor = Color.White
            )
        ) {
            Text("+ Adicionar Carro")
        }
    }
}
