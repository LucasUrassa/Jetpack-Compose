package com.suza.cupcake.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.suza.cupcake.viewmodel.OrderViewModel
import com.suza.cupcake.viewmodel.SettingsViewModel

@Composable
fun CupcakeNavGraph(
    navController: NavHostController,
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Hello App home
        composable("home") {
            HomeScreen(
                onNavigateToGreeting = { name -> navController.navigate("greeting/$name") },
                onNavigateToSettings = { navController.navigate("settings") },
                onNavigateToCupcake = { navController.navigate("cupcake/start") }   // ← NEW
            )
        }

        composable(
            "greeting/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            GreetingScreen(
                name = name,
                onNavigateBack = { navController.navigateUp() }
            )
        }

        // Cupcake flow
        composable("cupcake/start") {
            val orderViewModel: OrderViewModel = viewModel()
            val state by orderViewModel.uiState.collectAsState()
            StartOrderScreen(
                onQuantitySelected = { orderViewModel.setQuantity(it) },
                onNext = { navController.navigate("cupcake/flavor") }
            )
        }

        composable("cupcake/flavor") {
            val orderViewModel: OrderViewModel = viewModel()
            val state by orderViewModel.uiState.collectAsState()
            FlavorScreen(
                currentFlavor = state.flavor,
                onFlavorSelected = { orderViewModel.setFlavor(it) },
                onNext = { navController.navigate("cupcake/pickup") },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable("cupcake/pickup") {
            val orderViewModel: OrderViewModel = viewModel()
            val state by orderViewModel.uiState.collectAsState()
            PickupScreen(
                currentDate = state.pickupDate,
                onDateSelected = { orderViewModel.setPickupDate(it) },
                onNext = { navController.navigate("cupcake/summary") },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable("cupcake/summary") {
            val orderViewModel: OrderViewModel = viewModel()
            val state by orderViewModel.uiState.collectAsState()
            SummaryScreen(
                quantity = state.quantity,
                flavor = state.flavor,
                pickupDate = state.pickupDate,
                price = state.price,
                onNavigateUp = { navController.navigateUp() },
                onSendOrder = { /* shared via intent, nothing needed */ }
            )
        }

        // Settings
        composable("settings") {
            SettingsScreen(
                isDarkTheme = isDarkTheme,
                onToggleTheme = { settingsViewModel.toggleTheme() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}