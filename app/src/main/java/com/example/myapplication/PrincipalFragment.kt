package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentInicioBinding

class PrincipalFragment: Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(LayoutInflater.from(context), container, false)

        binding.btnEnviar.setOnClickListener{
            enviarMensagem(binding.textMensagem.text.toString())
            binding.textMensagem.text.clear()
        }

        return binding.root
    }


    private fun enviarMensagem(texto: String){
        val bundle = Bundle()
        bundle.putString("message", texto)
        findNavController().navigate(R.id.respostaFragment, bundle)
    }


}