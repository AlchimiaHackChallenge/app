package mx.nakva.apphack.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

}