package ui.dendi.simplereduxmvipattern.domain

import ui.dendi.simplereduxmvipattern.domain.repository.NumbersRepository
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersAction
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersState
import ui.dendi.simplereduxmvipattern.redux.Middleware
import ui.dendi.simplereduxmvipattern.redux.Store
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersLMiddleware @Inject constructor(
    private val repository: NumbersRepository,
) : Middleware<NumbersState, NumbersAction> {
    override suspend fun process(
        action: NumbersAction,
        currentState: NumbersState,
        store: Store<NumbersState, NumbersAction>
    ) {
        when (action) {
            is NumbersAction.GetNumbersClickButton -> {
                getNumbers(store)
            }
            is NumbersAction.ShuffleNumbersClickButton -> {
                shuffleNumbers(store)
            }
            else -> {}
        }
    }

    private suspend fun getNumbers(store: Store<NumbersState, NumbersAction>) {
        val numbers = repository.getNumbers()
        store.dispatch(NumbersAction.GetNumbers(numbers))
    }

    private suspend fun shuffleNumbers(store: Store<NumbersState, NumbersAction>) {
        val numbers = repository.getNumbers().shuffled()
        store.dispatch(NumbersAction.ShuffleNumbers(numbers))
    }
}