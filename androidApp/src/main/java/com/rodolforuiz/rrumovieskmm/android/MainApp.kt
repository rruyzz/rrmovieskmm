package com.rodolforuiz.rrumovieskmm.android

import android.app.Application
import com.rodolforuiz.rrumovieskmm.android.presentation.HomeScreenViewModel
import com.rodolforuiz.rrumovieskmm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                    appModule() + viewModelsModule,
            )
        }
    }
    private val viewModelsModule = module {
        viewModel {
            HomeScreenViewModel(
                homeUseCase = get()
            )
        }
    }
}