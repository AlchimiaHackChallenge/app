package mx.nakva.apphack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import mx.nakva.apphack.databinding.ActivityMainBinding
import mx.nakva.apphack.features.profile.ProfileActivity
import mx.nakva.apphack.features.survey.SurveyActivity
import mx.nakva.apphack.wrappers.Event
import mx.nakva.apphack.wrappers.ProfileLauncher
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var mViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mViewModel?.onActivityResult(requestCode, resultCode, data)
    }

    private fun initDI() {
        (application as  MyApp).appComponent.inject(this)
        val vm = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        vm.getSurveyObserver().observe(this, Observer { onSurveyEventChange(it) })
        vm.getProfileObserver().observe(this, Observer { onProfileEventChange(it) })
        mViewModel = vm
        bindLayout(vm)
    }

    private fun onSurveyEventChange(event: Event<Int>?) {
        event?.getContentIfNotHandled()?.let { requestCode ->
            val intent = SurveyActivity.getIntent(this)
            startActivityForResult(intent, requestCode)
        }
    }

    private fun onProfileEventChange(event: Event<ProfileLauncher>?) {
        event?.getContentIfNotHandled()?.let { launcher ->
            val intent = ProfileActivity.getIntent(this, launcher.id)
            startActivityForResult(intent, launcher.requestCode)
        }
    }

    private fun bindLayout(vm: MainViewModel) {
        val binder: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binder.lifecycleOwner = this
        binder.vm = vm
        binder.state = vm.getState()
    }
}
