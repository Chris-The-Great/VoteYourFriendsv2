package com.example.voteyourfriendsv2.api

import android.util.Log
import com.example.voteyourfriendsv2.users.Players
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class votingRe {
    val database = FirebaseDatabase.getInstance()
    val reference = database.getReference(Players.roomCode)

    init {
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Good", snapshot.value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}