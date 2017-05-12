package com.zncm.dminter.tip;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.MyApp;

/**
 * Created by jiaomx on 2017/5/8.
 */

public class Tip {
    /**
     * error info sucess warning
     */
    private static int textColor;
    private static int errorColor;
    private static int warningColor;
    private static int infoColor;
    private static int sucessColor;
    private static boolean tintIcon;


    private Tip() {

    }


    public static Drawable tint9PatchDrawableFrame(Context context, int tintColor) {
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return ninePatchDrawable;
    }

    public static Drawable getDrawable(Context context, int id) {
        return Build.VERSION.SDK_INT >= 21 ? context.getDrawable(id) : context.getResources().getDrawable(id);
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }

    }






    public static Drawable tintIcon(Drawable drawable, int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static Toast info(Context context, CharSequence msg) {
        return custom(context, msg, getDrawable(context, R.drawable.ic_info_outline_white_48dp), textColor, Toast.LENGTH_SHORT, true, true);
    }



    public static void tShort(Context context,CharSequence msg) {
         custom(context, msg, getDrawable(context, R.drawable.ic_info_outline_white_48dp), textColor, Toast.LENGTH_SHORT, true, true).show();
    }



    public static Toast custom(Context context, CharSequence msg, Drawable icon, int tintColor, int duration, boolean withIcon, boolean shouldTint) {

        Toast myToast = new Toast(context);
        View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.tip_toast_layout, null);
        TextView toastText = (TextView) toastLayout.findViewById(R.id.toast_text);
        ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id.toast_icon);
        Drawable drawableFrame;
        if (shouldTint) {
            drawableFrame = tint9PatchDrawableFrame(context, tintColor);
        } else {
            drawableFrame = getDrawable(context, R.drawable.toast_frame);
        }
        setBackground(toastLayout, drawableFrame);
        if (withIcon) {
            if (icon == null) {
                throw new IllegalArgumentException("icon is null ！");
            }
            if (tintIcon) {
                icon = tintIcon(icon, tintColor);
            }
            setBackground(toastIcon, icon);
        } else {
            toastLayout.setVisibility(View.GONE);
        }
        toastText.setTextColor(textColor);
        toastText.setText(msg);
        myToast.setView(toastLayout);
        myToast.setDuration(duration);
        return myToast;
    }


    public static class Config {

        private int textColor;
        private int errorColor;
        private int warningColor;
        private int infoColor;
        private int sucessColor;
        private boolean tintIcon;


        private Config() {
            this.textColor = Tip.textColor;
            this.errorColor = Tip.errorColor;
            this.warningColor = Tip.warningColor;
            this.infoColor = Tip.infoColor;
            this.sucessColor = Tip.sucessColor;
            this.tintIcon = Tip.tintIcon;
        }

        public static Tip.Config getInstance() {
            return new Tip.Config();
        }


        public static void reset() {
            Tip.textColor = Color.parseColor("#FFFFFF");
            Tip.errorColor = Color.parseColor("#FF3D00");
            Tip.warningColor = Color.parseColor("#FFC400");
            Tip.infoColor = Color.parseColor("#616161");
            Tip.sucessColor = Color.parseColor("#FF8F00");
            Tip.tintIcon = true;
        }


        public Tip.Config setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Tip.Config setErrorColor(int errorColor) {
            this.errorColor = errorColor;
            return this;
        }

        public Tip.Config setWarningColor(int warningColor) {
            this.warningColor = warningColor;
            return this;
        }

        public Tip.Config setInfoColor(int infoColor) {
            this.infoColor = infoColor;
            return this;
        }

        public Tip.Config setSucessColor(int sucessColor) {
            this.sucessColor = sucessColor;
            return this;
        }

        public Tip.Config setTintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        public void apply() {
            Tip.textColor = this.textColor;
            Tip.errorColor = this.errorColor;
            Tip.warningColor = this.warningColor;
            Tip.infoColor = this.infoColor;
            Tip.sucessColor = this.sucessColor;
            Tip.tintIcon = true;
        }

    }


}
