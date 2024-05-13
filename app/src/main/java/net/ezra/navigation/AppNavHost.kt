package net.ezra.navigation
import android.window.SplashScreen
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.about.AboutScreen
//import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.LoginnScreen
import net.ezra.ui.auth.RegisterScreen
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.evening.EveningScreen
import net.ezra.ui.getstarted.StartScreen
import net.ezra.ui.help.HelpScreen
import net.ezra.ui.home.homeScreen
import net.ezra.ui.map.MapScreen
import net.ezra.ui.mit.MitScreen
//import net.ezra.ui.products.AddProductScreen
//import net.ezra.ui.products.ProductDetailScreen
//import net.ezra.ui.products.ProductListScreen
//import net.ezra.ui.products.ProductsScreen
import net.ezra.ui.services.ServicesScreen
import net.ezra.ui.shop.ShopScreen
import net.ezra.ui.signin.SigninScreen
import net.ezra.ui.signup.SignupScreen
import net.ezra.ui.splash.SplashScreen
import net.ezra.ui.students.UpdateScreen
import net.ezra.ui.students.ViewreportScreen



@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGIN) {
            LoginnScreen(navController = navController){}
        }


//        composable(ROUTE_SIGNUP) {
//            SignupScreen(navController)
//        }


        composable(ROUTE_HOME) {
            homeScreen(navController)
        }


        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUTE_SERVICES) {
            ServicesScreen(navController)
        }

        composable(ROUTE_MIT) {
            MitScreen(navController)
        }

        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUTE_SHOP) {
            ShopScreen(navController)
        }

        composable(ROUTE_PRODUCTS) {
            ShopScreen(navController)
        }

        composable(ROUTE_EVENING) {
            EveningScreen(navController)
        }
//        composable(ROUTE_ADD_STUDENTS) {
//            AddStudents(navController)
//        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_START) {
            SplashScreen(navController)
        }

        composable(ROUTE_SIGNIN) {
            SigninScreen(navController)
        }

        composable(ROUTE_REPORT) {
            UpdateScreen(navController)
        }

        composable(ROUTE_HELP) {
            HelpScreen(navController)
        }

        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }

        composable(ROUTE_VIEW) {
            ViewreportScreen(navController = navController, viewModel = viewModel())
        }

        composable(ROUTE_REGISTER) {
           RegisterScreen(navController = navController){}
        }




























//        composable(ROUTE_ALERT) {
//            AddProductScreen(navController = navController){}
//        }

//        composable(ROUTE_VIEW_INCIDENT) {
//            ProductListScreen(navController = navController, products = listOf() )
//        }
//
//        composable("productDetail/{productId}") { backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("productId") ?: ""
//            ProductDetailScreen(navController, productId)
//        }



































    }
}