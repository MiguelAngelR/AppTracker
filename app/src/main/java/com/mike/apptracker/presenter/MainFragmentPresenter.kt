package com.mike.apptracker.presenter

import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.entity.model.PopularMovie
import kotlinx.coroutines.*
import javax.inject.Inject

class MainFragmentPresent(
    private val mainFragmentView: MainFragmentContract.MainFragmentView,
    private val mainFragmentModel: MainFragmentContract.MainFragmentModel,
    private val coroutineScope: CoroutineScope,
) : MainFragmentContract.MainFragmentPresenter{

    override suspend fun getPopularMovies() {
        val response = mainFragmentModel.getPopularMoviesFromRepository("US-es","1","704f89cbcd26cdb80a4ab176b8955ae9","")
        when(response){
            is Result.Error -> {
                response.exception.message?.let { mainFragmentView.showErro(it) }
            }
            is Result.Success -> {
                mainFragmentView.showPopularMovies(response.data as MutableList<PopularMovie>)
            }
        }
    }


}