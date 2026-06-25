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
fun Quadrant(
    title: String,
    body: String,
    color: Color,
    modifier: Modifier
) {

    Column(
        modifier
            .background(color)
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(title)

        Spacer(
            Modifier.height(8.dp)
        )

        Text(body)
    }
}

@Composable
fun FourQuadrant() {

    Column {

        Row(
            Modifier.weight(1f)
        ) {

            Quadrant(
                "Text",
                "Displays text",
                Color.Green,
                Modifier.weight(1f)
            )

            Quadrant(
                "Image",
                "Shows images",
                Color.Cyan,
                Modifier.weight(1f)
            )
        }

        Row(
            Modifier.weight(1f)
        ) {

            Quadrant(
                "Row",
                "Horizontal layout",
                Color.Yellow,
                Modifier.weight(1f)
            )

            Quadrant(
                "Column",
                "Vertical layout",
                Color.Magenta,
                Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {

    FourQuadrant()

}