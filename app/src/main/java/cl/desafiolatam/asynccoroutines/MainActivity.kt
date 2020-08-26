package cl.desafiolatam.asynccoroutines

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val model: MyViewModel by viewModels()
        var contador: Int = 1

        model.loadImage().observe(this, Observer { image ->
            updateView(image, contador++)
        })
        model.error.observe(this, Observer {
            updateErrorView()
        })
    }

    private fun updateView(image: Bitmap, contador: Int) {

        when (contador) {
            1 -> imageView1.setImageBitmap(image)
            2 -> imageView2.setImageBitmap(image)
            3 -> imageView3.setImageBitmap(image)
            4 -> imageView4.setImageBitmap(image)
        }


    }

    private fun updateErrorView() {

        Toast.makeText(
            this,
            "Ha ocurrido un error al cargar la imagen",
            Toast.LENGTH_LONG
        ).show()
    }


}


