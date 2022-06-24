package org.d3if1016.asessment2.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if1016.asessment2.network.Profile
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if1016.asessment2.network.ImageApi

enum class ProfileApiStatus{LOADING, SUCCESS, ERROR}

class ProfileViewModel : ViewModel() {

    private val _profileStatus = MutableLiveData<ProfileApiStatus>()
    private val _imageId = MutableLiveData<List<Profile>>()

    val profileStatus: LiveData<ProfileApiStatus> = _profileStatus
    val imageId: LiveData<List<Profile>> = _imageId

    init {
        getProfile()
    }

    private fun getProfile() {
        viewModelScope.launch {
            _profileStatus.value = ProfileApiStatus.LOADING
            try {
                _imageId.value = ImageApi.retrofitService.getProfile()
                _profileStatus.value = ProfileApiStatus.SUCCESS

            } catch (e : Exception) {
                _profileStatus.value = ProfileApiStatus.ERROR
                _imageId.value = listOf()
            }
        }
    }
}