package mx.nakva.apphack.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mx.nakva.apphack.MainViewModel
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Singleton
    internal abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel
}