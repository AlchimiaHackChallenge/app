package mx.nakva.apphack.features.profile

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.nakva.apphack.models.Survey
import mx.nakva.apphack.network.SurveyService
import mx.nakva.apphack.wrappers.Event
import java.text.NumberFormat
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class ProfileViewModel @Inject constructor(private val mService: SurveyService): ViewModel() {

    private var mState =  ProfileState()
    private var mError = MutableLiveData<Event<Int>>()

    fun getState() = mState

    fun getErrorObserver(): LiveData<Event<Int>> = mError

    init {

    }

    @SuppressLint("DefaultLocale")
    fun loadSurvey(id: String) {
        mState.progressVisibility = View.VISIBLE
        mService.getSurvey(id) { survey: Survey? ->
            mState.progressVisibility = View.INVISIBLE
            if (survey != null) {
                mState.name = survey.name.toUpperCase()
                mState.age = survey.age
                mState.city = survey.city.toUpperCase()
                mState.id = survey.sId
                val numberFormat = NumberFormat.getNumberInstance()
                val r1 = survey.recommendations.r1
                mState.product1Url = r1.url
                mState.product1CurrentPrice = "A ${numberFormat.format(r1.currentPrice)}"
                mState.product1Price = "De ${numberFormat.format(r1.realPrice)}"
                mState.product1Model = r1.model.toUpperCase()

                val r2 = survey.recommendations.r2
                mState.product2Url = r2.url
                mState.product2CurrentPrice = "A ${numberFormat.format(r2.currentPrice)}"
                mState.product2Price = "De ${numberFormat.format(r2.realPrice)}"
                mState.product2Model = r2.model.toUpperCase()
            }
            else {
                mError.value = Event(1)
            }
        }
    }
}