import com.google.gson.Gson
import java.lang.NullPointerException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

fun main() {
    val search = Scanner(System.`in`)

    println("Digite o id do jogo que deseja")

    val id = search.nextLine()

    val baseUrl = "https://www.cheapshark.com/api/1.0"

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("${baseUrl}/games?id=$id"))
        .build()

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val result = response.body()

    try {
        val gson = Gson()

        val game =  gson.fromJson(result, InfoGame::class.java)

        println(game)

        val newGame = Game(game.info.title, game.info.thumb)

        println(newGame)
    } catch (e: NullPointerException){
        println("Error $e")
    }
}