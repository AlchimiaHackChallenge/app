package mx.nakva.apphack.features.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.nakva.apphack.R

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class ProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    companion object {
        @JvmStatic fun getIntent(context: Context, sId: String): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("id", sId)
            return intent
        }
    }
}