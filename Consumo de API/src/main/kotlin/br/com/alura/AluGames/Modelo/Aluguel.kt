package br.com.alura.AluGames.Modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo:Jogo
){

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.usuario}"
    }

}
