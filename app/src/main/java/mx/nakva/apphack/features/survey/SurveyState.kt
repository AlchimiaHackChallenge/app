package mx.nakva.apphack.features.survey

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyState: BaseObservable() {

    var q1Response: String = "1"
    var q2Response: String = "1"
    var q3Response: String = "1"
    var q4Response: String = "1"

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
    var city: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.city)
        }

    @get:Bindable
    var age: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }

    override fun toString(): String {
        return "Survey Sate: { q1Response: $q1Response, q2Response: $q2Response," +
                " q3Response: $q3Response, q4Response: $q4Response, " +
                " name: $name, age: $age, $city: city}"
    }
}