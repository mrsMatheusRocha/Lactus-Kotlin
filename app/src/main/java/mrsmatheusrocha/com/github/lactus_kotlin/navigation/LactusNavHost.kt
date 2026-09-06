import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mrsmatheusrocha.com.github.lactus_kotlin.navigation.Screen
import mrsmatheusrocha.com.github.lactus_kotlin.ui.CadastroNutrizScreen
import mrsmatheusrocha.com.github.lactus_kotlin.ui.LoginScreen

@Composable
fun LactusApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Login.route) {
            LoginScreen(
                onGestorClick = { navController.navigate(Screen.Manager.route) },
                onCadastroClick = { navController.navigate(Screen.Cadastro.route) },
            )
        }

        composable(route = Screen.Home.route) {
            HomeScreen(
                onLoginClick = {navController.navigate(Screen.Login.route)})
        }

        composable(route = Screen.Cadastro.route) {
            CadastroNutrizScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
//
//        composable(route = Screen.Manager.route) {
//            ManagerScreenMock(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
    }
}