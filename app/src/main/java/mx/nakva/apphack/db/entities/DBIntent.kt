package mx.nakva.apphack.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
@Entity
data class DBIntent(@PrimaryKey(autoGenerate = false) var id: String = "")