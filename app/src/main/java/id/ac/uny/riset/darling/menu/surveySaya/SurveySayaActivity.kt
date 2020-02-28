package id.ac.uny.riset.darling.menu.surveySaya

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import id.ac.uny.riset.beres.menu.grafik.GrafikActivity
import id.ac.uny.riset.darling.BuildConfig
import id.ac.uny.riset.darling.R

import id.ac.uny.riset.darling.base.BaseActivity
import id.ac.uny.riset.darling.menu.detailSurveySaya.DetailSurveySayaActivity
import id.ac.uny.riset.darling.menu.surveySaya.adapter.AdapterSurveySaya
import id.ac.uny.riset.darling.menu.surveySaya.model.SurveySayaModel
import id.ac.uny.riset.darling.utils.Function
import kotlinx.android.synthetic.main.activity_survey_saya.*
import kotlinx.android.synthetic.main.layout_helper.*
import kotlinx.android.synthetic.main.main_toolbar.*

class SurveySayaActivity : BaseActivity(), SurveySayaView.View {

    var surveySayaModelList: MutableList<SurveySayaModel> = ArrayList()
    lateinit var adapterSurveySaya: AdapterSurveySaya
    lateinit var presenter: SurveySayaPresenter

    override fun onRequestSurveySaya(surveySayaModelList: MutableList<SurveySayaModel>) {
        this.surveySayaModelList.clear()
        this.surveySayaModelList.addAll(surveySayaModelList)
        adapterSurveySaya.notifyDataSetChanged()
    }

    override fun onLoading() {
        helper_nodata.visibility = View.GONE
        helper_error.visibility = View.GONE
        helper_loading.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        helper_loading.visibility = View.GONE
    }

    override fun onErrorConnection() {
        helper_error.visibility = View.VISIBLE
    }

    override fun onEmptyData() {
        helper_nodata.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_saya)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("Survey Saya")

        adapterSurveySaya = AdapterSurveySaya(context, surveySayaModelList, object : AdapterSurveySaya.OnAdapterSurveySaya{
            override fun onAdapterSurveySaya(surveySayaModel: SurveySayaModel) {
                startActivity(Intent(context, DetailSurveySayaActivity::class.java).putExtra("data", surveySayaModel))
            }

        })
        presenter = SurveySayaPresenter(context, this)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapterSurveySaya

        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            presenter.requestSurveySaya()
        }
        presenter.requestSurveySaya()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                finish()
            }
            R.id.action_graph -> {
                startActivity(Intent(context, GrafikActivity::class.java))
            }
            R.id.action_download -> {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(BuildConfig.base_url+"laporan/laporansurvey/"+ Function.getUserPreference(context).id_user)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.grafik_menu, menu)
        return true
    }
}
