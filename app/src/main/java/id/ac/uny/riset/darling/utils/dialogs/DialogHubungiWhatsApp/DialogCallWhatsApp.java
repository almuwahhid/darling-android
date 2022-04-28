package id.ac.uny.riset.darling.utils.dialogs.DialogHubungiWhatsApp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import id.ac.uny.riset.darling.R;
import lib.almuwahhid.utils.DialogBuilder;

public class DialogCallWhatsApp extends DialogBuilder {

    ImageView img_close;
    CardView card_wa;
    RelativeLayout lay_dialog;

    public DialogCallWhatsApp(Context context) {
        super(context, R.layout.dialog_call_whatsapp);

        initComponent(new OnInitComponent() {
            @Override
            public void initComponent(Dialog dialog) {
                card_wa = dialog.findViewById(R.id.card_wa);
                img_close= dialog.findViewById(R.id.img_close);
                lay_dialog = dialog.findViewById(R.id.lay_dialog);

                setAnimation(R.style.DialogBottomAnimation);
                setFullWidth(lay_dialog);
                setGravity(Gravity.BOTTOM);

                img_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });

                card_wa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:085755605369"));
                        getContext().startActivity(intent);
                    }
                });
            }
        });

        show();
    }
}
