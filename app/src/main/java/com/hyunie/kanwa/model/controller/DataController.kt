package com.hyunie.kanwa.model.controller

import androidx.compose.runtime.mutableStateListOf
import com.hyunie.kanwa.model.entity.User
import java.util.Locale

object DataController {
    val user: User = User(name = "Huu Nien", lsKanwa = mutableStateListOf())
    var locale: Locale = Locale.getDefault()
}