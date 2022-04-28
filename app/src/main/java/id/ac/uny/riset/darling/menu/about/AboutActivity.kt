package id.ac.uny.riset.darling.menu.about

import android.os.Bundle
import android.view.MenuItem
import id.ac.uny.riset.darling.BuildConfig
import id.ac.uny.riset.darling.R
import id.ac.uny.riset.darling.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.main_toolbar.*

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("About")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        tv_appname.setText("meetu "+BuildConfig.VERSION_NAME)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
