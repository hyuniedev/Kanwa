package com.hyunie.kanwa.model.repository

sealed class Scenes(val route: String){
    data object Home : Scenes("home")
}