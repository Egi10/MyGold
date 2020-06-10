package id.buaja.abstraction.until.state

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

sealed class LoaderState {
    object ShowLoading: LoaderState()
    object HideLoading: LoaderState()
}