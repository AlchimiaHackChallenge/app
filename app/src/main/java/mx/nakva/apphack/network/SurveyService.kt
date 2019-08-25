package mx.nakva.apphack.network

import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.JsonObject
import mx.nakva.apphack.features.SurveyState
import org.json.JSONObject
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyService @Inject constructor(private val requestQueue: RequestQueue) {

    fun sendSurvey(state: SurveyState, onComplete: (sId: Int?) -> Unit) {
        val url = "http://10.10.4.244:3000/api/intent"
        val param = JSONObject()
        val widget = JSONObject()
        widget.put("q1", state.q1Response)
        widget.put("q2", state.q2Response)
        widget.put("q3", state.q3Response)
        widget.put("q4", state.q4Response)
        param.put("widget", widget)
        param.put("name", state.name)
        param.put("city", state.city)
        param.put("age", state.age)

        val request = object : JsonObjectRequest(Method.POST, url, param,
            Response.Listener<JSONObject> { response: JSONObject? ->
                Log.d(TAG, "NAILAH sendSurvey: success $response")
                if (response != null && response.has("s_id")) {
                    val sId = response.getInt("s_id")
                    onComplete(sId)
                }
                else {
                    onComplete(null)
                }
            },
            Response.ErrorListener { error: VolleyError ->
                Log.d(TAG, "NAILAH sendSurvey: Error")
                onComplete(null)
                error.printStackTrace()
            }) {
        }
        requestQueue.add(request)
    }

    companion object {
        private const val TAG = "SurveyService"
    }
}