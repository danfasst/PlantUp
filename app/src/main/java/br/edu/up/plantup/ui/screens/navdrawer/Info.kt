package br.edu.up.plantup.ui.screens.navdrawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.ui.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.screens.visualbar.TopBar
import br.edu.up.plantup.ui.theme.Preto
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro

data class Planta(val nome: String, val descricao: String)

@Composable
fun Info(drawerState: DrawerState, navControllerBottomNav: NavController) {

    val plantas = listOf(
        Planta(
            nome = "Espada de São Jorge",
            descricao = "Uma planta muito resistente, ideal para purificação do ar.",
            //imagem = painterResource(id = R.drawable.espada)
        ),
        Planta(
            nome = "Suculenta",
            descricao = "Fácil de cuidar, as suculentas armazenam água em suas folhas.",
            //imagem = painterResource(id = R.drawable.suculenta)
        ),
        Planta(
            nome = "Orquídea",
            descricao = "Conhecida por suas flores belas e delicadas.",
            //imagem = painterResource(id = R.drawable.orquidea)
        ),
        Planta(
            nome = "Ficus Lyrata",
            descricao = "Uma planta com folhas largas, perfeita para ambientes internos.",
//            imagem = painterResource(id = R.drawable.ficus)
        )
    )

    Scaffold(
        topBar = {
            TopBar(drawerState)
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(plantas) { planta ->
                    PlantaCard(planta = planta)
                }
            }
        },
        bottomBar = { BottomBar(navControllerBottomNav) }
    )
}

@Composable
fun PlantaCard(planta: Planta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = VerdeClaro),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Image(
//                painter = leaf,
//                contentDescription = "Imagem de ${planta.nome}",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(8.dp)
//            )
//            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = planta.nome,
                fontSize = 24.sp,
                color = VerdeEscuro,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = planta.descricao,
                fontSize = 16.sp,
                color = Preto,
                textAlign = TextAlign.Center
            )
        }
    }
}
