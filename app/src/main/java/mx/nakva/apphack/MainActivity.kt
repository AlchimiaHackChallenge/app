package mx.nakva.apphack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import mx.nakva.apphack.databinding.ActivityMainBinding
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
        bindLayout(vm)
    }

    private fun bindLayout(vm: MainViewModel) {
        val binder: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binder.lifecycleOwner = this
        binder.vm = vm
        binder.state = vm.getState()
    }
}
