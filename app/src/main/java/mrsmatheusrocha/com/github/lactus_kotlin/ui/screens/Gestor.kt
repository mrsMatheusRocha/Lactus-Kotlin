package mrsmatheusrocha.com.github.lactus_kotlin.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mrsmatheusrocha.com.github.lactus_kotlin.ui.theme.PublicSans

data class NutrizInativa(val nome: String, val regiao: String, val ultimaColeta: String, val status: String)

val mockNutrizes = listOf(
    NutrizInativa("Mariana Silva", "Zona Sul", "Há 35 dias", "Inativa"),
    NutrizInativa("Camila Costa", "Zona Oeste", "Há 42 dias", "Inativa"),
    NutrizInativa("Juliana Santos", "Zona Norte", "Aguardando 1ª coleta", "Qualificando"),
    NutrizInativa("Fernanda Lima", "Zona Leste", "Há 60 dias", "Inativa")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagerScreen(onBackClick: () -> Unit = {}) {
    var activeTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Gestão Lactare", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                        Text("Hospital Maternidade Central", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
                    }
                },
                actions = {
                    IconButton(onClick = { /* Função Exportar */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Exportar", tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Dashboard") },
                    label = { Text("Visão Geral", style = MaterialTheme.typography.bodySmall) },
                    selected = activeTab == 0,
                    onClick = { activeTab = 0 },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Email, contentDescription = "Comunicação") },
                    label = { Text("Engajamento", style = MaterialTheme.typography.bodySmall) },
                    selected = activeTab == 2,
                    onClick = { activeTab = 2 },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Relatórios") },
                    label = { Text("Relatórios", style = MaterialTheme.typography.bodySmall) },
                    selected = activeTab == 1,
                    onClick = { activeTab = 1 },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                .padding(paddingValues)
        ) {
            when (activeTab) {
                0 -> DashboardView()
                1 -> ReportsView()
                2 -> CommunicationView()
            }
        }
    }
}
@Composable
fun DashboardView() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Visão Geral em Tempo Real", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            KpiCard(
                title = "Nutrizes Ativas", value = "1,240", subtitle = "+12% ao mês",
                icon = Icons.Default.Person, iconColor = Color(0xFFF06292), modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Arrecadado", value = "450 L", subtitle = "+8% ao mês",
                icon = Icons.Default.WaterDrop, iconColor = Color(0xFF4ade80), modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            KpiCard(
                title = "Conversão", value = "68%", subtitle = "Nutrizes guiadas",
                icon = Icons.AutoMirrored.Filled.TrendingUp, iconColor = Color(0xFF4ade80), modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Interações", value = "8,432", subtitle = "Mensagens IA",
                icon = Icons.AutoMirrored.Filled.Chat, iconColor = Color(0xFFa855f7), modifier = Modifier.weight(1f)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Crescimento de Coletas", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                Text("Evolução ao longo dos últimos 6 meses", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Spacer(modifier = Modifier.height(24.dp))
                MockLineChart(modifier = Modifier.fillMaxWidth().height(150.dp))
            }
        }
    }
}

@Composable
fun CommunicationView() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Central de Engajamento", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text("Dispare mensagens para recuperar nutrizes inativas.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Buscar por nome ou região...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(mockNutrizes) { nutriz ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(nutriz.nome, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge)
                            Text("${nutriz.regiao} • ${nutriz.ultimaColeta}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))

                            Spacer(modifier = Modifier.height(8.dp))

                            Surface(
                                color = if (nutriz.status == "Inativa") Color(0xFFFEE2E2) else Color(0xFFFEF9C3),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(
                                    text = nutriz.status,
                                    color = if (nutriz.status == "Inativa") Color(0xFFB91C1C) else Color(0xFFA16207),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                        IconButton(
                            onClick = { /* Disparar IA */ },
                            modifier = Modifier.background(Color(0xFF15803D), RoundedCornerShape(12.dp))
                        ) {
                            Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Enviar", tint = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ReportsView() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.AutoMirrored.Filled.Article, contentDescription = null, modifier = Modifier.size(64.dp), tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
        Spacer(modifier = Modifier.height(16.dp))
        Text("Módulo em desenvolvimento", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
        Text("Os relatórios demográficos estão sendo processados pela IA.", textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
    }
}

@Composable
fun KpiCard(title: String, value: String, subtitle: String, icon: ImageVector, iconColor: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(title, style = MaterialTheme.typography.labelSmall, fontFamily = PublicSans, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(subtitle, style = MaterialTheme.typography.labelSmall, color = Color(0xFF4ade80))
        }
    }
}

@Composable
fun MockLineChart(modifier: Modifier = Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Canvas(modifier = modifier) {
        val path = Path().apply {
            moveTo(0f, size.height)
            lineTo(size.width * 0.2f, size.height * 0.7f)
            lineTo(size.width * 0.4f, size.height * 0.5f)
            lineTo(size.width * 0.6f, size.height * 0.6f)
            lineTo(size.width * 0.8f, size.height * 0.2f)
            lineTo(size.width, 0f)
        }
        drawPath(
            path = path,
            color = primaryColor,
            style = Stroke(width = 8f)
        )
        drawCircle(color = primaryColor, radius = 12f, center = Offset(size.width * 0.8f, size.height * 0.2f))
        drawCircle(color = primaryColor, radius = 12f, center = Offset(size.width, 0f))
    }
}