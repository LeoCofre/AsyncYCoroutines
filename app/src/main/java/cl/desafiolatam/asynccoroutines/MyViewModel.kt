package cl.desafiolatam.asynccoroutines


import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val repository = Repository()
    private val url = "https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg"
    private val imageLiveData= MutableLiveData<Bitmap>()

    fun getImage(){
        viewModelScope.launch {
            val result= repository.downloadFromNetwork(url)
            Log.d(tag, result.toString())
            imageLiveData.postValue(result)
        }

        return live
    }
}