package br.com.ale.gamesKotlin.services

import br.com.ale.gamesKotlin.model.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GameRepository {
    fun fetchGame(id: String): InfoGame{
        val baseUrl = "https://www.cheapshark.com/api/1.0"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseUrl}/games?id=$id"))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val result = response.body()

        val gson = Gson()

        return gson.fromJson(result, InfoGame::class.java)
    }
}