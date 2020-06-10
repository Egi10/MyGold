package id.buaja.home.di

import id.buaja.home.domain.HomeUseCase
import org.koin.dsl.module

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

val useCaseModule = module {
    factory {
        HomeUseCase(get())
    }
}