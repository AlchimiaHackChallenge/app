package mx.nakva.apphack.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
object BindingAdapters {

    @JvmStatic @BindingAdapter("bind:imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Picasso.with(view.context).load(url).fit().centerInside().into(view)
    }

}