package id.buaja.abstraction.until.ext

import id.buaja.abstraction.until.state.ResultState
import retrofit2.Response
import java.net.ConnectException

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

suspend fun <T: Any> fetchState(call: suspend () -> ResultState<T>): ResultState<T> {
    return try {
        call.invoke()
    } catch (e: ConnectException) {
        ResultState.Error(e.message)
    } catch (e: Exception) {
        ResultState.Error(e.message)
    } catch (e: Throwable) {
        ResultState.Error(e.message)
    }
}

fun <T: Any> responseError(response: Response<T>): ResultState<T> {
    return when(response.code()) {
        400 -> {
            ResultState.Message(response.message())
        }

        else -> {
            ResultState.Message("Terjadi Kesalan")
        }
    }
}