package br.com.alura.AluGames.Principal

import br.com.alura.AluGames.Modelo.Gamer
import br.com.alura.AluGames.Modelo.Jogo
import br.com.alura.AluGames.Servicos.ConsumoApi
import transformarEmIdade
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do Gamer: ")
    println(gamer)

    println("Idade do gamer " + gamer.dataNascimento?.transformarEmIdade())
    do{
        println("Digite um codigo de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo =  buscaApi.buscajogo(busca)




//            "?" a variavel pode ser null
        var meuJogo: Jogo? = null
        val resultado = runCatching {

            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
        println(meuJogo)



        resultado.onFailure {
            println("br.com.alura.AluGames.Modelo.Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
                println("sua descrição: $descricaoPersonalizada")
            } else {
                meuJogo?.descricao = meuJogo?.titulo
                println("sem descrição")
            }
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s",ignoreCase = true))

    println("Jogos buscados: ")
    println(gamer.jogosBuscados)

    println("\n Jogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach{
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman",true) ?: false
    }
    println("\n Jogos Filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s",true)){
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada: ")
    println(gamer.jogosBuscados)



    println("Busca finalizada com sucesso.")






}