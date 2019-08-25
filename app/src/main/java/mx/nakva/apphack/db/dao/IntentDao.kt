package mx.nakva.apphack.db.dao

import androidx.room.*
import mx.nakva.apphack.db.entities.DBIntent

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
interface IntentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(blob: DBIntent)

    @Update
    fun update(blob: DBIntent)

    @Delete
    fun delete(blob: DBIntent)

    @Query("SELECT * FROM DBIntent where id = :id")
    fun getById(id: String): DBIntent?

}