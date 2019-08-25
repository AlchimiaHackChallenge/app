package mx.nakva.apphack

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.nakva.apphack.wrappers.Event
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class MainViewModel @Inject constructor(): ViewModel() {

    private val mState = MainState()
    private val mSurveyLauncher = MutableLiveData<Event<Int>>()

    fun getState(): MainState = mState

    fun getSurveyObserver(): LiveData<Event<Int>> = mSurveyLauncher

    fun onClickSearchBtn() {
        Log.d(TAG, "NAILAH onClickSearchBtn: ")
        mState.progressVisibility = View.VISIBLE
    }

    fun onClickNewSession() {
        mSurveyLauncher.value = Event(1)
    }
    
    companion object {
        private const val TAG = "MainViewModel"
    }
}