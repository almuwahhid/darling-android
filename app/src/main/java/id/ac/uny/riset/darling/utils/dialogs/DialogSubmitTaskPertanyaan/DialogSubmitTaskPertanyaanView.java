package id.ac.uny.riset.darling.utils.dialogs.DialogSubmitTaskPertanyaan;

import id.ac.uny.riset.darling.base.BaseView;
import id.ac.uny.riset.darling.data.model.TaskPertanyaanModel;

public interface DialogSubmitTaskPertanyaanView {
    interface Presenter{
        void submitTaskPertanyaan(TaskPertanyaanModel taskIntervensiModel);
    }

    interface View extends BaseView {
        void onSubmitTaskPertanyaan(boolean isSuccess, String message, boolean isDone);
    }
}
