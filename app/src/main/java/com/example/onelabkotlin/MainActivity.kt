package com.example.onelabkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onelabkotlin.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dataBtn.setOnClickListener {
            getData()
        }

        binding.sendBtn.setOnClickListener {
            val message =  binding.messageEdit.text.toString()
            sendMessage(message)
        }
    }



    private fun sendMessage(mess: String) {
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("message", mess)
        startActivity(intent)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getData() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        binding.dataText.text = currentDate
    }

}