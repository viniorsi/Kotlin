package br.com.alura.AluGames.Principal

import br.com.alura.AluGames.Modelo.Periodo
import br.com.alura.AluGames.Modelo.PlanoAssinatura
import br.com.alura.AluGames.Servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
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

    caroline.alugaJogo(jogoResidentvillage, periodo)
    caroline.alugaJogo(jogoSpiderMan, periodo2)
    caroline.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(caroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    gamerCamila.alugaJogo(jogoResidentvillage, periodo)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
//    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentvillage, periodo)
//    println(gamerCamila.jogosAlugados)
    gamerCamila.recomendarJogo(jogoResidentvillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    caroline.recomendarJogo(jogoResidentvillage, 8)
    caroline.recomendarJogo(jogoTheLastOfUs, 9)
    println("Recomendações da Camila")
    println(gamerCamila.jogosRecomendados)
    println("Recomendações da Caroline")
    println(caroline.jogosRecomendados)


    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}