package mrsmatheusrocha.com.github.lactus_kotlin

import LactusApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mrsmatheusrocha.com.github.lactus_kotlin.ui.theme.LactusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LactusTheme {
                LactusApp()
            }
        }
    }
}