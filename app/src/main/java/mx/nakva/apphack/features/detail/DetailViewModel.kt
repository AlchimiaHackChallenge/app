package mx.nakva.apphack.features.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import mx.nakva.apphack.models.Product
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class DetailViewModel @Inject constructor(): ViewModel() {

    fun loadData(data: String) {
        val product = Gson().fromJson(data, Product::class.java)
        Log.d(TAG, "NAILAH loadData: $product")
    }

    companion object {
        private const val TAG = "DetailViewModel"
    }

}