package ui.dendi.simplereduxmvipattern.domain

import ui.dendi.simplereduxmvipattern.presentation.model.NumbersAction
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersState
import ui.dendi.simplereduxmvipattern.redux.Reducer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersReducer @Inject constructor() : Reducer<NumbersState, NumbersAction> {

    override suspend fun reduce(currentState: NumbersState, action: NumbersAction): NumbersState {
        return when (action) {
            is NumbersAction.ShowProgress -> {
                currentState.copy(isLoading = true)
            }
            is NumbersAction.GetNumbersClickButton -> {
                currentState.copy(isLoading = false)
            }
            is NumbersAction.ShuffleNumbersClickButton -> {
                currentState.copy(isLoading = false)
            }
            is NumbersAction.ShuffleNumbers -> {
                currentState.copy(
                    isLoading = false,
                    numbersList = action.numbers
                )
            }
            is NumbersAction.GetNumbers -> {
                currentState.copy(
                    isLoading = false,
                    numbersList = action.numbers
                )
            }
        }
    }
}