package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.underground.R

class AboutUs:Fragment(R.layout.aboutus) {
    private lateinit var imageButton: ImageButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageButton = view.findViewById(R.id.imageButton)
    }
}