package pe.kreatec.basetemplate.inject.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [AssistModule::class])
class AppModule(private val application: Application) {

    @Provides
    fun provideGlobalContext(): Context = application.applicationContext

}
