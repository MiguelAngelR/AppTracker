package com.mike.apptracker.di

import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.model.MainFragmentModel
import com.mike.apptracker.presenter.MainFragmentPresenter
import com.mike.apptracker.ui.fragments.MainFragment
import com.mike.core.commons.ApplicationScope
import com.mike.core.repositoryabstraction.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesMainFragmentModel(
        movireRepository: MovieRepository
    ): MainFragmentContract.MainFragmentModel = MainFragmentModel(
        repository = movireRepository
    )

    @Singleton
    @Provides
    fun providesMainFragmentPresenter(
        mainFragmentView: MainFragmentContract.MainFragmentView,
        mainFragmentModel: MainFragmentContract.MainFragmentModel,
        @ApplicationScope coroutineScope: CoroutineScope,
    ): MainFragmentContract.MainFragmentPresenter = MainFragmentPresenter(
        mainFragmentView = mainFragmentView,
        mainFragmentModel = mainFragmentModel,
        coroutineScope = coroutineScope,
    )

    @Singleton
    @Provides
    fun providesMainFragmentView(): MainFragmentContract.MainFragmentView = MainFragment()


}