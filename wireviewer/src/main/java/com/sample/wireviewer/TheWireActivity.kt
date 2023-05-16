package com.sample.wireviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sample.characterviewer_sdk.ShowSdk
import com.sample.characterviewer_sdk.util.AppType
import com.sample.characterviewer_sdk.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TheWireActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ShowSdk.launchApplication(applicationContext, AppType.THE_WIRE)
    }
}