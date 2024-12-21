package com.hyunie.kanwa.model.entity

import com.hyunie.kanwa.model.controller.DataController

data class Kanwa(var title: String = "New Kanwa", var lsPerson: List<Person> = listOf(DataController.user), var completed:Boolean = false){
    fun getTotalAmount(): Money{
        val total = Money(amount = 0)
        lsPerson.forEach {
            total.amount += it.money.amount
        }
        return total
    }
}
