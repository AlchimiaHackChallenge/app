package mx.nakva.apphack.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.nakva.apphack.R

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
    }

    companion object {
        @JvmStatic fun getIntent(context: Context): Intent {
            val intent = Intent(context, SurveyActivity::class.java)
            return intent
        }
    }
}