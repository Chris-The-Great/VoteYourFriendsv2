package com.example.voteyourfriendsv2.users

data class UserScore(
    val userId: String,
    val username: String,
    val score: Int
){
    // No-argument constructor required by Firebase
    constructor() : this("", "",0)
}
