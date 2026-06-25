package com.suza.cupcake.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigateToGreeting: (String) -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToCupcake: () -> Unit      // ← NEW parameter
) {
    var name by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToSettings) {
                Text("⚙️")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Your name") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                if (name.isNotBlank()) onNavigateToGreeting(name)
            }) {
                Text("Greet")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // NEW: button to start cupcake order flow
            Button(onClick = onNavigateToCupcake) {
                Text("Order Cupcakes")
            }
        }
    }
}

@Composable
fun GreetingScreen(
    name: String,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello, $name!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}

// Previews (unchanged)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onNavigateToGreeting = {},
        onNavigateToSettings = {},
        onNavigateToCupcake = {}
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    GreetingScreen(name = "Alice", onNavigateBack = {})
}