
import java.util.*

interface IRobo {
    fun responda(pergunta: String): String
}

open class Robo: IRobo {

    private var grito: Boolean = false
    private var eu: Boolean = false
    private var empty: Boolean = false

    override fun responda(pergunta: String): String {
        validarTexto(pergunta)
        var resposta = "Certamente!\n"
        resposta += when {
            grito -> {
                "Opa! Calma aí! \n" +
                "Relaxa, eu sei o que estou fazendo!"
            }
            eu -> "A responsabilidade é sua"

            empty -> "Não me incomode"

            else -> "Tudo bem, como quiser"
        }

        return resposta
    }

    private fun validarTexto(texto: String) {
        for (palavra in texto.split(" ")){
            val upper = palavra.uppercase()
            if( !grito && palavra == upper){
                grito = true
            }
            if( !eu && upper == "EU"){
                eu = true
            }
        }
        empty = texto.replace(" ", "").isEmpty()
    }
}



open class Avancado: Robo() {
    fun responda(operacao: String, operando1: Int, operando2: Int): String{
        var resposta = ""
        if(! operacao.isEmpty()) {
            val resultado =
                (when (operacao) {
                    "some" -> operando1 + operando2
                    "subtraia" -> operando1 - operando2
                    "multiplique" -> operando1 * operando2
                    "divida" -> operando1 / operando2
                    else -> "Ops! Não conhheço essa operação!"
                }).toString()

            resposta = "Essa eu sei: $resultado"
        }

        return resposta
    }
}

class Premium(
    /*
    * ações possíveis: "primos", "data"
    * */
    val acao: String
): Avancado(), IRobo{

    override fun responda(pergunta: String): String{
        if(pergunta == "agir"){
            return agir()
        }else{
            return super.responda(pergunta)
        }
    }

    private fun agir(): String{
        var resposta = "É pra já! "
        resposta = when (acao) {
            "primos" -> {
                "Numeros Primo de 1 até 100:" +
                primos(100)
            }
            "data" -> {
                "Data atual:" +
                dataAtual()
            }
            else -> {
                "Não entendi..."
            }
        }

        return resposta
    }

    private fun primos(valor: Int): String{
        val elementos = mutableListOf<String>()
        for(i in 1..valor){
            var primo = true
            for(n in 1..i){
              if(i % n == 0 && n != 1 && n != i){
                  primo = false
                  break
              }
            }
            if(primo){
                elementos.add(i.toString())
            }
        }
        return elementos.joinToString(" - ")
    }

    private fun dataAtual(): String{
        return Date().toLocaleString()
    }
}


/*
* Programa com Versão Premium:
* *//*
fun main() {
    var acao = ""
    var pergunta = ""

    while(pergunta != "FIM"){
        println("Pergunte ou digite 'FIM' para sair:")
        pergunta = readLine() ?: ""
        if(pergunta == "agir"){
            println("Informe a acao (primos/data):")
            acao = readLine() ?: ""
        }
        val robo = Premium(acao)
        robo.responda(pergunta)
    }

}*/





