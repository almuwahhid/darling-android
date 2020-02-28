package id.ac.uny.riset.darling.menu.main

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.data.model.SurveyModel
import id.ac.uny.riset.darling.data.model.TaskPertanyaanModel

interface MainView {
    interface Presenter{
        fun checkSurvey()
        fun confirmTask(taskIntervensiModel: TaskPertanyaanModel)
        fun createSurvey()
    }

    interface View: BaseView{
        fun onAfterFirstSurvey()
        fun onAfterSecondSurvey()
        fun onStartSurvey()
        fun onDoSurvey(surveyModel: SurveyModel, taskIntervensiModels: MutableList<TaskPertanyaanModel>)
        fun onConfirmTask(taskIntervensiModel: TaskPertanyaanModel)
        fun onFailed(message: String)
        fun onCreateSurvey(surveyModel: SurveyModel)
    }
}