package ru.potemkin.composition.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.potemkin.composition.domain.entities.Level

class GameViewModelFactory (
    private val level: Level,
    private val application: Application
        ):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(application, level) as T
        }
        throw java.lang.RuntimeException("Unknown View model class $modelClass")
    }
}