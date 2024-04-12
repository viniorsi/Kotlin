package br.com.alura.AluGames.utilitario

import br.com.alura.AluGames.Modelo.InfoJogoJson
import br.com.alura.AluGames.Modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}