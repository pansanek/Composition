package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.potemkin.composition.R
import ru.potemkin.composition.databinding.FragmentChooseLevelBinding
import ru.potemkin.composition.domain.entities.Level

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
        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun launchGameFragment(level:Level){
        val args = Bundle().apply {
            putParcelable(GameFragment.KEY_LEVEL,level)
        }
        findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment,args)
    }
    companion object {

        const val NAME = "ChooseLevelFragment"
        fun newInstance():ChooseLevelFragment{
            return ChooseLevelFragment()
        }
    }
}