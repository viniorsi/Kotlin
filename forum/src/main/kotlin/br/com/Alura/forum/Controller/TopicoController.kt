package br.com.Alura.forum.Controller

import br.com.Alura.forum.model.Curso
import br.com.Alura.forum.model.Topico
import br.com.Alura.forum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listar(): List<Topico>{
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "variaveis no kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Cleber",
                email = "cleber@email.com"
            )

        )

    }

}