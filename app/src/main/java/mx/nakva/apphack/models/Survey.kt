package mx.nakva.apphack.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
data class Survey (
    @SerializedName("s_id") val sId: String,
    val name: String,
    val city: String,
    val age: String,
    val recommendations: Recommendations){
}