package id.ac.uny.riset.darling.menu.survey

import android.content.Context
import id.ac.uny.riset.darling.base.BasePresenter
import id.ac.uny.riset.darling.data.EndPoints
import id.ac.uny.riset.darling.data.model.AspekIndikatorModel
import id.ac.uny.riset.darling.data.model.PernyataanModel
import id.ac.uny.riset.darling.data.model.PertanyaanSurveyModel
import id.ac.uny.riset.darling.menu.survey.helper.SurveyHelper
import id.ac.uny.riset.darling.utils.Function
import lib.almuwahhid.utils.UiLibRequest
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap

class SurveyPresenter(ctx: Context?, view: SurveyInterface.View) : BasePresenter(ctx), SurveyInterface.Presenter {
    lateinit var ctx: Context
    lateinit var view: SurveyInterface.View

    init {
        this.ctx = ctx!!
        this.view = view
    }

    override fun submitPertanyaan(pertanyaanSurveyModel: PertanyaanSurveyModel?, pernyataanModel: PernyataanModel?) {
        UiLibRequest.POST(EndPoints.stringSubmitPertanyaan(), context, object : UiLibRequest.OnPostRequest {
            override fun onPreExecuted() {
                view.onLoading()
            }

            override fun onSuccess(response: JSONObject) {
                view.onHideLoading()
                try {
                    val isIndikator: Boolean = response.getBoolean("indikator");
                    val isSurvey: Boolean = response.getBoolean("survey");
                    var indikatorMessage = ""
                    var surveyMessage = ""
                    if(isIndikator){
                        indikatorMessage = response.getString("data_indikator");
                    }

                    if(isSurvey){
                        surveyMessage =response.getString("data_survey");
                    }

                    view.onSubmitPertanyaan(isIndikator, isSurvey, indikatorMessage, surveyMessage)

                } catch (e: JSONException) {
                    e.printStackTrace()
                    view.onFailedSubmitPertanyaan("Ada yang bermasalah dengan service")
                }

            }

            override fun onFailure(error: String) {
                view.onHideLoading()
                view.onErrorConnection()
            }

            override fun requestParam(): Map<String, String> {
                val requestParam = HashMap<String, String>()
                requestParam["data"] = gson.toJson(pertanyaanSurveyModel)
                requestParam["pernyataan"] = gson.toJson(pernyataanModel)
                requestParam["user"] = gson.toJson(Function.getUserPreference(context))
                return requestParam
            }

            override fun requestHeaders(): Map<String, String>? {
                val requestHeader = HashMap<String, String>()
                return requestHeader
            }
        })
    }

    override fun requestPernyataan() {
        UiLibRequest.POST(EndPoints.stringPernyataan(), context, object : UiLibRequest.OnPostRequest {
            override fun onPreExecuted() {
                view.onLoading()
            }

            override fun onSuccess(response: JSONObject) {
                view.onHideLoading()
                try {
                    var list_aspekIndikator : MutableList<AspekIndikatorModel> = ArrayList()
                    var data = response.getJSONArray("data")

                    for (i in 0..(data.length() - 1)) {
                        list_aspekIndikator!!.add(gson.fromJson(data.get(i).toString(), AspekIndikatorModel::class.java))
                    }

                    view.onRequestPernyataan(SurveyHelper.convertFromIndikatorToPernyataan(list_aspekIndikator))

                } catch (e: JSONException) {
                    e.printStackTrace()
                    view.onFailedSubmitPertanyaan("Ada yang bermasalah dengan service")
                }

            }

            override fun onFailure(error: String) {
                view.onHideLoading()
                view.onErrorConnection()
            }

            override fun requestParam(): Map<String, String> {
                val requestParam = HashMap<String, String>()
                requestParam["data"] = gson.toJson(Function.getUserPreference(context))
                return requestParam

            }

            override fun requestHeaders(): Map<String, String>? {
                val requestParam = HashMap<String, String>()
                return requestParam
            }
        })
    }
}