package com.worldline.quiz

import App
import DatabaseDriverFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(DatabaseDriverFactory(applicationContext).createDriver())
        }
    }
}

/*@Preview
@Composable
fun AppAndroidPreview() {
    App()
}*/