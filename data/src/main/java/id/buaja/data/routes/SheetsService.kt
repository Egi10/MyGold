package id.buaja.data.routes

import id.buaja.data.entity.SheetsGoldResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

interface SheetsService {
    @GET("macros/s/{id_sheets}/exec")
    suspend fun getSheets(
        @Path("id_sheets") idSheets: String?,
        @Query("action") action: String?
    ): Response<SheetsGoldResponse>
}