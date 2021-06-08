package com.eurosoft.qrreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.eurosoft.qrreader.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener{ initScanner()}
    }

    private fun initScanner() {
        //Toast.makeText( this, "Heeey this is not useful", Toast.LENGTH_SHORT).show()
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null){
            if(result.contents == null){
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "The values is: ${result.contents}", Toast.LENGTH_SHORT).show()
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}