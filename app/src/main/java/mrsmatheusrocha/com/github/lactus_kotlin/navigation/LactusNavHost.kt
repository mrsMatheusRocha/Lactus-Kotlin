import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mrsmatheusrocha.com.github.lactus_kotlin.navigation.Screen

@Composable
fun LactusApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Login.route) {
//            LoginScreenMock(
//                onLoginClick = { navController.navigate(Screen.Home.route) },
//                onGestorClick = { navController.navigate(Screen.Manager.route) }
//            )
        }

        composable(route = Screen.Home.route) {
            HomeScreen()
        }

//        composable(route = Screen.Cadastro.route) {
//            CadastroNutrizMock(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//
//        composable(route = Screen.Manager.route) {
//            ManagerScreenMock(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
    }
}