package mx.nakva.apphack.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mx.nakva.apphack.db.Database
import mx.nakva.apphack.db.dao.IntentDao
import javax.inject.Singleton

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Module(includes = [AppModule::class])
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database {
        return Database.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideIntentDao(db: Database): IntentDao = db.intentDao()
}