package pe.kreatec.basetemplate.util.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import pe.kreatec.basetemplate.util.ui.scope.ioScope

abstract class BaseViewModel<T> : ViewModel(), CoroutineScope by ioScope() {
    private val _eventChannel = Channel<T>()
    val eventChannel: ReceiveChannel<T> = _eventChannel

    protected fun sendEvent(event: T) = viewModelScope.launch {
        _eventChannel.send(event)
    }

    override fun onCleared() {
        _eventChannel.close()
        super.onCleared()
    }
}
