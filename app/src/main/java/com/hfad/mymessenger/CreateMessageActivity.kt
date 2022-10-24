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
    private lateinit var msg: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        msg = findViewById(R.id.message)
        binding.sendExplicit.setOnClickListener { sendMessageToActivity() }
        binding.sendImplicit.setOnClickListener { sendMessageToOtherApp() }

    }

    //Creates an Explicit Intent to start the ReceiveMessageActivity
    private fun sendMessageToActivity() {
        val receivedMessageIntent = Intent(this, ReceiveMessageActivity::class.java)
        val message = msg.text.toString()
        receivedMessageIntent.putExtra(MESSAGE, message)
        receivedMessageIntent.putExtra(URGENT, binding.markUrgent.isChecked)

        startActivity(receivedMessageIntent)
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
        const val URGENT = "URGENT"

    }
}