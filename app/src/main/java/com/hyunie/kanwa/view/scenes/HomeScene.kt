package com.hyunie.kanwa.view.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hyunie.kanwa.view.components.CardKanwa
import com.hyunie.kanwa.view.components.MyFAB
import com.hyunie.kanwa.view.components.MyTopAppBar

@Composable
fun HomeScene(navController: NavController = rememberNavController()){
    Scaffold(topBar = {
        MyTopAppBar()
    },
        floatingActionButton = { MyFAB() }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 15.dp, vertical = 20.dp)) {
            CardKanwa()
        }
    }
}