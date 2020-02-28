package id.ac.uny.riset.darling.menu.login

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.data.model.UserModel
import id.ac.uny.riset.darling.menu.login.model.LoginUiModel

interface LoginView {
    interface Presenter{
        abstract fun requestLogin(loginUiModel: LoginUiModel)
    }

    interface View: BaseView{
        abstract fun onSuccessLogin(model: UserModel)
        abstract fun onFailedLogin(message: String)
    }
}