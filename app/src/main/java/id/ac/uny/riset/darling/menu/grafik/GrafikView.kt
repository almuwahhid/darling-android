package id.ac.uny.riset.darling.menu.grafik

import id.ac.uny.riset.beres.menu.grafik.model.GrafikAspekUiModel
import id.ac.uny.riset.beres.menu.grafik.model.GrafikUiModel
import id.ac.uny.riset.darling.base.BaseView

interface GrafikView {
    interface Presenter{
        fun requestGrafikNilai()
        fun requestGrafikAspek()
    }

    interface View: BaseView{
        fun onRequestGrafikNilai(list: MutableList<GrafikUiModel>)
        fun onRequestGrafikAspek(list: MutableList<GrafikAspekUiModel>)
        fun onFailedLoadGrafik(message: String)
        fun onLoadingChart1()
        fun onLoadingChart2()
        fun onHideLoadingChart1()
        fun onHideLoadingChart2()
    }
}