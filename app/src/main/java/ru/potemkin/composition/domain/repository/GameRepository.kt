package ru.potemkin.composition.domain.repository

import ru.potemkin.composition.domain.entities.GameSettings
import ru.potemkin.composition.domain.entities.Level
import ru.potemkin.composition.domain.entities.Question

interface GameRepository {

    fun generateQuestion(maxSumValue:Int,countOfOptions:Int):Question

    fun getGameSettings(level: Level):GameSettings
}