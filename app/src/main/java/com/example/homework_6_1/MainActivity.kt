package com.example.homework_6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework_6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val data = result.data
            val text = data?.getStringExtra(ET_TEXT)
            binding.et.setText(text)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            if (binding.et.text.isNotEmpty()){
                activityLauncher.launch(Intent(this,SecondActivity::class.java).apply {
                    putExtra(ET_TEXT, binding.et.text.toString())
                })
            }else{
                Toast.makeText(this,"Текст не может быть пустым",Toast.LENGTH_LONG).show()
            }
        }
        val result = intent.getStringExtra(ET_TEXT)
        binding.et.setText(result)
    }

    companion object{
       const val ET_TEXT = "key"
    }
}