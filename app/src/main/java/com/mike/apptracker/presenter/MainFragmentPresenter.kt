package com.mike.apptracker.presenter

import android.provider.Settings.Global
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

    override fun getPopularMovies() {
        //TODO: Obtain dinamically token to realize request also implement UI design to change page manually
        Log.e("Solicitudi","Realizando solicitud")
        GlobalScope.launch {
            val res = withContext(Dispatchers.IO){
                mainFragmentModel.getPopularMoviesFromRepository(
                    "US-es",
                    "1",
                    "704f89cbcd26cdb80a4ab176b8955ae9",
                    ""
                )
            }

            when (res) {
                is Result.Error -> {
                    Log.e("Solicitudi","Error en la solicitud ${res.exception.message}")
                    Log.e("Solicitudi","Error en la solicitud ${res.exception}")
                    Log.e("Solicitudi","Error en la solicitud ${res}")
                    res.exception.message?.let { mainFragmentView.showError(it) }
                    false
                }
                is Result.Success -> {
                    if(mainFragmentModel.storePopularMovies(res.data as MutableList<PopularMovie>)){
                        mainFragmentView.showPopularMovies(res.data as MutableList<PopularMovie>)
                    }else{
                        mainFragmentView.showError("Error al almacenar las peliculas por favor intenta nuevamente")
                    }
                    true
                }
            }
        }
    }


}