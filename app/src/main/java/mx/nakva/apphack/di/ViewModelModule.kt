package mx.nakva.apphack.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mx.nakva.apphack.MainViewModel
import mx.nakva.apphack.features.survey.SurveyViewModel
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Singleton
    internal abstract fun provideViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SurveyViewModel::class)
    @Singleton
    internal abstract fun provideSurveyViewModel(viewModel: SurveyViewModel): ViewModel

}