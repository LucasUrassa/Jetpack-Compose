package lucas.urassa.composebasicslab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCard() {

    Column(
        Modifier.fillMaxSize(),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Image(
            painter =
                painterResource(
                    R.drawable.avataricon),

            contentDescription = null,

            modifier =
                Modifier
                    .size(120.dp)
                    .clip(CircleShape)
        )

        Spacer(
            Modifier.height(20.dp)
        )

        Text(
            "Mike",

            fontSize = 22.sp,

            fontWeight =
                FontWeight.Bold
        )

        Text(
            "Android Developer",

            color =
                Color.Gray
        )

        Spacer(
            Modifier.height(24.dp)
        )

        Row {

            Icon(Icons.Default.Email, null)

            Text(" Email")

            Spacer(
                Modifier.width(20.dp)
            )

            Icon(Icons.Default.Phone, null)

            Text(" Phone")

            Spacer(
                Modifier.width(20.dp)
            )

            Icon(
                Icons.Default.Person,
                null
            )

            Text(" LinkedIn")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessPreview() {

    BusinessCard()

}