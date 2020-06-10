package id.buaja.home.domain

import id.buaja.abstraction.until.ext.fetchState
import id.buaja.abstraction.until.ext.responseError
import id.buaja.abstraction.until.state.ResultState
import id.buaja.data.repository.SheetsGoldRepository

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

class HomeUseCase(private val repository: SheetsGoldRepository) {
    suspend fun getSheetGold(idSheet: String?, action: String?): ResultState<Any> {
        return fetchState {
            val response = repository.getSheetGold(idSheet, action)
            if (response.isSuccessful) {
                ResultState.Success(response.body()!!)
            } else {
                responseError(response)
            }
        }
    }
}