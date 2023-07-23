package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.potemkin.composition.R
import ru.potemkin.composition.databinding.FragmentChooseLevelBinding
import ru.potemkin.composition.databinding.FragmentWelcomeBinding

class ChooseLevelFragment : Fragment() {
    private  var _binding: FragmentChooseLevelBinding?=null
    private val binding: FragmentChooseLevelBinding
        get()=_binding?:throw java.lang.RuntimeException("FragmentChooseLevelBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater,container,false)
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