package mx.nakva.apphack.features

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
import mx.nakva.apphack.MyApp
import mx.nakva.apphack.R
import mx.nakva.apphack.databinding.ActivitySurveyBinding
import mx.nakva.apphack.wrappers.Event
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
        vm.getCloseActivityResultObserver().observe(this, Observer { onCloseActivityResultChanged(it) })
        vm.getErrorObserver().observe(this, Observer { onErrorEventChanged(it) })
        initBinder(vm)
    }

    private fun initBinder(vm: SurveyViewModel) {
        val binder: ActivitySurveyBinding = DataBindingUtil.setContentView(this, R.layout.activity_survey)
        binder.lifecycleOwner = this
        binder.vm = vm
        binder.state = vm.getState()
    }

    private fun onCloseActivityResultChanged(event: Event<SurveyActivityResponse>?) {
        event?.getContentIfNotHandled()?.let { res ->
            var intent: Intent? = null
            val sId = res.sId
            if (sId != null) {
                intent = Intent()
                intent.putExtra("id", sId)
            }
            setResult(res.resultCode, intent)
            finish()
        }
    }

    private fun onErrorEventChanged(event: Event<Int>?) {
        event?.getContentIfNotHandled()?.let {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.error)
            builder.setMessage(R.string.error_creating_intent)
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

    companion object {
        @JvmStatic fun getIntent(context: Context): Intent {
            val intent = Intent(context, SurveyActivity::class.java)
            return intent
        }
    }
}