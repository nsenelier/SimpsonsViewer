package com.sample.characterviewer_sdk

import android.content.Context
import android.content.Intent
import com.sample.characterviewer_sdk.util.AppType
import com.sample.characterviewer_sdk.view.BaseMainActivity

interface IShowSdk {
    fun launchApplication(context: Context, appType: AppType)
}

object ShowSdk : IShowSdk{

    override fun launchApplication(context: Context, appType: AppType) {
        Intent(context, BaseMainActivity::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra("APP_TYPE", appType)
            context.startActivity(this)
        }
    }

}