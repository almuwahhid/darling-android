package id.ac.uny.riset.beres.menu.biodata

import id.ac.uny.riset.darling.base.BaseView
import id.ac.uny.riset.darling.data.model.UserModel


interface BiodataView {
    interface Presenter{
        fun updateUser(userModel: UserModel)
    }

    interface View : BaseView {
        fun onRequestUser(userModel: String)
    }
}