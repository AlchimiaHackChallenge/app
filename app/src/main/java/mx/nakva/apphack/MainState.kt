package mx.nakva.apphack

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
        notifyPropertyChanged(BR.codeValue)
    }
}