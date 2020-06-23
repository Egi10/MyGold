package id.buaja.mygold

import android.app.Application
import id.buaja.data.di.networkModule
import id.buaja.data.di.repositoryModule
import id.buaja.domain.di.useCaseModule
import id.buaja.home.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            loadKoinModules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    useCaseModule
                )
            )
        }
    }
}