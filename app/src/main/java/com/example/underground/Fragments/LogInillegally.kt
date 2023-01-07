package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.underground.R
import com.google.firebase.auth.FirebaseAuth

class LogInillegally:Fragment(R.layout.illegal) {
    private lateinit var button: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var rpassword: EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button10)
        email = view.findViewById(R.id.editTextTextEmailAddress1)
        password = view.findViewById(R.id.editTextTextPassword3)
        rpassword = view.findViewById(R.id.editTextTextPassword4)

        button.setOnClickListener{
            val eemail = email.text.toString()
            val pass1 = password.text.toString()
            val rpass = rpassword.text.toString()
            if (eemail.isEmpty() || pass1.isEmpty() || rpass.isEmpty() || pass1 != rpass){
                Toast.makeText(this@LogInillegally.requireActivity(),"invalid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(eemail, pass1)
                .addOnCompleteListener{
                        task -> if(task.isSuccessful && pass1 == rpass) {
                    Toast.makeText(this@LogInillegally.requireActivity(),"User Successfully Created",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@LogInillegally.requireActivity(),"Something went wrong", Toast.LENGTH_SHORT).show() }
                }
        }
    }
}