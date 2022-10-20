package ui.dendi.simplereduxmvipattern.redux

interface Middleware<S : State, A : Action> {

    suspend fun process(
        action: A,
        currentState: S,
        store: Store<S, A>
    )
}