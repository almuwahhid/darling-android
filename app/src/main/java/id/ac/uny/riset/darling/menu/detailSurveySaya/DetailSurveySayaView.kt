package id.ac.uny.riset.darling.menu.detailSurveySaya

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.menu.detailSurveySaya.model.DetailSurveySayaModel
import id.ac.uny.riset.darling.menu.surveySaya.model.SurveySayaModel

interface DetailSurveySayaView {
    interface Presenter {
        fun requestSurveySaya(surveySayaModel: SurveySayaModel)
    }

    interface View : BaseView {
        fun onRequestSurveySaya(surveySayaModelList: List<DetailSurveySayaModel>)
        fun onEmptyData()
    }
}