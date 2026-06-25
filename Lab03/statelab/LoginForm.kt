package lucas.urassa.statelab

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm() {

    val context =
        LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var show by remember {
        mutableStateOf(false)
    }

    var status by remember {
        mutableStateOf("")
    }

    val valid =
        email.contains("@")
                &&
                password.length >= 6

    Column(
        Modifier.padding(
            20.dp
        )
    ) {

        OutlinedTextField(
            email,
            {
                email = it
            },

            label = {
                Text("Email")
            },

            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Email
                )
        )

        OutlinedTextField(

            password,

            {
                password = it
            },

            label = {
                Text("Password")
            },

            visualTransformation =

                if(show)
                    VisualTransformation.None

                else
                    PasswordVisualTransformation()
        )

        Row {

            Checkbox(
                show,
                {
                    show = it
                }
            )

            Text(
                "Show Password"
            )
        }

        Button(

            enabled =
                valid,

            onClick = {

                status =
                    "Login Success"

                Toast
                    .makeText(
                        context,
                        status,
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }

        ) {

            Text("Login")
        }

        Text(status)
    }
}

@Preview
@Composable
fun LoginPreview() {

    LoginForm()

}