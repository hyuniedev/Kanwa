package com.hyunie.kanwa.model.entity

import com.hyunie.kanwa.model.controller.DataController

data class KanwaCard(var title: String, var lsPerson: List<Person> = DataController.lsPersonKanwaCardDefault.toList()){
    fun getTotalAmount(): Money{
        val total = Money(amount = 0)
        lsPerson.forEach {
            total.amount += it.money.amount
        }
        return total
    }
}
