package br.com.alura.AluGames.Modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo:Jogo,
    val periodo: Periodo

){

    val valorDoAluguel = gamer.plano.obterValor(this)


    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.usuario} pelo valor R$$valorDoAluguel"
    }

}
