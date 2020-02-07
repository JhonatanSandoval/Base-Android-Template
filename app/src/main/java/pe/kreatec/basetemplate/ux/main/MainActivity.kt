package pe.kreatec.basetemplate.ux.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.vikingsen.inject.viewmodel.savedstate.SavedStateViewModelFactory
import kotlinx.coroutines.launch
import pe.kreatec.basetemplate.R
import pe.kreatec.basetemplate.databinding.ActivityMainBinding
import pe.kreatec.basetemplate.inject.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: SavedStateViewModelFactory.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory.create(this) }

    private lateinit var binding: ActivityMainBinding

    init {
        Injector.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpObservers()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            for (event in viewModel.eventChannel) {
                when (event) {

                }
            }
        }
    }
}
