package id.buaja.data.di

import id.buaja.data.routes.SheetsService
import id.buaja.network.Network
import org.koin.dsl.module

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

val networkModule = module {
    single {
        Network.retrofitClient<SheetsService>()
    }
}