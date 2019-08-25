package mx.nakva.apphack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import mx.nakva.apphack.databinding.ActivityMainBinding
import mx.nakva.apphack.features.SurveyActivity
import mx.nakva.apphack.wrappers.Event
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDI()
    }

    private fun initDI() {
        (application as  MyApp).appComponent.inject(this)
        val vm = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        vm.getSurveyObserver().observe(this, Observer { onSurveyEventChange(it) })
        bindLayout(vm)
    }

    private fun onSurveyEventChange(event: Event<Int>?) {
        event?.getContentIfNotHandled()?.let { requestCode ->
            val intent = SurveyActivity.getIntent(this)
            startActivityForResult(intent, requestCode)
        }
    }

    private fun bindLayout(vm: MainViewModel) {
        val binder: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binder.lifecycleOwner = this
        binder.vm = vm
        binder.state = vm.getState()
    }
}
