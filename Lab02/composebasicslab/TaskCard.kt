package lucas.urassa.composebasicslab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard(
    title: String,
    description: String,
    priority: String
) {

    val borderColor =
        when(priority){

            "High" -> Color.Red

            "Medium" -> Color(
                0xFFFF9800
            )

            else -> Color.Green
        }

    Card(
        Modifier.padding(8.dp)
    ) {

        Row {

            Box(
                Modifier
                    .width(8.dp)
                    .fillMaxHeight()
                    .background(
                        borderColor
                    )
            )

            Column(
                Modifier.padding(
                    16.dp
                )
            ) {

                Text(title)

                Text(description)

                Text(priority)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {

    Column {

        TaskCard(
            "Assignment",
            "Complete Lab",
            "High"
        )

        TaskCard(
            "Read",
            "Compose Guide",
            "Medium"
        )

        TaskCard(
            "Practice",
            "Build UI",
            "Low"
        )
    }
}