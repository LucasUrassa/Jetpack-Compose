package lucas.urassa.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

@Composable
fun TipCalculatorScreen() {

    var bill by remember {
        mutableStateOf("")
    }

    var tip by remember {
        mutableStateOf("15")
    }

    var round by remember {
        mutableStateOf(false)
    }

    TipCalculator(
        bill,
        tip,
        round,

        { bill = it },

        { tip = it },

        { round = it }
    )
}

@Composable
fun TipCalculator(
    bill: String,
    percentage: String,
    roundUp: Boolean,
    onBillChange: (String)->Unit,
    onTipChange: (String)->Unit,
    onRoundChange:(Boolean)->Unit
) {

    val amount =
        bill.toDoubleOrNull() ?: 0.0

    val percent =
        percentage.toDoubleOrNull()
            ?: 15.0

    var result =
        amount * percent / 100

    if(roundUp)
        result =
            ceil(result)

    val total =
        amount + result

    Column(
        Modifier.padding(20.dp)
    ) {

        OutlinedTextField(
            value = bill,

            onValueChange =
                onBillChange,

            label = {
                Text("Bill")
            },

            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                )
        )

        Spacer(
            Modifier.height(12.dp)
        )

        OutlinedTextField(
            value =
                percentage,

            onValueChange =
                onTipChange,

            label = {
                Text("Tip %")
            },

            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                )
        )

        Row {

            Switch(
                checked =
                    roundUp,

                onCheckedChange =
                    onRoundChange
            )

            Text(
                "Round up tip"
            )
        }

        Text(
            "Tip: %.2f".format(result)
        )

        Text(
            "Total: %.2f".format(total)
        )
    }
}

@Preview
@Composable
fun TipPreview() {

    TipCalculatorScreen()

}