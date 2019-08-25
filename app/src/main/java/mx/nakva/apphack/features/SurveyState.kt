package mx.nakva.apphack.features

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyState: BaseObservable() {

    var q1Response: String = "1"
    var q2Response: String = "1"
    var q3Response: String = "1"
    var q4Response: String = "1"

    override fun toString(): String {
        return "Survey Sate: { q1Response: $q1Response, q2Response: $q2Response," +
                " q3Response: $q3Response, q4Response: $q4Response }"
    }
}