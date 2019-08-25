package mx.nakva.apphack.features.profile

import android.view.View
import androidx.lifecycle.ViewModel
import mx.nakva.apphack.models.Survey
import mx.nakva.apphack.network.SurveyService
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class ProfileViewModel @Inject constructor(private val mService: SurveyService): ViewModel() {

    private var mState =  ProfileState()

    fun getState() = mState

    init {

    }

    fun loadSurvey(id: String) {
        mState.progressVisibility = View.VISIBLE
        mService.getSurvey(id) { survey: Survey? ->
            if (survey != null) {
                mState.name = survey.name
                mState.age = survey.age
                mState.city = survey.city
                mState.id = survey.sId
            }
        }
    }

}