package com.hyunie.kanwa.model.entity

import com.hyunie.kanwa.model.controller.DataController
import java.text.NumberFormat
import java.util.Locale

class Money(var amount: Long) {
    fun displayMoney(): String {
        val formatter = NumberFormat.getCurrencyInstance(DataController.locale)
        return formatter.format(amount)
    }
}