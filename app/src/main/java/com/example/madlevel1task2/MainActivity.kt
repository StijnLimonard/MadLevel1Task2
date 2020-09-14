package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var correctAnswers: ArrayList<String> = arrayListOf("T", "F", "F", "F")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitbutton.setOnClickListener(){
            onSubmit()
        }
    }

    fun onSubmit(){
        var answered: ArrayList<String> = ArrayList()
        answered.add(binding.answer1.text.toString())
        answered.add(binding.answer2.text.toString())
        answered.add(binding.answer3.text.toString())
        answered.add(binding.answer4.text.toString())

        var wronganswers: Int = 0
        for(i in 0..3){
            if(answered[i].toUpperCase() != correctAnswers[i]){
                wronganswers++
            }
        }
        showMessage(wronganswers)
    }

    private fun showMessage(number: Int) {
        if(number == 0){
            Toast.makeText(this, getString(R.string.answerscorrect), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, getString(R.string.answersincorrect, number), Toast.LENGTH_SHORT).show()
        }

    }
}