package ui.dendi.simplereduxmvipattern.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ui.dendi.simplereduxmvipattern.domain.NumbersStore
import ui.dendi.simplereduxmvipattern.presentation.model.NumbersAction
import javax.inject.Inject

@HiltViewModel
class NumbersViewModel @Inject constructor(
    private val store: NumbersStore,
) : ViewModel() {

    val state = store.state

    init {
        showProgress()
    }

    fun getNumbers() {
        viewModelScope.launch {
            store.dispatch(NumbersAction.GetNumbersClickButton)
        }
    }

    fun shuffleNumbers() {
        viewModelScope.launch {
            store.dispatch(NumbersAction.ShuffleNumbersClickButton)
        }
    }

    private fun showProgress() {
        viewModelScope.launch {
            store.dispatch(NumbersAction.ShowProgress)
        }
    }
}