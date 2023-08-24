package br.com.ale.gamesKotlin.model

class Game(
    val title: String,
    val thumb: String,
    ) {
    var description: String? = null;

    override fun toString(): String {
        return "br.com.ale.gamesKotlin.model.Game(titulo='$title', capa='$thumb', descriçao='$description')"
    }
}