package com.sample.characterviewer_sdk.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.sample.characterviewer_sdk.R
import com.sample.characterviewer_sdk.util.AppType
import com.sample.characterviewer_sdk.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseMainActivity : AppCompatActivity() {
    private val viewModel by lazy{
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_main)

        viewModel.appType = intent.getSerializableExtra("APP_TYPE") as AppType

        val host = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

        setupActionBarWithNavController(host.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.frag_container).navigateUp()
    }

}
