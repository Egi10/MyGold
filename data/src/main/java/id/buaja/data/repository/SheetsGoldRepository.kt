package id.buaja.data.repository

import id.buaja.data.entity.SheetsGoldResponse
import retrofit2.Response

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

interface SheetsGoldRepository {
    suspend fun getSheetGold(idSheet: String?, action: String?): Response<SheetsGoldResponse>
}