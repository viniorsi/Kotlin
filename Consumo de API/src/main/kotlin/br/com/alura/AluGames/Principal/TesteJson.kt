package br.com.alura.AluGames.Principal

import br.com.alura.AluGames.Modelo.Periodo
import br.com.alura.AluGames.Servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(jogoApi)
//    println(listaGamers)

    val caroline = listaGamers.get(3)
    val jogoResidentvillage = listaJogoJson.get(10)
    val jogoSpiderMan = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)

//    println(caroline)
//    println(jogoResidentvillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

      caroline.alugaJogo(jogoResidentvillage,periodo)
      caroline.alugaJogo(jogoSpiderMan,periodo2)
      caroline.alugaJogo(jogoTheLastOfUs,periodo3)
    println(caroline.jogosAlugados)

}