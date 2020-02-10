package pe.kreatec.basetemplate.ux.main

import com.vikingsen.inject.viewmodel.ViewModelInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.kreatec.basetemplate.remote.repository.UserRepository
import pe.kreatec.basetemplate.remote.response.UserResponse
import pe.kreatec.basetemplate.remote.util.ApiResponse
import pe.kreatec.basetemplate.util.ui.scope.ioScope
import pe.kreatec.basetemplate.util.ui.viewmodel.BaseViewModel
import timber.log.Timber

class MainViewModel
@ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel<MainViewModel.Event>(), CoroutineScope by ioScope() {

    fun loadUsersFromNetwork() = launch {
        sendEvent(Event.ShowLoader(true))
        when (val result = userRepository.getUsers()) {
            is ApiResponse.Success -> result.items?.let { sendEvent(Event.LoadUsers(it)) }
            is ApiResponse.Error -> Timber.e("apiResponse ERROR: ${result.errorMessage}")
            is ApiResponse.Exception -> Timber.e(result.exception)
        }
        sendEvent(Event.ShowLoader(false))
    }

    sealed class Event {
        data class ShowLoader(val show: Boolean) : Event()
        data class LoadUsers(val users: List<UserResponse>) : Event()
    }

}