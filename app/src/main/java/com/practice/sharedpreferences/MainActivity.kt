package com.practice.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import com.practice.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var editor : SharedPreferences.Editor
    private lateinit var sf : SharedPreferences
//    private lateinit var name : Editable
//    private lateinit var age : Editable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        name = binding.etName.text
//        age = binding.etAge.text
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

    }

    override fun onPause() {
        super.onPause()
        val name = binding.etName.text.toString()
        val age = binding.etAge.text.toString().toInt()
        editor.apply {
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }

    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age", 0)
        binding.etName.setText(name)
        if (age != 0)  binding.etAge.setText(age.toString())
    }
}