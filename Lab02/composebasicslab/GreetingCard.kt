package lucas.urassa.composebasicslab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingCard() {

    Column(
        modifier = Modifier
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Image(
            painter =
                painterResource(R.drawable.suzalogo),

            contentDescription = null,

            modifier =
                Modifier.size(150.dp)
        )

        Spacer(
            Modifier.height(16.dp)
        )

        Text(
            text =
                stringResource(
                    R.string.welcome_title
                ),

            fontSize = 28.sp
        )

        Text(
            text =
                stringResource(
                    R.string.subtitle
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    GreetingCard()

}