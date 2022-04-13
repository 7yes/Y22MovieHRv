package com.sevenyes.w5moviesrvhiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenyes.w5moviesrvhiltmvvm.adapter.MovieAdapter
import com.sevenyes.w5moviesrvhiltmvvm.databinding.ActivityMainBinding
import com.sevenyes.w5moviesrvhiltmvvm.state.MovieState
import com.sevenyes.w5moviesrvhiltmvvm.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private val adapterMovie250: MovieAdapter by lazy {
        MovieAdapter() { movie, position ->
         movie.iLikeIt=! movie.iLikeIt
            this.adapterMovie250.notifyItemChanged(position)
        }
    }
    private val adapterPopular by lazy {
        MovieAdapter() { movie, position ->
            movie.iLikeIt=! movie.iLikeIt
            this.adapterMovie250.notifyItemChanged(position)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
        when(it){
            is MovieState.SUCCESS -> {
                adapterMovie250.setMovies(it.response250.items)
                adapterPopular.setMovies(it.responsePopular.items)
            }
            is MovieState.LOADING ->{

            }
            is MovieState.ERROR ->{

            }

            ///
        }

        }
        binding.rv250.apply {
            adapter = adapterMovie250
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        }
        binding.rvPopular.apply {
            adapter = adapterPopular
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies250()
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}