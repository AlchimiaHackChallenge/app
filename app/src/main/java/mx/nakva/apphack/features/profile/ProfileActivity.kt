package mx.nakva.apphack.features.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import mx.nakva.apphack.MyApp
import mx.nakva.apphack.R
import mx.nakva.apphack.databinding.ActivityProfileBinding
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
    }

    private fun bindView(vm: ProfileViewModel) {
        val binder: ActivityProfileBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_profile)
        binder.vm = vm
        binder.state = vm.getState()
        binder.lifecycleOwner = this
    }

    companion object {
        @JvmStatic fun getIntent(context: Context, sId: String): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("id", sId)
            return intent
        }
    }
}