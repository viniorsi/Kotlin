package br.com.alura.AluGames.Modelo

import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo(@Expose val titulo: String, @Expose var capa: String) : Recomendavel {
    var descricao: String? = null
    var preco = BigDecimal("0.0")
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu br.com.alura.AluGames.Modelo.Jogo: \n" +
                "Titulo: $titulo \n" +
                "capa: $capa \n" +
                "Preço: $preco\n" +
                "descricao: $descricao"
    }


}