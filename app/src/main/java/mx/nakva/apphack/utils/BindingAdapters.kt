package mx.nakva.apphack.utils

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.text.NumberFormat

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
object BindingAdapters {

    @JvmStatic @BindingAdapter("bind:imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Log.d(TAG, "NAILAH setImageUrl: $url")
        if (url != "" ) {
            Picasso.with(view.context).load(url).fit().centerInside().into(view)
        }
    }
    @JvmStatic @BindingAdapter("bind:priceFrom")
    fun setPriceFrom(view: TextView, value: Double) {
        view.text = "Desde ${NumberFormat.getCurrencyInstance().format(value)}"
    }

    @JvmStatic @BindingAdapter("bind:priceTo")
    fun setPriceTo(view: TextView, value: Double) {
        view.text = "A ${NumberFormat.getCurrencyInstance().format(value)}"
    }


    private const val TAG = "BindingAdapters"
}