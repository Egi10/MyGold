package id.buaja.domain.di

import id.buaja.domain.home.HomeUseCase
import org.koin.dsl.module

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

val useCaseModule = module {
    factory {
        HomeUseCase(get())
    }
}