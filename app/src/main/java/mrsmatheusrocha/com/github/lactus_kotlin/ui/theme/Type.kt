package mrsmatheusrocha.com.github.lactus_kotlin.ui.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fiap.lactus.R

// Declarar a família de fontes Public Sans (Títulos e Destaques da Eurofarma)
val PublicSans = FontFamily(
    Font(R.font.public_sans_regular, FontWeight.Normal),
    Font(R.font.public_sans_medium, FontWeight.Medium), // Para o Public Sans medium e Loos medium mencionados no manual
    Font(R.font.public_sans_bold, FontWeight.Bold)      // Para os destaques em negrito
)

// 2. Declarar a família de fontes Arial (Textos de apoio)
val Arial = FontFamily(
    Font(R.font.arial_regular, FontWeight.Normal),
    Font(R.font.arial_bold, FontWeight.Bold)
)

// 3. Configurar a Tipografia vinculando as regras da marca aos componentes do Compose
val Typography = Typography(

    // Títulos e Cabeçalhos (Sempre em Public Sans)
    headlineLarge = TextStyle(
        fontFamily = PublicSans,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = PublicSans,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = PublicSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),

    // Textos de Apoio e Parágrafos (Sempre em Arial)
    bodyLarge = TextStyle(
        fontFamily = Arial,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Arial,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),

    // Botões e CTAs (Usamos Public Sans Medium para dar destaque)
    labelLarge = TextStyle(
        fontFamily = PublicSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)