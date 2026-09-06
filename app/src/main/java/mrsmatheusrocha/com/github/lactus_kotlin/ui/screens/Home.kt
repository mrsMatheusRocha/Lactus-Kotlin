import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.alpha


// 1. Dados Mockados (Exigência da Sprint 3 - Sem API real)
data class HospitalMock(
    val id: Int,
    val nome: String,
    val distancia: Double,
    val horario: String
)

val hospitaisMock = listOf(
    HospitalMock(1, "Maternidade Hospital Geral São Mateus", 2.5, "18:00"),
    HospitalMock(2, "Hospital São Camilo Pompeia", 20.0, "20:00"),
    HospitalMock(3, "Hospital Geral de Vila Nova Cachoeirinha", 7.5, "21:00")
)

// 2. Tela Principal (Home)
@Composable
fun HomeScreen(onHospitalClick: (Int) -> Unit = {}) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
    ) {
        HeroSection()
        Spacer(modifier = Modifier.height(24.dp))
        ListaPostosSection(onHospitalClick)
        MapboxPlaceholder()
        Spacer(modifier = Modifier.height(24.dp))
        GuiaIASection()
    }
}

// 3. Seção 1: Boas-vindas (Hero)
@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        // Badge "Zero Atrito"
        Surface(
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Zero Atrito. 100% Amor.",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Text(
            text = "Sua doação de leite salva vidas.",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Nós facilitamos o caminho.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Olá, mamãe! Sabemos como sua rotina é corrida. No Lactus, você encontra pontos de coleta e tira dúvidas pelo WhatsApp em segundos.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botão WhatsApp
        Button(
            onClick = { /* Ação Mockada */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF15803D)), // Verde WhatsApp
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(Icons.Default.Phone, contentDescription = "WhatsApp")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Falar com Assistente no WhatsApp", style = MaterialTheme.typography.labelLarge)
        }
    }
}

// 4. Seção 2: Lista de Postos de Coleta (Substitui o Mapbox na Sprint 3)
@Composable
fun ListaPostosSection(onHospitalClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Bancos de Leite Próximos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Toque em um posto para ver detalhes.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        hospitaisMock.forEach { hospital ->
            Card(
                onClick = { onHospitalClick(hospital.id) },
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = hospital.nome, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = "A ${hospital.distancia} km de você • Até as ${hospital.horario}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                        )
                    }
                }
            }
        }
    }
}

// 5. Seção 3: Guia IA (Lia)
@Composable
fun GuiaIASection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
            .padding(24.dp)
    ) {
        Text(
            text = "Sua Assistente Pessoal",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Simulação do Chat
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Face,
                        contentDescription = "Lia",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Lia - Guia Lactus", style = MaterialTheme.typography.titleMedium)
                        Text("Online agora", color = Color(0xFF4ADE80), fontSize = 12.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 16.dp)
                        )
                        .padding(12.dp)
                ) {
                    Text(
                        "Olá! O leite ordenhado pode ficar na geladeira por até 12 horas. Quer que eu agende uma coleta domiciliar?",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun MapboxPlaceholder() {
    // 1. Criar a animação equivalente ao "animate-pulse" do Tailwind
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.4f, // Vai até 40% de opacidade e volta
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

    // 2. Container absoluto (bg-primary/5 flex items-center justify-center)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // Altura reservada para a visualização do mapa
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)),
        contentAlignment = Alignment.Center
    ) {
        // 3. Card do centro com a animação de pulso (bg-background p-4 rounded-xl shadow-xl)
        Surface(
            modifier = Modifier.alpha(alpha), // Aplica a animação no card
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.background,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp), // p-4
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícone do MapPin
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Pin de Mapa",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp)) // gap-3

                // Texto de carregamento
                Text(
                    text = "Carregando mapa interativo...",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium, // font-medium
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}