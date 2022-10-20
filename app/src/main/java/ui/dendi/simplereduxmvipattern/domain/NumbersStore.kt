package ui.dendi.simplereduxmvipattern.domain

import ui.dendi.simplereduxmvipattern.domain.repository.NumbersRepository
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersAction
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersState
import ui.dendi.simplereduxmvipattern.redux.BaseStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersStore @Inject constructor(
    repository: NumbersRepository
): BaseStore<NumbersState, NumbersAction>(
    initialState = NumbersState(),
    reducer = NumbersReducer(),
    middlewares = listOf(
        LoggingMiddleware(),
        NumbersLMiddleware(repository),
    )
)