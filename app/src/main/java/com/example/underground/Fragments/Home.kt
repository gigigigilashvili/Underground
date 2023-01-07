package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.underground.R

class Home: Fragment(R.layout.home) {
    private lateinit var button:Button
    private lateinit var button1:Button
    private lateinit var button2:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button)
        button1 = view.findViewById(R.id.button2)
        button2 = view.findViewById(R.id.button3)
        val navController = Navigation.findNavController(view)

        button.setOnClickListener{
            val legaluri = HomeDirections.button()
            navController.navigate(legaluri)
        }
        button1.setOnClickListener{
            val aralegaluri = HomeDirections.button2()
            navController.navigate(aralegaluri)
        }
        button2.setOnClickListener{
            val sign = HomeDirections.button3()
            navController.navigate(sign)
        }
    }
}