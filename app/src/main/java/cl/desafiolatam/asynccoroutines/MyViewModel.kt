package cl.desafiolatam.asynccoroutines


import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.net.URL

class MyViewModel: ViewModel() {

    val repository = Repository()
    val url = "https://clinic-cloud.com/wp-content/uploads/2017/12/nasa-y-medicina-800x450.jpg"
    private val image= MutableLiveData<Bitmap> ()
    val error: MutableLiveData<Boolean> =  MutableLiveData()

    val listaUrl: MutableList<String> = mutableListOf(
        "https://www.rockandpop.cl/wp-content/uploads/2018/11/nasa-y-esa-colaboraran-para-traer-muestras-de-mart-815649-jpg_604x0-400x340.jpg"
        , "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/EE7TNMYGXJGJXPBGVY7PMJZLWI.jpg"
        ,"https://clinic-cloud.com/wp-content/uploads/2017/12/nasa-y-medicina-800x450.jpg"
        , "https://www.rosarioplus.com/export/sites/rosarioplus/img/2017/08/03/nasa.jpg_1169487972.jpg")

    fun loadImage(): LiveData<Bitmap> {
        viewModelScope.launch {
            for (url in listaUrl ){
                val download = repository.downloadFromNetwork(url)

                when(download){
                    is Repository.Result.Success -> {
                        image.postValue(download.data)
                    }
                    else -> {
                        Log.d("Imagen", "No pasa naipe krak")
                        error.postValue(true)
                    }
                }
            }
        }
        return image
    }
}