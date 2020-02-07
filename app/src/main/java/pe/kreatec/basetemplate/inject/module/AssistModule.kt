package pe.kreatec.basetemplate.inject.module

import com.vikingsen.inject.viewmodel.ViewModelModule
import dagger.Module

@ViewModelModule
@Module(includes = [ViewModelInject_AssistModule::class])
abstract class AssistModule
