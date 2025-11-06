package com.example.myuploadpdffileapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.documentfile.provider.DocumentFile
import com.example.myuploadpdffileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var pdfFileUri: Uri?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectedPdfButton.setOnClickListener {

            launcher.launch("application/pdf")
//            launcher.launch("image/*")

        }

    }

    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){uri->
        pdfFileUri = uri

        val fileName = uri?.let { DocumentFile.fromSingleUri(this, uri)?.name }
        binding.selectedOrNotTextView.text = fileName.toString()


    }
}