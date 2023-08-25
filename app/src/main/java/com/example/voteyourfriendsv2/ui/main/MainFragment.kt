package com.example.voteyourfriendsv2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.voteyourfriendsv2.R
import com.example.voteyourfriendsv2.databinding.FragmentMainBinding
import com.example.voteyourfriendsv2.model.Questions
import com.example.voteyourfriendsv2.users.Players
import com.example.voteyourfriendsv2.views.ViewModelD
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainFragment : Fragment() {



    private lateinit var viewModel: ViewModelD
    private lateinit var binding: FragmentMainBinding
    var idS = mutableListOf<String>()
    var questionS = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //viewModel = ViewModelProvider(this)[ViewModelD::class.java]
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.popup.visibility = View.GONE
        binding.hostGame.setOnClickListener {
            binding.popup.visibility = View.VISIBLE
        }
        binding.gameButton.setOnClickListener {
            usernameHolder = binding.username.text.toString()
            Players.hostGame()
            findNavController().navigate(R.id.action_mainFragment_to_setup)
        }

        fetchVotingQ{
                questions ->
            if(questions != null)
            {
                var currentQuestion: String = idS.random()
                Log.d("yes", currentQuestion)
            }
        }


        return binding.root
    }

    fun fetchVotingQ(callback: (List<Questions>?) -> Unit) {
        Thread {
            val url = URL("https://api.jsonbin.io/v3/b/647649b68e4aa6225ea6c4c6")
            val connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET"
            val masterKey = "$2b$10'$'xoDaSDWa1B9YyvkUJUpMvOvOPfH03r8oq6Qua4dTpvu09yNuFAcGW"
            val accessKey = "$2b$10'$'oB/3hFcq9jas2ywoaXhQpuAtxVDKRruSpjH8KZQqh6h6TB45YmHMW"
            connection.setRequestProperty(
                "X-Master-Key",
                "\$2b\$10\$xoDaSDWa1B9YyvkUJUpMvOvOPfH03r8oq6Qua4dTpvu09yNuFAcGW"
            )
            connection.connect()
            if (connection.responseCode == 200) {
                val inputSystem = connection.inputStream
                Log.d("yes", inputSystem.toString())
                val response = connection.inputStream.bufferedReader().use {
                    it.readText()

                }
                Log.d("yes", response)
                if (response.isNotEmpty()) {
                    // Parse the JSON data
                    val jsonObject = JSONObject(response)
                    val record = jsonObject.getJSONObject("record")
                    val generalArray = record.getJSONArray("general")
                    val questions = mutableListOf<Questions>()

                    //Log.d("yes", generalArray.toString())

                    Log.d("yes", generalArray.length().toString())
                    for (i in 0 until generalArray.length()) {
                        val questionObject = generalArray.getJSONObject(i)
                        val id = questionObject.getString("id")
                        Log.d("yes", id)
                        val question = questionObject.getString("question")
                        Log.d("yes", question)
                        idS.add(id)
                        questionS.add(question)


                    }
                    callback(questions)

                } else {
                    Log.d("yes", connection.responseCode.toString())
                }


            }
        }.start()
    }

    companion object{
        lateinit var usernameHolder : String
    }

}