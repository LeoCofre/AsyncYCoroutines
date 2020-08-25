package cl.desafiolatam.asynccoroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
const val tag = "My Tag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MyViewModel by viewModels()

        Log.d(tag, "LLamando a getImage")
        viewModel.getImage().observe( this,  { it:Bitmap!
                Log.d(tag, "En la vista >>>>> $it")
                imgOfDay.setImageBitmap(it)
            })
    }
}


