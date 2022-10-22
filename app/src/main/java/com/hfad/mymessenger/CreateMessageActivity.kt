package com.hfad.mymessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.CheckedTextView
import android.widget.EditText
import com.hfad.mymessenger.databinding.ActivityCreateMessageBinding

class CreateMessageActivity : AppCompatActivity() {
    //Declare the binding variable as a private lateinit var
    private lateinit var binding: ActivityCreateMessageBinding
    private lateinit var mess: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mess = findViewById(R.id.message)

        //TODO: Add a setOnClickListener to each Button using the binding
        binding.sendExplicit.setOnClickListener { _ ->
            sendMessageToActivity()
        }
        binding.sendImplicit.setOnClickListener { _ ->
            sendMessageToOtherApp()
        }
    }

    //Creates an Explicit Intent to start the ReceiveMessageActivity
    private fun sendMessageToActivity() {
        //TODO: Create an explicit Intent for ReceiveMessageActivity
        val send = Intent(this, ReceiveMessageActivity::class.java)
        // TODO: use putExtra method to attach the string value from the message editText field
        //      and the boolean "isChecked" value from the markUrgent checkbox (use the binding to get this)
        val message = mess.text.toString()
        send.putExtra(MESSAGE, message)
        send.putExtra(URGENT, binding.markUrgent.isChecked)
        //  TODO: Start the new Activity
        startActivity(send)

    }

    //Creates an IMPLICIT intent, adds the EditText's message as a String, and sends it to a "Chooser" window for the user to pick
    fun sendMessageToOtherApp() {
        val dataIntent = Intent(Intent.ACTION_SEND)
        dataIntent.type = "text/plain"
        //TODO: use putExtra method with the label "Intent.EXTRA_TEXT" to attach the user's message to the intent
        //  and send it to a "Chooser" window for the user to see it with the different apps

    }

    //Reference this data label in the message receiver class using CreateMessageActivity.MESSAGE
    companion object {
        const val MESSAGE = "MESSAGE"
        //TODO: Add a constant, URGENT, representing the data label "URGENT"
        const val  URGENT = "true"
    }
}