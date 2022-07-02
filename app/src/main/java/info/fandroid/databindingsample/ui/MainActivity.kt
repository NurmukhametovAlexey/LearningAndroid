package info.fandroid.databindingsample.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import info.fandroid.databindingsample.R
import info.fandroid.databindingsample.data.SimpleViewModel
import info.fandroid.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<SimpleViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
