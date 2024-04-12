package br.com.alura.AluGames.Principal

import br.com.alura.AluGames.Servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(jogoApi)
//    println(listaGamers)

    val caroline = listaGamers.get(3)
    val jogoResidentvillage = listaJogoJson.get(10)

    println(caroline)
    println(jogoResidentvillage)
    val aluguel =  caroline.alugaJogo(jogoResidentvillage)
    println(aluguel)
}