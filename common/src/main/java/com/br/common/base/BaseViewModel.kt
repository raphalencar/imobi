package br.com.rba.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import br.com.rba.common.utils.Event
import com.br.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    // FOR LOADING HANDLER
    protected val _progressBarLoading = MutableLiveData<Event<Boolean>>()
    val progressBarLoading: LiveData<Event<Boolean>> get() = _progressBarLoading

    // FOR ERROR HANDLER
    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackBarError: LiveData<Event<Int>> get() = _snackbarError

    // FOR NAVIGATION
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    /**
     * Convenient method to handle navigation from a [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}
