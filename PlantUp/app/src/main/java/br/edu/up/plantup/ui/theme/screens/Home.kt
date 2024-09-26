import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plantup.ui.theme.Cinza
import br.edu.up.plantup.ui.theme.Laranja
import br.edu.up.plantup.ui.theme.OffWhite
import br.edu.up.plantup.ui.theme.VerdeClaro
import br.edu.up.plantup.ui.theme.VerdeEscuro
import br.edu.up.plantup.ui.theme.screens.visualbar.BottomBar
import br.edu.up.plantup.ui.theme.screens.visualbar.TopBar

@Composable
fun PlantCareSummary(
    adubagem: Float,
    rega: Float,
    sol: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        CareProgressItem(
            title = "Adubagem",
            progress = adubagem,
            color = VerdeClaro
        )

        Spacer(modifier = Modifier.height(35.dp))

        CareProgressItem(
            title = "Rega",
            progress = rega,
            color = Laranja
        )

        Spacer(modifier = Modifier.height(35.dp))

        CareProgressItem(
            title = "Exposição ao Sol",
            progress = sol,
            color = VerdeEscuro
        )
    }
}

@Composable
fun CareProgressItem(title: String, progress: Float, color: Color) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 25.sp,
            color = VerdeEscuro
        )
        Spacer(modifier = Modifier.height(18.dp))

        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(Cinza),
            color = color
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${(progress * 100).toInt()}%",
            fontSize = 25.sp,
            color = VerdeEscuro,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CalendarSection(diasCuidados: List<Int>) {
    val diasMes = (1..30).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp),
            verticalArrangement = Arrangement.spacedBy(17.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            items(diasMes) { dia ->
                DayItem(
                    dia = dia,
                    isCuidado = diasCuidados.contains(dia)
                )
            }
        }
    }
}

@Composable
fun DayItem(dia: Int, isCuidado: Boolean) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = if (isCuidado) VerdeEscuro else OffWhite,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = dia.toString(),
            fontSize = 18.sp,
            color = if (isCuidado) Color.White else VerdeEscuro,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Home (drawerState: DrawerState, navController: NavController) {

    val diasCuidados = listOf(1, 2, 3, 5, 10, 15, 17, 20, 21, 25)

    Scaffold(
        topBar = { TopBar(drawerState) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(OffWhite)
                    .verticalScroll(rememberScrollState())
            ) {
                CalendarSection(diasCuidados)

                PlantCareSummary(
                    adubagem = 0.75f,
                    rega = 0.50f,
                    sol = 0.90f
                )
            }
        }
    )
}