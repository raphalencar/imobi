package br.com.rba.common.extension

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.rba.common.utils.Event
import com.google.android.material.snackbar.Snackbar

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let {
        Snackbar.make(
            it.findViewById<View>(android.R.id.content),
            snackbarText,
            timeLength
        ).show()
    }
}

/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun Fragment.setupSnackbar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<Int>>,
    timeLength: Int
) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), timeLength) }
        }
    })
}

fun Fragment.setupProgressBar(
    lifecycleOwner: LifecycleOwner,
    progressBarEvent: LiveData<Event<Boolean>>,
    progressBarId: Int
) {
    activity?.let {
        val progressBar = it.findViewById<ProgressBar>(progressBarId)
        progressBarEvent.observe(lifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { isVisible ->
                context?.let {
                    progressBar.showProgressBar(isVisible)
                }
            }
        })
    }
}

fun ProgressBar.showProgressBar(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
