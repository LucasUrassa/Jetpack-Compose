package com.suza.cupcake.ui.theme

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suza.cupcake.data.Flavor
import com.suza.cupcake.data.PickupDate

// -----------------------------------------------------------
// StartOrderScreen
// -----------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartOrderScreen(
    onQuantitySelected: (Int) -> Unit,
    onNext: () -> Unit
) {
    var selectedQuantity by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Order Cupcakes") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Select quantity", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            listOf(1, 6, 12).forEach { qty ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedQuantity == qty,
                            onClick = { selectedQuantity = qty },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedQuantity == qty,
                        onClick = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("$qty cupcake${if (qty > 1) "s" else ""}")
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                onQuantitySelected(selectedQuantity)
                onNext()
            }) {
                Text("Next")
            }
        }
    }
}

// -----------------------------------------------------------
// FlavorScreen
// -----------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlavorScreen(
    currentFlavor: Flavor,
    onFlavorSelected: (Flavor) -> Unit,
    onNext: () -> Unit,
    onNavigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Choose Flavor") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pick a flavor", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Flavor.values().forEach { flavor ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = currentFlavor == flavor,
                            onClick = { onFlavorSelected(flavor) },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = currentFlavor == flavor,
                        onClick = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(flavor.name.lowercase().replaceFirstChar { it.uppercase() })
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onNext) {
                Text("Next")
            }
        }
    }
}

// -----------------------------------------------------------
// PickupScreen
// -----------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickupScreen(
    currentDate: PickupDate,
    onDateSelected: (PickupDate) -> Unit,
    onNext: () -> Unit,
    onNavigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pickup Date") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Select pickup date", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            PickupDate.values().forEach { date ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = currentDate == date,
                            onClick = { onDateSelected(date) },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = currentDate == date,
                        onClick = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        when (date) {
                            PickupDate.TODAY -> "Today"
                            PickupDate.TOMORROW -> "Tomorrow"
                            PickupDate.IN_THREE_DAYS -> "In 3 days"
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onNext) {
                Text("Next")
            }
        }
    }
}

// -----------------------------------------------------------
// SummaryScreen
// -----------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryScreen(
    quantity: Int,
    flavor: Flavor,
    pickupDate: PickupDate,
    price: Double,
    onNavigateUp: () -> Unit,
    onSendOrder: (String) -> Unit
) {
    val context = LocalContext.current
    val summaryText = buildString {
        appendLine("Order Summary")
        appendLine("Quantity: $quantity cupcake${if (quantity > 1) "s" else ""}")
        appendLine("Flavor: ${flavor.name.lowercase().replaceFirstChar { it.uppercase() }}")
        appendLine("Pickup: ${when (pickupDate) {
            PickupDate.TODAY -> "Today"
            PickupDate.TOMORROW -> "Tomorrow"
            PickupDate.IN_THREE_DAYS -> "In 3 days"
        }}")
        appendLine("Total: $${"%.2f".format(price)}")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Summary") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(summaryText, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, summaryText)
                }
                context.startActivity(shareIntent)
                onSendOrder(summaryText)
            }) {
                Text("Send Order")
            }
        }
    }
}

// ---------------------------------------------------------------------
// Previews (required: each screen previewable independently)
// ---------------------------------------------------------------------
@Preview(showBackground = true)
@Composable
fun StartOrderScreenPreview() {
    StartOrderScreen(onQuantitySelected = {}, onNext = {})
}

@Preview(showBackground = true)
@Composable
fun FlavorScreenPreview() {
    FlavorScreen(
        currentFlavor = Flavor.CHOCOLATE,
        onFlavorSelected = {},
        onNext = {},
        onNavigateUp = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PickupScreenPreview() {
    PickupScreen(
        currentDate = PickupDate.TOMORROW,
        onDateSelected = {},
        onNext = {},
        onNavigateUp = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SummaryScreenPreview() {
    SummaryScreen(
        quantity = 6,
        flavor = Flavor.VANILLA,
        pickupDate = PickupDate.TODAY,
        price = 10.0,
        onNavigateUp = {},
        onSendOrder = {}
    )
}