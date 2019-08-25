package mx.nakva.apphack.network

import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.JsonObject
import org.json.JSONObject
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyService @Inject constructor(private val requestQueue: RequestQueue) {

    fun sendSurvey(onComplete: (String?, String?) -> Unit) {
        val url = "10.10.4.244:3000/api/intent"
        val param = JSONObject()

        val request = object : JsonObjectRequest(Method.POST, url, param,
            Response.Listener<JSONObject> { response: JSONObject? ->
                Log.d(TAG, "NAILAH sendSurvey: success")
            },
            Response.ErrorListener { error: VolleyError ->
                Log.d(TAG, "NAILAH sendSurvey: Error")
            }) {
        }
        requestQueue.add(request)
    }

    companion object {
        private const val TAG = "SurveyService"
    }
}