package com.example.lab1_pam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.lab1_pam.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener { getResult() }
    }

    private fun getResult() {
        binding.textInputLayout.helperText = validText()
        val validText = binding.textInputLayout.helperText == null
        if (validText)
            showResult()
        else
            emptyField()
    }
    private fun calculateOccurance(txt: String) : Int
    {
        val strArray = txt.split(" ".toRegex()).toTypedArray()
        var word = 0
        for (s in strArray) {
            if ("a" in s || "A" in s && s != "") {
                word++
            }
    }
        return word
    }
    private fun showResult()
    {
        val txt = binding.txt1.text.toString()
        val message = "Words with letter 'a': " + calculateOccurance(txt)
        AlertDialog.Builder(this)
            .setTitle("Result")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                binding.txt1.text = null
            }
            .show()
    }
    private fun emptyField()
    {
        var message = ""
        if(binding.textInputLayout.helperText != null)
            message += binding.textInputLayout.helperText
        AlertDialog.Builder(this)
            .setTitle("Empty Field")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
            }
            .show()
    }
    private fun validText(): String? {
        val text = binding.txt1.text.toString()
        if (text.trim().isEmpty()) {
            return "Text missing"
        }
        return null
    }
}