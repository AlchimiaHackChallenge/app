package mx.nakva.apphack.models

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
data class Product(
    val url: String,
    val model: String,
    val description: String,
    val currentPrice: Double,
    val realPrice: Double,
    val specs: Spec
    ) {
}