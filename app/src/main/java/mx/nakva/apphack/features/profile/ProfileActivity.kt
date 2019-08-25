package mx.nakva.apphack.features.profile

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import mx.nakva.apphack.MyApp
import mx.nakva.apphack.R
import mx.nakva.apphack.databinding.ActivityProfileBinding
import mx.nakva.apphack.features.detail.DetailActivity
import mx.nakva.apphack.wrappers.Event
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class ProfileActivity: AppCompatActivity() {

    @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViewModel()
    }

    private fun initViewModel() {
        (application as MyApp).appComponent.inject(this)
        val vm = ViewModelProviders.of(this, mViewModelFactory)[ProfileViewModel::class.java]
        bindView(vm)

        val id = intent.getStringExtra("id")
        vm.loadSurvey(id)
        vm.getErrorObserver().observe(this, Observer { onErrorEventChanged(it) })
        vm.getDetailObserver().observe(this, Observer { onDetailEventChanged(it) })
    }

    private fun bindView(vm: ProfileViewModel) {
        val binder: ActivityProfileBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_profile)
        binder.vm = vm
        binder.state = vm.getState()
        binder.lifecycleOwner = this
        val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK1uiEiCql_ilBbUoLSATpXLE6gwdbWsJSFCv6p1Iuf5pLsGLS"
        Picasso.with(this).load(url).fit().centerInside().into(binder.imageView)
    }

    private fun onErrorEventChanged(event: Event<Int>?) {
        event?.getContentIfNotHandled()?.let {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.error)
            builder.setMessage(R.string.error_loading_profile)
            builder.setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
            builder.setOnDismissListener {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
            val alert = builder.create()
            alert.show()
        }
    }

    private fun onDetailEventChanged(event: Event<String>?) {
        event?.getContentIfNotHandled()?.let { data ->
            val intent = DetailActivity.getIntent(this, data)
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic fun getIntent(context: Context, sId: String): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("id", sId)
            return intent
        }
    }
}