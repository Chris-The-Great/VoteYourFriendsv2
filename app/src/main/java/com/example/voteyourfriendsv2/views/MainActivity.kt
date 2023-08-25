package com.example.voteyourfriendsv2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.example.voteyourfriendsv2.R
import com.example.voteyourfriendsv2.databinding.ActivityMainBinding
import com.example.voteyourfriendsv2.model.Questions
import com.example.voteyourfriendsv2.ui.main.MainFragment
import com.example.voteyourfriendsv2.users.Players
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHost.navController

    }
}
