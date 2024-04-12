package br.com.alura.AluGames.utilitario

import br.com.alura.AluGames.Modelo.Gamer
import br.com.alura.AluGames.Modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer{
   return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}