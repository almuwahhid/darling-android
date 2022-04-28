package id.ac.uny.riset.darling.menu.surveySaya;

import java.util.List;

import id.ac.uny.riset.darling.base.BaseView;
import id.ac.uny.riset.darling.menu.surveySaya.model.SurveySayaModel;

public interface SurveySayaView {
    interface Presenter{
        void requestSurveySaya();
    }

    interface View extends BaseView {
        void onRequestSurveySaya(List<SurveySayaModel> surveySayaModelList);
        void onEmptyData();
    }
}
