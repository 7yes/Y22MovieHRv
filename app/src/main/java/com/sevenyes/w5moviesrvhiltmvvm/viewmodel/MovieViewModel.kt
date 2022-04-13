package com.sevenyes.w5moviesrvhiltmvvm.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevenyes.w5moviesrvhiltmvvm.movieapi.IMovieRepository
import com.sevenyes.w5moviesrvhiltmvvm.state.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: IMovieRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var _state : MutableLiveData<MovieState> = MutableLiveData(MovieState.LOADING)
    val state : LiveData<MovieState> get() = _state

    fun getMovies250() {

        _state.postValue(MovieState.LOADING)
        viewModelScope.launch(ioDispatcher) {
            try {
                val response250 = async { movieRepository.getMovies250() }.await()
                val responsePopular = async { movieRepository.getMoviesPopular() }.await()

               if(response250.body() != null && responsePopular.body() != null) {
                   _state.postValue(MovieState.SUCCESS(response250.body()!!,
                   responsePopular.body()!!))
               } else {
                   throw Exception("Request not Successful")
               }
            }
            catch (e: Exception){
                _state.postValue(MovieState.ERROR(e))
            }
        }
    }

}