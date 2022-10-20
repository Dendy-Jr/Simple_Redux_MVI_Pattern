package ui.dendi.simplereduxmvipattern.domain.repository

import ui.dendi.simplereduxmvipattern.domain.model.Number

interface NumbersRepository {

    suspend fun getNumbers(): List<Number>
}