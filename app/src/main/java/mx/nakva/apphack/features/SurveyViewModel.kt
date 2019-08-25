package mx.nakva.apphack.features

import android.util.Log
import android.widget.RadioGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.nakva.apphack.R
import mx.nakva.apphack.network.SurveyService
import mx.nakva.apphack.wrappers.Event
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyViewModel @Inject constructor(private val mService: SurveyService): ViewModel() {

    private var mState: SurveyState = SurveyState()
    private var mCloseActivityResult = MutableLiveData<Event<Int>>()

    fun getState() = mState

    fun getCloseActivityResultObserver(): LiveData<Event<Int>> = mCloseActivityResult

    fun onClickNextBtn() {
        mService.sendSurvey(mState) { sId ->
            Log.d(TAG, "NAILAH onClickNextBtn: $sId")
            if (sId != null) {
                mCloseActivityResult.value = Event(sId)
            }
            else {
                //TODO raise an error
            }
        }
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