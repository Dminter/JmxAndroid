package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zncm.dminter.tip.Tip;
import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.Xutils;

import es.dmoral.toasty.Toasty;

public class ToastyActivity extends BaseAc implements View.OnClickListener {
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;
        Toasty.Config.getInstance()
                .setErrorColor(getResources().getColor(R.color.material_amber_100)) // optional
                .setInfoColor(getResources().getColor(R.color.material_blue_800)) // optional
                .setSuccessColor(getResources().getColor(R.color.material_brown_900)) // optional
                .setWarningColor(getResources().getColor(R.color.material_deep_orange_50)) // optional
                .setTextColor(getResources().getColor(R.color.material_green_300)) // optional
                .tintIcon(true) // optional (apply textColor also to the icon)
                .setToastTypeface(Typeface.DEFAULT) // optional
                .apply(); // required


        Tip.Config.getInstance()
                .setErrorColor(getResources().getColor(R.color.material_amber_100)) // optional
                .setInfoColor(getResources().getColor(R.color.material_blue_800)) // optional
                .setSucessColor(getResources().getColor(R.color.material_brown_900)) // optional
                .setWarningColor(getResources().getColor(R.color.material_deep_orange_50)) // optional
                .setTextColor(getResources().getColor(R.color.material_green_300)) // optional
                .apply();

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_toasty;
    }

    /**
     * To display an error Toast:
     *
     * Toasty.error(ctx, "This is an error toast.", Toast.LENGTH_SHORT, true).show(); To
     * display a success Toast:
     *
     * Toasty.success(ctx, "Success!", Toast.LENGTH_SHORT, true).show(); To display an info
     * Toast:
     *
     * Toasty.info(ctx, "Here is some info for you.", Toast.LENGTH_SHORT, true).show(); To
     * display a warning Toast:
     *
     * Toasty.warning(ctx, "Beware of the dog.", Toast.LENGTH_SHORT, true).show(); To
     * display the usual Toast:
     *
     * Toasty.normal(ctx, "Normal toast w/o icon").show(); To display the usual Toast with
     * icon:
     *
     * Toasty.normal(ctx, "Normal toast w/ icon", yourIconDrawable).show(); You can also
     * create your custom Toasts with the custom() method:
     *
     * Toasty.custom(ctx, "I'm a custom Toast", yourIconDrawable, tintColor, duration,
     * withIcon, shouldTint).show();
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toasty1:
                Toasty.error(ctx, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.toasty2:
                Toasty.success(ctx, "Success!", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.toasty3:
                Toasty.info(ctx, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.toasty4:
                Toasty.normal(ctx, "Normal toast w/ icon", getResources().getDrawable(R.drawable.ic_launcher)).show();
                break;
            case R.id.toasty5:
                Xutils.tLong("Toast.makeText(MyApp.getInstance().ctx, msg, Toast.LENGTH_LONG).show();");
                break;
            case R.id.tip1:
                Tip.info(ctx, "Here is some info for you1.").show();
                break;
            case R.id.tip2:
                Tip.info(ctx, "Here is some info for you2.").show();
                break;
            case R.id.tip3:
                Tip.info(ctx, "Here is some info for you3.").show();
                break;
            case R.id.tip4:
                Tip.info(ctx, "Here is some info for you.4").show();
                break;
            case R.id.tip5:
                Xutils.tShort("Toast.makeText(MyApp.getInstance().ctx, msg, Toast.LENGTH_LONG).show();");
                break;

            default:
                break;
        }
    }
}
