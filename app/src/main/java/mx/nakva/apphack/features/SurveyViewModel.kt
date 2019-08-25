package mx.nakva.apphack.features

import android.util.Log
import android.widget.RadioGroup
import androidx.lifecycle.ViewModel
import mx.nakva.apphack.R
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyViewModel @Inject constructor(): ViewModel() {

    private var mState: SurveyState = SurveyState()

    fun onClickNextBtn() {
        Log.d(TAG, "NAILAH onClickNextBtn ")
    }

    fun onRadioGroupChanged(id: Int) {
        when (id) {
            R.id.rdBtnQ1R1 -> mState.q1Response = "1"
            R.id.rdBtnQ1R2 -> mState.q1Response = "2"
            R.id.rdBtnQ2R1 -> mState.q2Response = "1"
            R.id.rdBtnQ2R2 -> mState.q2Response = "2"
            R.id.rdBtnQ2R3 -> mState.q2Response = "3"
            R.id.rdBtnQ3R1 -> mState.q3Response = "1"
            R.id.rdBtnQ3R2 -> mState.q3Response = "2"
            R.id.rdBtnQ3R3 -> mState.q3Response = "3"
            R.id.rdBtnQ3R4 -> mState.q3Response = "4"
            R.id.rdBtnQ4R1 -> mState.q4Response = "1"
            R.id.rdBtnQ4R2 -> mState.q4Response = "2"
            R.id.rdBtnQ4R3 -> mState.q4Response = "3"
        }
        Log.d(TAG, "NAILAH onRadioGroupChanged $mState")
    }

    companion object {
        private const val TAG = "SurveyViewModel"
    }
}