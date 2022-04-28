package id.ac.uny.riset.darling.menu.pertanyaanSaya

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.data.model.TaskPertanyaanModel
import id.ac.uny.riset.darling.menu.surveySaya.model.SurveySayaModel

interface PertanyaanSayaView {
    interface Presenter {
        fun requestPertanyaan(detailSurveySayaModel: SurveySayaModel)
    }

    interface View : BaseView {
        fun onRequestPertanyaan(pertanyaanSaya: List<TaskPertanyaanModel>)
        fun onEmptyData()
    }
}