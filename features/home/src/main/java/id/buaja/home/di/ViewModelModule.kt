package id.buaja.home.di

import id.buaja.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}