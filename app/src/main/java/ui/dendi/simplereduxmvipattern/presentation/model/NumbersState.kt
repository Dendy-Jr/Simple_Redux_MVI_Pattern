package ui.dendi.simplereduxmvipattern.presentation.model

import ui.dendi.simplereduxmvipattern.domain.model.Number
import ui.dendi.simplereduxmvipattern.redux.State

data class NumbersState(
    val numbersList: List<Number> = emptyList(),
    val isLoading: Boolean = false,
) : State