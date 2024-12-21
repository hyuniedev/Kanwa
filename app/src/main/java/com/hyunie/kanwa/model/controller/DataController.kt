package com.hyunie.kanwa.model.controller

import com.hyunie.kanwa.model.entity.Person
import java.util.Locale

object DataController {
    val lsPersonKanwaCardDefault = listOf(Person("Huu Nien"))
    var locale = Locale.getDefault()
}