package mx.nakva.apphack.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import mx.nakva.apphack.MyApp
import mx.nakva.apphack.R
import mx.nakva.apphack.databinding.ActivitySurveyBinding
import javax.inject.Inject

/**
 * Created by Juancho - j.herandez@arteko.mx on 25/08/19.
 * Powered by Arteko
 */
class SurveyActivity: AppCompatActivity() {

    @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        initViewModel()
    }

    private fun initViewModel() {
        (application as MyApp).appComponent.inject(this)
        val vm = ViewModelProviders.of(this, mViewModelFactory)[SurveyViewModel::class.java]
        initBinder(vm)
    }

    private fun initBinder(vm: SurveyViewModel) {
        val binder: ActivitySurveyBinding = DataBindingUtil.setContentView(this, R.layout.activity_survey)
        binder.lifecycleOwner = this
        binder.vm = vm
    }

    companion object {
        @JvmStatic fun getIntent(context: Context): Intent {
            val intent = Intent(context, SurveyActivity::class.java)
            return intent
        }
    }
}