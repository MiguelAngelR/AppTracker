package com.mike.apptracker.presenter

import android.util.Log
import com.mike.apptracker.contract.MainFragmentContract
import com.mike.core.entity.model.PopularMovie
import kotlinx.coroutines.*
import javax.inject.Inject
import com.mike.core.commons.Result

class MainFragmentPresenter @Inject constructor(
    private val mainFragmentView: MainFragmentContract.MainFragmentView,
    private val mainFragmentModel: MainFragmentContract.MainFragmentModel,
    private val coroutineScope: CoroutineScope,
) : MainFragmentContract.MainFragmentPresenter {

    override suspend fun getPopularMovies() {
        //TODO: Obtain dinamically token to realize request also implement UI design to change page manually
        Log.e("Solicitudi","Realizando solicitud")
        val response = mainFragmentModel.getPopularMoviesFromRepository(
            "US-es",
            "1",
            "704f89cbcd26cdb80a4ab176b8955ae9",
            ""
        )
        Log.e("Solicitudi","Solicitud realizada")
        when (response) {
            is Result.Error -> {
                Log.e("Solicitudi","Error en la solicitud")
                response.exception.message?.let { mainFragmentView.showErro(it) }
            }
            is Result.Success -> {
                if(mainFragmentModel.storePopularMovies(response.data as MutableList<PopularMovie>)){
                    mainFragmentView.showPopularMovies(response.data as MutableList<PopularMovie>)
                }else{
                    mainFragmentView.showErro("Error al almacenar las peliculas por favor intenta nuevamente")
                }

            }
        }
    }


}