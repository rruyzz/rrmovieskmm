package com.rodolforuiz.rrumovieskmm.di

import com.rodolforuiz.rrumovieskmm.data.api.CastService
import com.rodolforuiz.rrumovieskmm.data.api.HomeService
import com.rodolforuiz.rrumovieskmm.data.datasource.CastDataSource
import com.rodolforuiz.rrumovieskmm.data.datasource.HomeDataSource
import com.rodolforuiz.rrumovieskmm.data.repository.CastRepositoryImpl
import com.rodolforuiz.rrumovieskmm.data.repository.HomeRepositoryImpl
import com.rodolforuiz.rrumovieskmm.domain.usecase.CastUseCase
import com.rodolforuiz.rrumovieskmm.domain.usecase.HomeUseCase
import org.koin.dsl.module

fun appModule() = module {
    factory {
        HomeUseCase(
            repository = HomeRepositoryImpl(
                dataSource = HomeDataSource(
                    service = HomeService()
                )
            )
        )
    }
    factory {
        CastUseCase(
            repository = CastRepositoryImpl(
                dataSource = CastDataSource(
                    service = CastService()
                )
            )
        )
    }
}
