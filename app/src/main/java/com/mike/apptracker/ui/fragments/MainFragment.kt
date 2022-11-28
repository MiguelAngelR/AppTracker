package com.mike.apptracker.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mike.apptracker.R
import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.databinding.FragmentMainBinding
import com.mike.apptracker.ui.adapters.PopularMovieAdapter
import com.mike.core.commons.AppTrackerDialogBuilder
import com.mike.core.commons.ValidationLifeCycle
import com.mike.core.entity.model.PopularMovie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response.error
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment(), MainFragmentContract.MainFragmentView {

    @Inject
    lateinit var presenter : MainFragmentContract.MainFragmentPresenter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var errorDialog: AlertDialog


    private var adapterCategories: PopularMovieAdapter? = PopularMovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        subscribeUI()
    }

    private fun subscribeUI() {
        presenter.getPopularMovies()
    }

    private fun initUI() {

        binding.rvCategoriesList.adapter = adapterCategories
        val manager = GridLayoutManager(activity,4, GridLayoutManager.HORIZONTAL, false)
        binding.rvCategoriesList.layoutManager = manager

        errorDialog = AppTrackerDialogBuilder(requireContext()).setDialogType(AppTrackerDialogBuilder.DialogType.WARNING)
                .setTitle(getString(com.mike.core.R.string.error))
                .setMessage(getString(com.mike.core.R.string.sync_again))
                .setNegativeButton(text = getString(com.mike.core.R.string.cancel)) {
                    it?.hide()
                }
                .setPositiveButton(text = getString(com.mike.core.R.string.acept)) {
                    it?.hide()
                }
                .create()
    }

    override fun showPopularMovies(popularMovies: MutableList<PopularMovie>) {
        Log.e("DATOS","Los datos obtenidos, tamaño ${popularMovies.size}")
        adapterCategories?.submitList(popularMovies)
    }

    override fun showError(message: String) {
        Log.e("DATOS","Los datos obtenidos, tamaño ${message}")
    }

    override fun onDestroy() {
        super.onDestroy()
        errorDialog.dismiss()
    }

}