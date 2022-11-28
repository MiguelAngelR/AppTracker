package com.mike.apptracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.databinding.FragmentMainBinding
import com.mike.core.entity.model.PopularMovie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment(), MainFragmentContract.MainFragmentView {

    @Inject
    lateinit var presenter : MainFragmentContract.MainFragmentPresenter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var logoutDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        initUI()
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
    }

    private fun initUI() {

    }

    override fun showPopularMovies(popularMovie: MutableList<PopularMovie>) {
        val popularMovies = popularMovie
    }

    override fun showErro(message: String) {

    }

}