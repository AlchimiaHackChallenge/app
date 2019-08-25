package mx.nakva.apphack.di

import dagger.Component
import mx.nakva.apphack.MainActivity
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(target: MainActivity)
}