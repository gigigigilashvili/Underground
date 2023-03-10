package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.underground.R
import com.google.firebase.auth.FirebaseAuth

class LogInLegally:Fragment(R.layout.legal) {
    private lateinit var button: Button
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var repeatpass:EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button7)
        email = view.findViewById(R.id.editTextTextEmailAddress)
        pass = view.findViewById(R.id.editTextTextPassword)
        repeatpass = view.findViewById(R.id.editTextTextPassword2)
        val navController = Navigation.findNavController(view)
        button.setOnClickListener{
            val eemail = email.text.toString()
            val passs = pass.text.toString()
            val pass2 = repeatpass.text.toString()
            if (eemail.isEmpty() || passs.isEmpty() || pass2.isEmpty() || passs != pass2){
                Toast.makeText(this@LogInLegally.requireActivity(),"invalid", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(eemail, passs)
                .addOnCompleteListener{
                        task -> if(task.isSuccessful && passs == pass2) {
                    Toast.makeText(this@LogInLegally.requireActivity(),"User Successfully Created",Toast.LENGTH_SHORT).show()
                    val loginl = LogInLegallyDirections.button()
                    navController.navigate(loginl)
                }
                else{
                    Toast.makeText(this@LogInLegally.requireActivity(),"Something went wrong", Toast.LENGTH_SHORT).show() }
                }
        }
    }
}