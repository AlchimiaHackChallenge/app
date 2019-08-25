package mx.nakva.apphack

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class MainViewModel @Inject constructor(): ViewModel() {

    private val mState = MainState()

    fun getState(): MainState = mState

    fun onClickSearchBtn() {
        Log.d(TAG, "NAILAH onClickSearchBtn: ")
        mState.progressVisibility = View.VISIBLE
    }

    fun onClickNewSession() {
        Log.d(TAG, "NAILAH onClickNewSession: ")
    }
    
    companion object {
        private const val TAG = "MainViewModel"
    }
}