package lucas.urassa.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterApp() {

    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            "$count",
            fontSize = 48.sp
        )

        Spacer(
            Modifier.height(20.dp)
        )

        Row {

            Button(
                onClick = {
                    if(count > 0)
                        count--
                }
            ) {
                Text("-")
            }

            Spacer(
                Modifier.width(10.dp)
            )

            Button(
                onClick = {
                    count++
                }
            ) {
                Text("+")
            }
        }

        Spacer(
            Modifier.height(12.dp)
        )

        Button(
            onClick = {
                count = 0
            }
        ) {
            Text("Reset")
        }
    }
}

@Preview
@Composable
fun CounterPreview() {

    CounterApp()

}