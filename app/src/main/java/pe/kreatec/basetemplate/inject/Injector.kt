package pe.kreatec.basetemplate.inject

import pe.kreatec.basetemplate.App
import pe.kreatec.basetemplate.inject.component.AppComponent
import pe.kreatec.basetemplate.inject.component.DaggerAppComponent
import pe.kreatec.basetemplate.inject.module.AppModule

object Injector {

    private var appComponent: AppComponent? = null

    @Synchronized
    fun init(app: App) {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(AppModule(app)).build()
        }
    }

    fun get(): AppComponent {
        appComponent?.let { return it }
        throw IllegalStateException("appComponent is null. Call init() prior to calling get()")
    }

}