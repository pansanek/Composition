package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.potemkin.composition.R
import ru.potemkin.composition.databinding.FragmentGameBinding
import ru.potemkin.composition.domain.entities.GameResult
import ru.potemkin.composition.domain.entities.GameSettings
import ru.potemkin.composition.domain.entities.Level

class GameFragment : Fragment() {
    private lateinit var level:Level
    private  var _binding: FragmentGameBinding?=null
    private val binding: FragmentGameBinding
        get()=_binding?:throw java.lang.RuntimeException("FragmentGameBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOption1.setOnClickListener{
            launchGameFInishedFragment(GameResult(
                true,
                0,
                0,
                GameSettings(0, 0, 0, 0)
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFInishedFragment(gameResult: GameResult){
        requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.main_container,
            GameFinishedFragment.newInstange(gameResult)
        ).addToBackStack(null).commit()
    }
    private fun parseArgs(){
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
            level = it
        }
    }
    companion object{

        private const val KEY_LEVEL = "level"
        fun newInstance(level: Level):GameFragment{
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL,level)
                }
            }
        }
    }
}