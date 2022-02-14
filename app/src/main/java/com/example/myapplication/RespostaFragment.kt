package com.example.myapplication

import Avancado
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentRespostaBinding

class RespostaFragment: Fragment() {

    private var _binding: FragmentRespostaBinding? = null
    private val binding get() = _binding!!
    private var mensagem = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRespostaBinding.inflate(LayoutInflater.from(context), container, false)

        arguments?.let{
            it.getString("message")?.let{
                mensagem = it
            }
        }

        binding.tvResposta.text = processaMensagem(mensagem)

        binding.btnEnviar.setOnClickListener{
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun processaMensagem(texto: String): String{
        val robo = Avancado()

        return robo.responda(texto)
    }


}

