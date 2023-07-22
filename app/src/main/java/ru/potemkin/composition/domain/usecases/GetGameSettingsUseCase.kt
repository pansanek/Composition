package ru.potemkin.composition.domain.usecases

import ru.potemkin.composition.domain.entities.GameSettings
import ru.potemkin.composition.domain.entities.Level
import ru.potemkin.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return repository.getGameSettings(level)
    }
}