package id.ac.uny.riset.darling.utils.dialogs.DialogSubmitTaskPertanyaan;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.ac.uny.riset.darling.R;
import id.ac.uny.riset.darling.data.model.TaskPertanyaanModel;
import lib.almuwahhid.utils.DialogBuilder;
import lib.almuwahhid.utils.LibUi;

public class DialogSubmitTaskPertanyaan extends DialogBuilder implements DialogSubmitTaskPertanyaanView.View {

    RelativeLayout lay_dialog;
    ImageView img_close;
    TextView tv_taskintervensi;


    Button btn_ya, btn_no;

    TaskPertanyaanModel taskIntervensiModel;
    DialogSubmitTaskPertanyaanPresenter presenter;
    OnDialogSubmitPertanyaan onDialogSubmitPertanyaan;


    public DialogSubmitTaskPertanyaan(Context context, final TaskPertanyaanModel taskIntervensiModel, OnDialogSubmitPertanyaan onDialogSubmitPertanyaan) {
        super(context, R.layout.dialog_submit_pertanyaan);
        this.taskIntervensiModel = taskIntervensiModel;
        this.onDialogSubmitPertanyaan = onDialogSubmitPertanyaan;

        presenter = new DialogSubmitTaskPertanyaanPresenter(getContext(), this);

        initComponent(new OnInitComponent() {
            @Override
            public void initComponent(Dialog dialog) {
                img_close = dialog.findViewById(R.id.img_close);
                tv_taskintervensi = dialog.findViewById(R.id.tv_taskintervensi);
                btn_no = dialog.findViewById(R.id.btn_no);
                btn_ya = dialog.findViewById(R.id.btn_ya);
                lay_dialog = dialog.findViewById(R.id.lay_dialog);

                setFullWidth(lay_dialog);
                setAnimation(R.style.DialogBottomAnimation);
                setGravity(Gravity.BOTTOM);

                img_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });

                tv_taskintervensi.setText(taskIntervensiModel.getIntervensi_task());

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new DialogKomentarPertanyaan(getContext(), new DialogKomentarPertanyaan.OnDialogKomentarPertanyaan() {
                            @Override
                            public void onSubmitKomentar(String komentar) {
                                taskIntervensiModel.setStatus_task("T");
                                taskIntervensiModel.setKomentar_pertanyaan(komentar);
                                presenter.submitTaskPertanyaan(taskIntervensiModel);
                            }
                        });
                        dismiss();
                    }
                });

                btn_ya.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new DialogKomentarPertanyaan(getContext(), new DialogKomentarPertanyaan.OnDialogKomentarPertanyaan() {
                            @Override
                            public void onSubmitKomentar(String komentar) {
                                taskIntervensiModel.setStatus_task("Y");
                                taskIntervensiModel.setKomentar_pertanyaan(komentar);
                                presenter.submitTaskPertanyaan(taskIntervensiModel);
                            }
                        });
                        dismiss();
                    }
                });

                show();
            }
        });
    }

    @Override
    public void onLoading() {
        LibUi.showLoadingDialog(getContext(), R.drawable.ic_sand_clock);
    }


    @Override
    public void onHideLoading() {
        LibUi.hideLoadingDialog(getContext());
    }

    @Override
    public void onErrorConnection() {
        LibUi.ToastShort(getContext(), "Ada yang bermasalah dengan server");
    }

    @Override
    public void onSubmitTaskPertanyaan(boolean isSuccess, String message, boolean isDone) {
        LibUi.ToastShort(getContext(), message);

        if(isSuccess){
            onDialogSubmitPertanyaan.onFinishSubmit(isDone);
            dismiss();
        }
    }

    public interface OnDialogSubmitPertanyaan{
        void onFinishSubmit(boolean isDone);
    }
}
