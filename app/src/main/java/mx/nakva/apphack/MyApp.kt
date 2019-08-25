package mx.nakva.apphack

import android.app.Application
import mx.nakva.apphack.di.AppComponent
import mx.nakva.apphack.di.AppModule
import mx.nakva.apphack.di.DaggerAppComponent

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class MyApp: Application() {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: MyApp): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}