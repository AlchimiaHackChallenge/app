package mx.nakva.apphack.di

import dagger.Component
import mx.nakva.apphack.MainActivity
import mx.nakva.apphack.features.survey.SurveyActivity
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class,
    DatabaseModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: SurveyActivity)
}