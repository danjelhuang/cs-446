package com.example.wetravel.models

import java.util.UUID


// This file contains the Data Models used by our Frontend
data class Destination(
    val placeId: String,
    val name: String,
    val address: String,
    val rating: String,
    val reviewCount: Int,
    val imageResId: Int,
    val numOfVotes: Int,
    val voted: Boolean,
    val description: String
)

data class Trip(
    val tripID: String = "",
    val name: String = "",
    val city: String = "",
    val finalDestinationCount: Int = 0,
    val users: List<String> = emptyList(),
    val adminUserID: String = "",
    val votesPerPerson: Int = 0,
    val phase: String = "",
    val destinationsList: Map<String, DestinationDetails> = emptyMap()
)

data class DestinationDetails(
  val totalVotes: Int = 0,
  val userVotes: Map<String, Int> = emptyMap()
)

// TODO: Remove this and convert ViewModel properties in the ViewModels.kt class
data class ViewModel(
    val userId: String = "",
    val username: String = "",
    val userEmail: String = "",
    val trips: List<String> = emptyList(), // List of Trip Code's
    val currentTrip: Trip = Trip(), // The current Trip's
)

