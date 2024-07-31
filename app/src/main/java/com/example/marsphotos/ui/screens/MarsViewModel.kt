package com.example.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.marsphotos.MarsPhotosApplication
import com.example.marsphotos.data.MarsPhotosRepository
import com.example.marsphotos.model.MarsPhoto
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * MarsUiState can have only 3 different network (connecting to server) states
 * the marsUiState can either be: 'Loading', 'Error' or 'Success'
 * the default state is 'loading'
 */
sealed interface MarsUiState {
    data class Success(val photos: MarsPhoto) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

/**
 * The ViewModel for the Mars app.
 *
 * [marsUiState] is the UI state.
 * [getMarsPhotos]is the class function that fetches mars photos from mars api
 *
 * It passes in a [marsPhotosRepository] which is defined in the DefaultAppContainer
 * whose object is created & stored in the MarsPhotoApplication container property
 */
class MarsViewModel(
    private val marsPhotosRepository: MarsPhotosRepository
) : ViewModel() {
    /** The mutable State that stores the status of the photo request */
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos from the Mars API Retrofit service.
     *
     * Here we use the repository as the data source
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                // first mars photo object
                MarsUiState.Success(marsPhotosRepository.getMarsPhotos()[0])
            } catch (e: IOException) {
                MarsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }
}