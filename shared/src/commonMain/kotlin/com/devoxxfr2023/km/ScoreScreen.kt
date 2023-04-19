package com.devoxxfr2023.km


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable()
internal fun scoreScreen(navigator: Navigator, score: String){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
            backgroundColor = Color.Green

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if(!getPlatform().name.contains("ios",true) && !getPlatform().name.contains("js",true))
                    Image(
                        painter = getMyImage("logo"),
                        contentDescription = "Logo of the quiz app", // decorative
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.width(150.dp).padding(20.dp)
                    )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        fontSize = 15.sp,
                        text = "score",
                    )
                    Text(
                        fontSize = 30.sp,
                        text = score,
                    )
                    Button(
                        modifier = Modifier.padding(all = 20.dp),
                        onClick = {
                            navigator.navigate(route = "/quiz")
                        }
                    ) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Localized description")
                        Text(text = "Retake the Quiz",)

                    }
                }
            }
        }
    }
}