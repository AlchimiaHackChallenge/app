package mx.nakva.apphack.features.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.nakva.apphack.R

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object {
        @JvmStatic fun getIntent(context: Context, data: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("data", data)
            return intent
        }

    }
}