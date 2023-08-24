package br.com.ale.gamesKotlin.main

import br.com.ale.gamesKotlin.model.Game
import br.com.ale.gamesKotlin.services.GameRepository
import java.util.*

fun main() {
    val gameRepository =  GameRepository()
    var newGame: Game? = null

    val search = Scanner(System.`in`)

    println("Digite o id do jogo que deseja")

    val id = search.nextLine()

    val resultGame =  runCatching {
        val game = gameRepository.fetchGame(id)

        newGame = Game(game.info.title, game.info.thumb)
    }

    resultGame.onFailure {
        println("Jogo inexistente")
    }

    resultGame.onSuccess {
        println("Deseja adicionar uma descriçao?")

        val responseDescription = search.nextLine()

        if(responseDescription.equals("s")){
            println("Adicione uma descrição")

            val description = search.nextLine()

            newGame?.description = description
        } else {
          newGame?.description = newGame?.title
        }

        print(newGame)
    }
}