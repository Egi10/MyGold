package id.buaja.abstraction.until.state

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

sealed class ResultState<out T: Any> {
    data class Success<out T: Any>(val data: T): ResultState<T>()
    data class Message(val message: String?): ResultState<Nothing>()
    data class Error(val error: String?): ResultState<Nothing>()
}