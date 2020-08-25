package cl.desafiolatam.asynccoroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class Repository {
    suspend fun downloadFromNetwork(url: String): result<Bitmap> = withContext(Dispatchers.IO){
        val urldisplay =url
        var bmp: Bitmap? = null
            val inputStream = URL(urldisplay).openStream()
            bmp = BitmapFactory.decodeStream(inputStream)


        }
}