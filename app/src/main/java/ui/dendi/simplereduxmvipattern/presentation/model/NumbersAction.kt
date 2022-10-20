package ui.dendi.simplereduxmvipattern.presentation.model

import ui.dendi.simplereduxmvipattern.domain.model.Number
import ui.dendi.simplereduxmvipattern.redux.Action

sealed class NumbersAction : Action {
    object GetNumbersClickButton : NumbersAction()
    object ShowProgress : NumbersAction()
    object ShuffleNumbersClickButton : NumbersAction()
    data class ShuffleNumbers(val numbers: List<Number> = emptyList()) : NumbersAction()
    data class GetNumbers(val numbers: List<Number> = emptyList()) : NumbersAction()
}