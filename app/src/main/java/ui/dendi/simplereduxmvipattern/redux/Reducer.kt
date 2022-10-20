package ui.dendi.simplereduxmvipattern.redux

interface Reducer<S : State, A : Action> {

    suspend fun reduce(currentState: S, action: A): S
}