class Game(
    val title: String,
    val thumb: String,
    ) {
    val description = ""

    override fun toString(): String {
        return "Game(titulo='$title', capa='$thumb', descriçao='$description')"
    }
}