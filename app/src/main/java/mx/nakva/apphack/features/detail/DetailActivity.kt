package mx.nakva.apphack.features.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import mx.nakva.apphack.MyApp
import mx.nakva.apphack.R
import mx.nakva.apphack.databinding.ActivityDetailBinding
import mx.nakva.apphack.models.Product
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class DetailActivity: AppCompatActivity() {

    @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViewModel()
    }

    private fun initViewModel() {
        (application as MyApp).appComponent.inject(this)
        val vm = ViewModelProviders.of(this, mViewModelFactory)[DetailViewModel::class.java]
        val data = intent.getStringExtra("data")
        val product = Gson().fromJson(data, Product::class.java)
        val binder: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binder.product = product
        binder.lifecycleOwner = this
    }

    companion object {
        @JvmStatic fun getIntent(context: Context, data: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("data", data)
            return intent
        }

    }
}