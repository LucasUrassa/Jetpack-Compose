package lucas.urassa.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoScreen() {

    var input by remember {
        mutableStateOf("")
    }

    val items =
        remember {
            mutableStateListOf<String>()
        }

    Column(
        Modifier.padding(
            20.dp
        )
    ) {

        Row {

            OutlinedTextField(
                input,
                {
                    input = it
                }
            )

            Button(
                {

                    if(
                        input.isNotBlank()
                    ) {

                        items.add(
                            input
                        )

                        input = ""
                    }

                }

            ) {

                Text("Add")
            }
        }

        TodoList(

            items,

            {

                items.add(it)

            },

            {

                items.remove(it)

            }
        )
    }
}

@Composable
fun TodoList(
    items: List<String>,
    onAdd:(String)->Unit,
    onRemove:(String)->Unit
) {

    if(items.isEmpty()) {

        Text(
            "No tasks"
        )

    }

    items.forEach {

        Row {

            Text(
                it,

                Modifier
                    .weight(1f)
            )

            Button(
                {

                    onRemove(it)

                }

            ) {

                Text("✕")
            }
        }
    }
}

@Preview
@Composable
fun TodoPreview() {

    TodoScreen()

}