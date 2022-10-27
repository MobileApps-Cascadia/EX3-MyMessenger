package com.hfad.mymessenger

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Message
import android.widget.CheckedTextView
import com.hfad.mymessenger.databinding.ActivityCreateMessageBinding


class CreateMessageActivity : AppCompatActivity() {
    //Declare the binding variable as a private lateinit var
    private lateinit var binding: ActivityCreateMessageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add a setOnClickListener to each Button using the binding

        binding.sendExplicit.setOnClickListener {
sendMessageToActivity()

        }

        binding.sendImplicit.setOnClickListener {
sendMessageToOtherApp()
        }

    }

    //Creates an Explicit Intent to start the ReceiveMessageActivity
    private fun sendMessageToActivity() {
        // Create an explicit Intent for ReceiveMessageActivity

        val receiveMessageActivity = Intent (this, ReceiveMessageActivity:: class.java)


        //  use putExtra method to attach the string value from the message editText field
        //      and the boolean "isChecked" value from the markUrgent checkbox (use the binding to get this)

        receiveMessageActivity.putExtra(MESSAGE, binding.message.text.toString())
        receiveMessageActivity.putExtra(URGENT, true)




        //   Start the new Activity
        startActivity(receiveMessageActivity)


    }

    //Creates an IMPLICIT intent, adds the EditText's message as a String, and sends it to a "Chooser" window for the user to pick
    fun sendMessageToOtherApp() {
        val dataIntent = Intent(Intent.ACTION_SEND)
        dataIntent.type = "string/text"
        //TODO: use putExtra method with the label "Intent.EXTRA_TEXT" to attach the user's message to the intent
        //  and send it to a "Chooser" window for the user to see it with the different apps

        val title = resources.getString(R.string.choser_title)
        val chooser = Intent.createChooser(intent, title)






        try{
            startActivity(chooser)
        } catch (e:ActivityNotFoundException){
            "go back to the previous screen"
        }

    }

    //Reference this data label in the message receiver class using CreateMessageActivity.MESSAGE
    companion object {
        const val MESSAGE = "MESSAGE"
        // Add a constant, URGENT, representing the data label "URGENT"
        const val URGENT = "URGENT"  }
}