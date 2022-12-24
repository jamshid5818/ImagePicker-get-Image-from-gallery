package jama.apps.getImage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.dhaval2404.imagepicker.ImagePicker
import jama.apps.getImage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.camera.setOnClickListener {
            ImagePicker.with(this).cameraOnly().crop().maxResultSize(400, 400).start()
        }
        binding.gallery.setOnClickListener {
            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
                .maxResultSize(400, 400).start()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK && requestCode== ImagePicker.REQUEST_CODE) {

            binding.pickerImage.setImageURI(data?.data)

        }

    }
}