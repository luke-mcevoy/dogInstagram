package com.mcevoy.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcevoy.dogs.model.DogBreed
import com.mcevoy.dogs.model.DogDatabase
import com.mcevoy.dogs.model.DogsAPIService
import com.mcevoy.dogs.view.DetailFragment
import com.mcevoy.dogs.view.DetailFragmentArgs
import kotlinx.coroutines.launch

class DetailViewModel(application: Application): BaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }
}