package id.buaja.data.di

import id.buaja.data.repository.SheetsGoldRepository
import id.buaja.data.repository.SheetsGoldRepositoryImpl
import org.koin.dsl.module

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

val repositoryModule = module {
    single<SheetsGoldRepository> {
        SheetsGoldRepositoryImpl(get())
    }
}