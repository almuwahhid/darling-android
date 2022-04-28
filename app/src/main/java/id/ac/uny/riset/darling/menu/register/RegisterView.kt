package id.ac.uny.riset.darling.menu.register

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.data.model.UserModel

interface RegisterView {
    interface Presenter{
        fun submitRegister(userModel: UserModel)
    }

    interface View: BaseView{
        fun onSubmitRegister(isSuccess: Boolean, message: String)
    }
}