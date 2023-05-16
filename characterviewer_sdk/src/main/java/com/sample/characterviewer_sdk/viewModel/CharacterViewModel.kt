package com.sample.characterviewer_sdk.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.characterviewer_sdk.model.ProfileChar
import com.sample.characterviewer_sdk.usecases.CharacterUseCase
import com.sample.characterviewer_sdk.util.AppType
import com.sample.characterviewer_sdk.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
): ViewModel() {

    var appType: AppType? = null

    private val _characters: MutableLiveData<UIState<List<ProfileChar>>> = MutableLiveData(UIState.Loading)
    val characters: LiveData<UIState<List<ProfileChar>>> get() = _characters

    private val _selectedChar: MutableLiveData<ProfileChar?> = MutableLiveData(null)
    val selectedChar: LiveData<ProfileChar?> get()  = _selectedChar

    fun setSelectedItem(item: ProfileChar){
        _selectedChar.value = item
    }

    init {
        getCharacterList(appType)
    }

    fun getCharacterList(charType: AppType?) {
            charType?.let {
                viewModelScope.launch {
                characterUseCase(it).collect{
                    _characters.postValue(it)
                }
            }
        }
    }



}