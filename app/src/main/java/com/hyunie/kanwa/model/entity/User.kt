package com.hyunie.kanwa.model.entity

import androidx.compose.runtime.mutableStateListOf

data class User(
    val id: String = "",
    override var name: String,
    val lsKanwa: MutableList<Kanwa> = mutableListOf()
) : Person(name)