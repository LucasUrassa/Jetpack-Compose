package lucas.urassa.composebasicslab

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(
    ExperimentalMaterial3Api::class
)

@Composable
fun ComponentsShowcase() {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        "Components"
                    )
                }
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {}
            ) {

                Icon(
                    Icons.Default.Add,
                    null
                )
            }
        }

    ) { padding ->

        Column(
            Modifier
                .padding(
                    padding
                )
                .padding(20.dp)
        ) {

            Card {

                Text(
                    "Material Card",

                    Modifier.padding(
                        20.dp
                    )
                )
            }

            Spacer(
                Modifier.height(
                    20.dp
                )
            )

            Button(
                {}
            ) {

                Text(
                    "Button"
                )
            }

            OutlinedButton(
                {}
            ) {

                Text(
                    "Outlined"
                )
            }

            TextButton(
                {}
            ) {

                Text(
                    "Text"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowcasePreview() {

    ComponentsShowcase()

}