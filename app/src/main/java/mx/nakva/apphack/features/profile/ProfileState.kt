package mx.nakva.apphack.features.profile

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class ProfileState: BaseObservable() {

    @get:Bindable
    var progressVisibility: Int = View.INVISIBLE
    set(value) {
        field = value
        notifyPropertyChanged(BR.progressVisibility)
    }

    @get:Bindable
    var name: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }

    @get:Bindable
    var age: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }

    @get:Bindable
    var city: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.city)
        }

    @get:Bindable
    var id: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @get:Bindable
    var product1Url: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product1Url)
        }

    @get:Bindable
    var product1Price: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product1Price)
        }

    @get:Bindable
    var product1CurrentPrice: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product1CurrentPrice)
        }

    @get:Bindable
    var product1Model: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product1Model)
        }

    @get:Bindable
    var product2Url: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product2Url)
        }

    @get:Bindable
    var product2Price: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product2Price)
        }

    @get:Bindable
    var product2CurrentPrice: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product2CurrentPrice)
        }

    @get:Bindable
    var product2Model: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.product2Model)
        }
}