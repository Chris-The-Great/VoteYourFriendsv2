package com.example.voteyourfriendsv2.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.voteyourfriendsv2.R
import com.example.voteyourfriendsv2.databinding.FragmentSetupBinding
import com.example.voteyourfriendsv2.users.Players
import com.example.voteyourfriendsv2.users.UserScore

class Setup : Fragment() {
    private lateinit var viewModelD: ViewModelD
    private lateinit var binding: FragmentSetupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSetupBinding.inflate(layoutInflater)

        viewModelD = ViewModelProvider(this).get(ViewModelD::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.roomCode.text = Players.roomCode
        Log.d("Please", Players.displayId.username)
        binding.button14.text = mainUserName
        return binding.root
    }

    override fun onResume() {
        binding.button14.text = mainUserName
        super.onResume()
    }

    companion object{
     var mainUserName : String = ""
    }
}