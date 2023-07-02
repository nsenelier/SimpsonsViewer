package com.sample.simpsonsviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.characterviewer_sdk.ShowSdk
import com.sample.characterviewer_sdk.util.AppType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TheSimpsonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShowSdk.launchApplication(applicationContext, AppType.SIMPSONS)

    }

}