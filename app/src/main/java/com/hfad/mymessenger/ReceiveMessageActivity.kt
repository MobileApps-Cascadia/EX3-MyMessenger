package com.hfad.mymessenger

import android.os.Bundle
import com.hfad.mymessenger.R
import android.content.Intent
import android.view.View
import com.hfad.mymessenger.CreateMessageActivity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hfad.mymessenger.databinding.ActivityReceiveMessageBinding

class ReceiveMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiveMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveMessageBinding.inflate(layoutInflater)

        //The Activity property 'intent' represents the particular intent that started this Activity
        var message = intent?.extras?.getString(CreateMessageActivity.MESSAGE).toString()

        //TODO: Add an exclamation mark to the TextView if the intent boolean data "URGENT" is true
        var urgent = intent?.extras?.getBoolean(CreateMessageActivity.URGENT)?:false
        if (urgent){
            binding.message.text = message.uppercase() + "!"
        }else{
            binding.message.text = message
        }
            binding.message.text = message

        setContentView(binding.root) // this is called after the rest of the setup, so that the message will display
    }
}