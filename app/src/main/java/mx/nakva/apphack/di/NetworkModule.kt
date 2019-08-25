package mx.nakva.apphack.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Module(includes = [AppComponent::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideRequestQueue(context: Context): RequestQueue = Volley.newRequestQueue(context)

}