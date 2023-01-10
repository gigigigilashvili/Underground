package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.underground.R

class signin:Fragment(R.layout.signinn) {
    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var signinn: Button
    private lateinit var forgpass:  Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mail = view.findViewById(R.id.editTextTextEmailAddress2)
        pass = view.findViewById(R.id.editTextTextPassword3)
        signinn = view.findViewById(R.id.button6)
        forgpass = view.findViewById(R.id.button7)
        val navController = Navigation.findNavController(view)

        forgpass.setOnClickListener{
            val forg = signinDirections.button()
            navController.navigate(forg)
        }
        signinn.setOnClickListener{
            if(mail.equals(R.id.editTextTextEmailAddress)) {
                val legalUwU = signinDirections.button2()
                navController.navigate(legalUwU)
            }
            }
            if(mail.equals(R.id.editTextTextEmailAddress1)) {
                val illegalUwU = signinDirections.button3()
                navController.navigate(illegalUwU)
            }
        }
    }