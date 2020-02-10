package pe.kreatec.basetemplate.ux.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vikingsen.inject.viewmodel.savedstate.SavedStateViewModelFactory
import kotlinx.coroutines.launch
import pe.kreatec.basetemplate.R
import pe.kreatec.basetemplate.databinding.ActivityMainBinding
import pe.kreatec.basetemplate.inject.Injector
import pe.kreatec.basetemplate.ux.adapter.UserAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: SavedStateViewModelFactory.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory.create(this) }

    private val adapter by lazy { UserAdapter() }

    private lateinit var binding: ActivityMainBinding

    init {
        Injector.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpViews()
        setUpObservers()
    }

    private fun setUpViews() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            for (event in viewModel.eventChannel) {
                when (event) {
                    is MainViewModel.Event.ShowLoader -> binding.showLoader = event.show
                    is MainViewModel.Event.LoadUsers -> adapter.users = event.users
                }
            }
        }
        viewModel.loadUsersFromNetwork()
    }
}
