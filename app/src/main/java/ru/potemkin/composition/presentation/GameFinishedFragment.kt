package ru.potemkin.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.potemkin.composition.R
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
        setupClickListener()
        bindViews()
    }

    private fun bindViews() {
        with(binding){
            emojiResult.setImageResource(getSmileResId())
            tvRequiredAnswers.text = String.format(
                getString(R.string.required_score),
                gameResult.gameSettings.minCountOfRightAnswers
            )
            tvScoreAnswers.text = String.format(
                getString(R.string.score_answers),
                gameResult.countOfRightAnswers
            )
            tvRequiredPercentage.text = String.format(
                getString(R.string.required_percentage),
                gameResult.gameSettings.minPercentOfRightAnswers
            )
            tvScorePercentage.text = String.format(
                getString(R.string.score_percentage),
                getPercentOfRightAnswers()

            )
        }
    }

    private fun getPercentOfRightAnswers() = with(gameResult) {
        if(countOfQuestions ==0){
            0
        } else{
            ((countOfRightAnswers/countOfQuestions.toDouble())*100).toInt()
        }
    }

    private fun getSmileResId(): Int {
        return if(gameResult.winner){
            R.drawable.ic_smile
        } else{
            R.drawable.ic_sad
        }
    }

    private fun setupClickListener() {
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
        findNavController().popBackStack()
    }
    companion object {

        const val  KEY_GAME_RESULT = "game_result"
        fun newInstange(gameResult: GameResult):GameFinishedFragment{
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT,gameResult)
                }
            }
        }
    }
}