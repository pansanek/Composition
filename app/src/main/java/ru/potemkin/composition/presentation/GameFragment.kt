package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.potemkin.composition.R
import ru.potemkin.composition.databinding.FragmentGameBinding
import ru.potemkin.composition.databinding.FragmentWelcomeBinding

class GameFragment : Fragment() {
    private  var _binding: FragmentGameBinding?=null
    private val binding: FragmentGameBinding
        get()=_binding?:throw java.lang.RuntimeException("FragmentGameBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}