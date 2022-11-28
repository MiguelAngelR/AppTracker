package com.mike.apptracker.presenter

import android.util.Log
import com.mike.apptracker.R
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

    private val TAG = "MainFragment"

    override fun getPopularMovies() {
        mainFragmentView.showInfor("nUEVO MENSAJE")
        //TODO: Obtain dinamically token to realize request also implement UI design to change page manually
        GlobalScope.launch(Dispatchers.Main){
            when(mainFragmentModel.dataBasePopulated()){
                true -> {
                    Log.e(TAG,"Database prepopulated")
                    mainFragmentView.showPopularMovies(mainFragmentModel.findAllPopularMovies().toMutableList())
                }
                false -> {
                    Log.e(TAG,"Peticion a API")
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
                            Log.e(TAG,"Result failed")
                            res.exception.message?.let { mainFragmentView.showError(it) }
                        }
                        is Result.Success -> {
                            Log.e(TAG,"Result success")
                            if(mainFragmentModel.storePopularMovies(res.data as MutableList<PopularMovie>)){
                                mainFragmentView.showPopularMovies(res.data as MutableList<PopularMovie>)
                            }else{
                                mainFragmentView.showError("Error al almacenar datos")
                            }
                        }
                    }
                }
            }
        }
    }


}