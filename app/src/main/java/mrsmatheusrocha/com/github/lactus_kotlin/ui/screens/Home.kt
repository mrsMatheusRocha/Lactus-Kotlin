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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import mrsmatheusrocha.com.github.lactus_kotlin.ui.components.LactusFooter
import mrsmatheusrocha.com.github.lactus_kotlin.ui.components.LactusScaffold


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

@Composable
fun HomeScreen(onHospitalClick: (Int) -> Unit = {}, onLoginClick: () -> Unit = {}) {
    val scrollState = rememberScrollState()

    LactusScaffold(
        onNavigateHome = { },
        onNavigateLogin = onLoginClick
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            HeroSection()
            Spacer(modifier = Modifier.height(24.dp))
            ListaPostosSection(onHospitalClick)
            Spacer(modifier = Modifier.height(24.dp))
            MapboxPlaceholder()
            Spacer(modifier = Modifier.height(24.dp))
            GuiaIASection()
            Spacer(modifier = Modifier.weight(1f))
            LactusFooter()
        }
    }
}

@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
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

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF15803D)),
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

@Composable
fun ListaPostosSection(onHospitalClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Bancos de Leite Próximos",
            style = MaterialTheme.typography.headlineLarge,
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

@Composable
fun GuiaIASection(
    onCadastroClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
            .padding(24.dp)
    ) {
        // Título Principal
        Text(
            text = "Sua Assistente Pessoal 24h por dia",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "A Lia é nossa inteligência artificial treinada por especialistas em aleitamento. Ela está sempre pronta no WhatsApp para:",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            ItemBeneficioIA(
                icon = Icons.Default.Info,
                text = "Tirar dúvidas sobre ordenha, armazenamento e cuidados."
            )
            ItemBeneficioIA(
                icon = Icons.Default.Favorite,
                text = "Oferecer apoio emocional e dicas para a amamentação."
            )
            ItemBeneficioIA(
                icon = Icons.AutoMirrored.Filled.ArrowForward,
                text = "Agendar coletas em domicílio sem burocracia."
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onCadastroClick,
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.height(48.dp)
        ) {
            Text(text = "Conhecer a Lia", style = MaterialTheme.typography.labelLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color.White,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = "Lia",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Lia - Guia Lactus",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(Color(0xFF4ADE80), RoundedCornerShape(50))
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Online agora",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    BalaoMensagem(
                        texto = "Olá! Como posso ajudar na sua jornada de amamentação hoje? Você tem dúvidas sobre a ordenha?",
                        isDeLia = true
                    )
                    BalaoMensagem(
                        texto = "Sim, posso guardar o leite na geladeira antes de doar?",
                        isDeLia = false
                    )
                    BalaoMensagem(
                        texto = "Ótima pergunta! O leite ordenhado pode ficar na geladeira por até 12 horas. Se for congelar, pode ficar por até 15 dias. Quer que eu agende uma coleta para o que você já tem?",
                        isDeLia = true
                    )
                }
            }
        }
    }
}

@Composable
fun ItemBeneficioIA(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
            shape = RoundedCornerShape(50),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
            modifier = Modifier.size(36.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun BalaoMensagem(texto: String, isDeLia: Boolean) {
    val alignment = if (isDeLia) Alignment.CenterStart else Alignment.CenterEnd
    val backgroundColor = if (isDeLia) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = alignment
    ) {
        Surface(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (isDeLia) 4.dp else 16.dp,
                bottomEnd = if (isDeLia) 16.dp else 4.dp
            ),
            color = backgroundColor,
            shadowElevation = 1.dp,
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            Text(
                text = texto,
                modifier = Modifier.padding(12.dp),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun MapboxPlaceholder() {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.alpha(alpha),
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.background,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Pin de Mapa",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Carregando mapa interativo...",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}