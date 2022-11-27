package com.mike.apptracker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.mike.apptracker.R
import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.databinding.FragmentMainBinding
import com.mike.apptracker.domain.entity.model.PopularMovie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment(
    private val mainFragmentContract: MainFragmentContract
) : Fragment(), MainFragmentContract.MainFragmentView {


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