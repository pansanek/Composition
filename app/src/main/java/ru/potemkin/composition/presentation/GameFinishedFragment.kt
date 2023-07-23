package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.potemkin.composition.databinding.FragmentGameFinishedBinding
import ru.potemkin.composition.domain.entities.GameResult

class GameFinishedFragment : Fragment() {
    private lateinit var gameResult: GameResult
    private  var _binding: FragmentGameFinishedBinding?=null
    private val binding: FragmentGameFinishedBinding
        get()=_binding?:throw java.lang.RuntimeException("FragmentGameFinishedBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameFinishedBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                retryGame()
            }
        })
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun parseArgs(){
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let{
            gameResult = it
        }
    }

    private fun retryGame(){
        requireActivity().supportFragmentManager.popBackStack(ChooseLevelFragment.NAME,0)
    }
    companion object {

        private const val  KEY_GAME_RESULT = "game_result"
        fun newInstange(gameResult: GameResult):GameFinishedFragment{
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT,gameResult)
                }
            }
        }
    }
}