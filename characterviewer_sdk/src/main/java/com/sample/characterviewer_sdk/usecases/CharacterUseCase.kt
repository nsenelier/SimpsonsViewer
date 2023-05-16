package com.sample.characterviewer_sdk.usecases

import com.sample.characterviewer_sdk.model.ProfileChar
import com.sample.characterviewer_sdk.remote.CharacterRepository
import com.sample.characterviewer_sdk.util.AppType
import com.sample.characterviewer_sdk.util.UIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(appType: AppType): Flow<UIState<List<ProfileChar>>> =
        repository.getAllCharacters(appType)
}