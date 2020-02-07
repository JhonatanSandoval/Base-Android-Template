package pe.kreatec.basetemplate.inject.component

import dagger.Component
import pe.kreatec.basetemplate.App
import pe.kreatec.basetemplate.inject.module.AppModule
import pe.kreatec.basetemplate.ux.main.MainActivity

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)

    // activities
    fun inject(mainActivity: MainActivity)
}