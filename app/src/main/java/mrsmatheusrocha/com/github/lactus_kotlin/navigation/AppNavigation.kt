package mrsmatheusrocha.com.github.lactus_kotlin.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Manager : Screen("manager")
    object Cadastro : Screen("cadastro")
}