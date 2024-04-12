package br.com.alura.AluGames.Modelo

data class Jogo(val titulo:String, var capa:String) {
    var descricao: String? = null
    var preco = 0.0
    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu br.com.alura.AluGames.Modelo.Jogo: \n" +
                "Titulo: $titulo \n" +
                "capa: $capa \n" +
                "Preço: $preco\n"+
                "descricao: $descricao"
    }


}