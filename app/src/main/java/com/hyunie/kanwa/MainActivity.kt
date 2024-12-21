package com.hyunie.kanwa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hyunie.kanwa.model.controller.DataController
import com.hyunie.kanwa.model.repository.Scenes
import com.hyunie.kanwa.ui.theme.KanwaTheme
import com.hyunie.kanwa.view.scenes.HomeScene
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KanwaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KanwaMainScene(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun KanwaMainScene(modifier: Modifier = Modifier) {
    DataController.locale = Locale("vi","VN")
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Scenes.Home.route) {
        composable(Scenes.Home.route) {
            HomeScene(navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KanwaTheme {
        KanwaMainScene()
    }
}