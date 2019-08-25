package mx.nakva.apphack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.nakva.apphack.db.dao.IntentDao
import mx.nakva.apphack.db.entities.DBIntent

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Database(entities = [DBIntent::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun intentDao(): IntentDao

    companion object {
        fun getInstance(context: Context): mx.nakva.apphack.db.Database {
            return Room.databaseBuilder(context.applicationContext,
                mx.nakva.apphack.db.Database::class.java,
                "hackDb.db")
                .allowMainThreadQueries()
                .build()
        }
    }

}