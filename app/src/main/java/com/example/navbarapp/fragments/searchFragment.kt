package com.example.navbarapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.navbarapp.R

// TODO: Rename parameter arguments, choose names that match

class searchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(context,"Search", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


}