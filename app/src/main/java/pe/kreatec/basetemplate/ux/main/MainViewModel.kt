package pe.kreatec.basetemplate.ux.main

import com.vikingsen.inject.viewmodel.ViewModelInject
import pe.kreatec.basetemplate.util.ui.viewmodel.BaseViewModel

class MainViewModel
@ViewModelInject constructor(

) : BaseViewModel<MainViewModel.Event>() {

    sealed class Event {

    }

}