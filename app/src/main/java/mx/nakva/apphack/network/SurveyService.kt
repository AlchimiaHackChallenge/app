package mx.nakva.apphack.network

import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import mx.nakva.apphack.features.survey.SurveyState
import mx.nakva.apphack.models.Survey
import org.json.JSONObject
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyService @Inject constructor(private val requestQueue: RequestQueue) {

    fun sendSurvey(state: SurveyState, onComplete: (sId: String?) -> Unit) {
        onComplete("asdad")
        /*
        val url = NetworkConstant.BASE_URL
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
                    val sId = response.getString("s_id")
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
         */
    }

    fun getSurvey(id: String, onComplete: (Survey?) -> Unit) {
        val json = "{\n" +
                "  \"_id\": \"5d62509be1626d3df609aece\",\n" +
                "  \"widget\": {\n" +
                "    \"q1\": \"1\",\n" +
                "    \"q2\": \"1\",\n" +
                "    \"q3\": \"1\",\n" +
                "    \"q4\": \"2\"\n" +
                "  },\n" +
                "  \"name\": \"Juan Carlos Hernández\",\n" +
                "  \"city\": \"Ciudad de México\",\n" +
                "  \"age\": \"33\",\n" +
                "  \"s_id\": \"170823\",\n" +
                "  \"recommendations\": {\n" +
                "    \"r1\": {\n" +
                "      \"url\": \"http://italika.mx/WebVisorArchivosITK/Archivo.aspx?Tipo=3&Archivo=WebPortalMexicoITK/img/Modelos/Trabajo/Maxis/FT250TS.png\",\n" +
                "      \"model\": \"FT 250 TS\",\n" +
                "      \"description\": \"Esta motocicleta de trabajo es para los que buscan una fiel compañera que les permita ser más productivos en sus días.\",\n" +
                "      \"currentPrice\": 36109.64,\n" +
                "      \"realPrice\": 30999,\n" +
                "      \"specs\": {\n" +
                "        \"engine\": [\n" +
                "          {\n" +
                "            \"title\": \"Tips de motor\",\n" +
                "            \"description\": \"4 Tiempos, monocilindrico\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Cilindrada\",\n" +
                "            \"description\": \"250 CC\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Velocidad máxima\",\n" +
                "            \"description\": \"120 km/h\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Potencia máxima\",\n" +
                "            \"description\": \"18 Hp @ 8500 RPM\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Torque máximo\",\n" +
                "            \"description\": \"16.g N-m @ 6500 RPM\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Rendimiento de combustible\",\n" +
                "            \"description\": \"24 km/L\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Sistema de arranque\",\n" +
                "            \"description\": \"Eléctrico y de pedal\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Transmisión Final\",\n" +
                "            \"description\": \"16 L\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Rendimiento de combustible por tanque\",\n" +
                "            \"description\": \"384 km\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Capacidad de Aceite\",\n" +
                "            \"description\": \"1.1 L\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"chasis\": [\n" +
                "          {\n" +
                "            \"title\": \"Suspensión delantera\",\n" +
                "            \"description\": \"Horquilla telescópica\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Suspensión trasera\",\n" +
                "            \"description\": \"Basculante con doble amortiguador\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Frenos delanteros\",\n" +
                "            \"description\": \"Disco sencillo\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Frenos traseros\",\n" +
                "            \"description\": \"Tambor\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Llanta delantera\",\n" +
                "            \"description\": \"80/90-R18\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Llanta trasera\",\n" +
                "            \"description\": \"110/80-R18\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"dims\": [\n" +
                "          {\n" +
                "            \"title\": \"Largo total\",\n" +
                "            \"description\": \"2100 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Ancho total\",\n" +
                "            \"description\": \"700 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Alto total\",\n" +
                "            \"description\": \"1030 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Altura del asiento\",\n" +
                "            \"description\": \"770 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Capacidad de carga\",\n" +
                "            \"description\": \"150 kg\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Peso en seco\",\n" +
                "            \"description\": \"124.5 kg\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    \"r2\": {\n" +
                "      \"url\": \"http://italika.mx/WebVisorArchivosITK/Archivo.aspx?Tipo=3&Archivo=WebPortalMexicoITK/img/Modelos/Trabajo/Maxis/FT150TS.png\",\n" +
                "      \"model\": \"ZT 350 TS\",\n" +
                "      \"description\": \"Esta motocicleta de trabajo es para los que buscan una fiel compañera que les permita ser más productivos en sus días.\",\n" +
                "      \"currentPrice\": 40000.64,\n" +
                "      \"realPrice\": 40000,\n" +
                "      \"specs\": {\n" +
                "        \"engine\": [\n" +
                "          {\n" +
                "            \"title\": \"Tips de motor\",\n" +
                "            \"description\": \"4 Tiempos, monocilindrico\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Cilindrada\",\n" +
                "            \"description\": \"250 CC\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Velocidad máxima\",\n" +
                "            \"description\": \"120 km/h\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Potencia máxima\",\n" +
                "            \"description\": \"18 Hp @ 8500 RPM\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Torque máximo\",\n" +
                "            \"description\": \"16.g N-m @ 6500 RPM\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Rendimiento de combustible\",\n" +
                "            \"description\": \"24 km/L\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Sistema de arranque\",\n" +
                "            \"description\": \"Eléctrico y de pedal\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Transmisión Final\",\n" +
                "            \"description\": \"16 L\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Rendimiento de combustible por tanque\",\n" +
                "            \"description\": \"384 km\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Capacidad de Aceite\",\n" +
                "            \"description\": \"1.1 L\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"chasis\": [\n" +
                "          {\n" +
                "            \"title\": \"Suspensión delantera\",\n" +
                "            \"description\": \"Horquilla telescópica\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Suspensión trasera\",\n" +
                "            \"description\": \"Basculante con doble amortiguador\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Frenos delanteros\",\n" +
                "            \"description\": \"Disco sencillo\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Frenos traseros\",\n" +
                "            \"description\": \"Tambor\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Llanta delantera\",\n" +
                "            \"description\": \"80/90-R18\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Llanta trasera\",\n" +
                "            \"description\": \"110/80-R18\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"dims\": [\n" +
                "          {\n" +
                "            \"title\": \"Largo total\",\n" +
                "            \"description\": \"2100 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Ancho total\",\n" +
                "            \"description\": \"700 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Alto total\",\n" +
                "            \"description\": \"1030 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Altura del asiento\",\n" +
                "            \"description\": \"770 mm\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Capacidad de carga\",\n" +
                "            \"description\": \"150 kg\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"Peso en seco\",\n" +
                "            \"description\": \"124.5 kg\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"createdAt\": \"2019-08-25T09:10:51.106Z\",\n" +
                "  \"updatedAt\": \"2019-08-25T09:10:51.106Z\",\n" +
                "  \"__v\": 0\n" +
                "}"
        val survey = Gson().fromJson(json, Survey::class.java)
        onComplete(survey)
        /*
        val url = "${NetworkConstant.BASE_URL}$id"
        val request = object : JsonObjectRequest(Method.GET, url, JSONObject(),
            Response.Listener<JSONObject> { response: JSONObject? ->
                if (response != null) {
                    val survey = Gson().fromJson(response.toString(), Survey::class.java)
                    onComplete(survey)
                }
                else {
                    onComplete(null)
                }
            },
            Response.ErrorListener { error: VolleyError ->
                onComplete(null)
                error.printStackTrace()
            }) {
        }
        requestQueue.add(request)
        */
    }

    companion object {
        private const val TAG = "SurveyService"
    }
}