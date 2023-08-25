package com.example.voteyourfriendsv2.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.voteyourfriendsv2.api.votingRe
import com.example.voteyourfriendsv2.users.Players
import com.example.voteyourfriendsv2.users.UserScore
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewModelD : ViewModel() {

    private val re  = votingRe()


}