package id.buaja.data.repository

import id.buaja.data.entity.SheetsGoldResponse
import id.buaja.data.routes.SheetsService
import retrofit2.Response

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

class SheetsGoldRepositoryImpl(private val sheetsService: SheetsService) : SheetsGoldRepository {
    override suspend fun getSheetGold(
        idSheet: String?,
        action: String?
    ): Response<SheetsGoldResponse> {
        return sheetsService.getSheets(idSheet, action)
    }
}