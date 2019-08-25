package mx.nakva.apphack

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class MainState: BaseObservable() {

    @get:Bindable
    var codeValue: String = ""
    set(value) {
        field = value
        Log.d(TAG, "NAILAH codeValue: $field")
        notifyPropertyChanged(BR.codeValue)
    }

    companion object {
        private const val TAG = "MainState"
    }
}