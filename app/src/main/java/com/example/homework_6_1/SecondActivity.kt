package com.example.homework_6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.getStringExtra("key")
        binding.et.setText(result)
        onBackPressed()
    }

    override fun onBackPressed(){
        binding.btn.setOnClickListener {
            if (binding.et.text.isNotEmpty()) {
                val data = Intent()
                data.putExtra(MainActivity.ET_TEXT, binding.et.text.toString())
                setResult(RESULT_OK, data)
                finish()
            }else{
                Toast.makeText(this,"Текст не может быть пустым", Toast.LENGTH_LONG).show()
            }
        }
    }
}