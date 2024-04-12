import br.com.alura.AluGames.Modelo.Gamer

fun main(){

    val gamer1 = Gamer("vini",
        "orsivini@outlook.com")

    println(gamer1)

    val gamer2 = Gamer("yasmin",
        "yasmin@gmail.com",
        "19/04/2001",
        "yasver")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "22/06/2003"
        it.usuario = "SNC"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "vini"
    println(gamer1)
}