package pe.kreatec.basetemplate.inject.component

import android.app.Application
import dagger.Component
import pe.kreatec.basetemplate.App
import pe.kreatec.basetemplate.inject.module.AppModule
import pe.kreatec.basetemplate.ux.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)

    // activities
    fun inject(mainActivity: MainActivity)

    // for child
    fun application() : Application
}