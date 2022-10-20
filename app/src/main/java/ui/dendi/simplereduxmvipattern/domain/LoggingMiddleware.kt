package ui.dendi.simplereduxmvipattern.domain

import android.util.Log
import ui.dendi.simplereduxmvipattern.redux.Action
import ui.dendi.simplereduxmvipattern.redux.Middleware
import ui.dendi.simplereduxmvipattern.redux.State
import ui.dendi.simplereduxmvipattern.redux.Store
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingMiddleware<S : State, A : Action> @Inject constructor() : Middleware<S, A> {

    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.d(
            "LoggingMiddleware", "Processing action: $action; Current state: $currentState"
        )
    }
}