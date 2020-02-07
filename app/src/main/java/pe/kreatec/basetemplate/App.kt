package pe.kreatec.basetemplate

import androidx.multidex.MultiDexApplication
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import okhttp3.OkHttpClient
import pe.kreatec.basetemplate.inject.Injector
import timber.log.Timber

class App : MultiDexApplication() {

    init {
        Injector.init(this)
    }

    override fun onCreate() {
        super.onCreate()

        // initialize global instance (if needed)
        instance = this

        // initialize dagger
        Injector.get().inject(this)

        initLogging()
        initCoil()
    }

    private fun initCoil() {
        Coil.setDefaultImageLoader {
            ImageLoader(this) {
                crossfade(true)
                okHttpClient {
                    OkHttpClient.Builder()
                        .cache(CoilUtils.createDefaultCache(this@App))
                        .build()
                }
            }
        }
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: App
    }

}