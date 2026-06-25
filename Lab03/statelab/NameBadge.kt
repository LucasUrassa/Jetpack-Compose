package lucas.urassa.statelab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NameBadge() {

    var first by remember {
        mutableStateOf("")
    }

    var last by remember {
        mutableStateOf("")
    }

    var size by remember {
        mutableStateOf(24f)
    }

    var color by remember {
        mutableStateOf(Color.Black)
    }

    Column(
        Modifier.padding(20.dp)
    ) {

        OutlinedTextField(
            first,
            { first = it },

            label = {
                Text("First Name")
            }
        )

        OutlinedTextField(
            last,
            { last = it },

            label = {
                Text("Last Name")
            }
        )

        Text(
            "Font Size"
        )

        Slider(
            value = size,

            onValueChange = {
                size = it
            },

            valueRange =
                0f..72f
        )

        Row {

            listOf(
                Color.Red,
                Color.Blue,
                Color.Green,
                Color.Black
            ).forEach {

                Box(
                    Modifier
                        .size(40.dp)
                        .padding(4.dp)
                        .background(
                            it,
                            CircleShape
                        )
                        .clickable {
                            color = it
                        }
                )
            }
        }

        Spacer(
            Modifier.height(
                20.dp
            )
        )

        Card {

            Text(
                "$first $last",

                Modifier.padding(
                    30.dp
                ),

                fontSize =
                    size.sp,

                color =
                    color
            )
        }
    }
}

@Preview
@Composable
fun BadgePreview() {

    NameBadge()

}