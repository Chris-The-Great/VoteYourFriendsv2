package com.example.voteyourfriendsv2.users

import android.util.Log
import com.example.voteyourfriendsv2.ui.main.MainFragment
import com.example.voteyourfriendsv2.views.MainActivity
import com.example.voteyourfriendsv2.views.Setup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import retrofit2.http.POST
import java.util.Random

class Players{
    companion object {
        lateinit var roomCode: String
        lateinit var ref : DatabaseReference
        @Volatile var displayId: UserScore = UserScore()

        fun hostGame()
        {
            generateRoomCode()
            val base = Firebase.database
            ref = base.getReference(roomCode)
            addPlayers()
            displayPlayer()

        }

        fun addPlayers() {
            var Id = "Yes"
            var username: String = MainFragment.usernameHolder
            var score: Int = 0
            var user = User(Id,username, score)
            ref.setValue(user)
        }

        fun displayPlayer()
        {
            val playerReader = object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("yes", snapshot.getValue(UserScore::class.java)!!.username)
                    displayId = snapshot.getValue(UserScore::class.java)!!
                    Setup.mainUserName = snapshot.getValue(UserScore::class.java)!!.username
                    Log.d("yes", Setup.mainUserName)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            ref.addValueEventListener(playerReader)
        }

        fun generateRoomCode() {
            val allowedCharaters = "0123456789qwertyuiopasdfghjklzxcvbnm"
            var random = Random()
            var stringBuilder = StringBuilder(4)
            for (i in 0 until 4) {
                stringBuilder.append(allowedCharaters[random.nextInt(allowedCharaters.length)])
            }
            roomCode = stringBuilder.toString()
        }
    }


}
data class User(
    var Id : String? = null,
    var username : String? = null,
    var score : Int? = null

)