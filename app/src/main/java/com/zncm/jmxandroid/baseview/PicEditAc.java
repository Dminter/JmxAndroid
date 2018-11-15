//package com.zncm.jmxandroid.baseview;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//
//import com.zncm.jmxandroid.R;
//import com.zncm.jmxandroid.base.BaseAc;
//import com.zncm.jmxandroid.utils.Xutils;
//import com.zncm.jmxandroid.view.pd.PDColorSelView;
//import com.zncm.jmxandroid.view.pd.PDCropImageView;
//import com.zncm.jmxandroid.view.pd.PDPaintView;
//import com.zncm.jmxandroid.view.TextFloatView;
//import com.zncm.jmxandroid.view.pd.crop.ClipImageLayout;
//
///**
// * Created by jiaomx on 2017/5/25.
// */
//
//public class PicEditAc extends BaseAc {
//    public String filePath;
//    public String saveFilePath;
//    Context ctx;
//    Bitmap baseBitmap;
//
//
//    TextFloatView mTextFloatView;
//
//    PDColorSelView mColorSelView;
//    PDPaintView paintView;
//    ImageView edit;
//    ImageView undo;
//    ImageView text;
//    ImageView crop;
//    RelativeLayout rlPaint;
//    ImageView baseImageView;
//    PDCropImageView mPDCropImageView;
//
//    RelativeLayout bottomOp;
//    RelativeLayout bottomOpCrop;
//    RelativeLayout rlCrop;
//
//    FrameLayout flBase;
//
//
//    Rect imgRectF = new Rect();
//
//
//    Button btnCancel;
//    Button btnSure;
//
//    ClipImageLayout mClipImageLayout = null;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ctx = this;
//
//
//        baseBitmap = BitmapFactory.decodeResource(ctx.getResources(),
//                R.drawable.img1);
//
//
//        flBase = (FrameLayout) findViewById(R.id.flBase);
//        baseImageView = (ImageView) findViewById(R.id.baseImageView);
//        mClipImageLayout = (ClipImageLayout) findViewById(R.id.mClipImageLayout);
//
////        baseImageView.setImageBitmap(baseBitmap);
//        paintView = (PDPaintView) findViewById(R.id.mPaintView);
//
//
//        mClipImageLayout.setImageBitmap(baseBitmap);
//
////        baseImageView.post(new Runnable() {
////            public void run() {
////                float x = baseImageView.getLeft();
////                float y = baseImageView.getTop();
////                float width = baseImageView.getWidth();
////                float height = baseImageView.getHeight();
////                float right = baseImageView.getRight();
////                float bottom = baseImageView.getBottom();
////
////                Log.i("^_^ Runnable", "x = " + x + ", y = " + y + ", width = " + width + ", height = " + height +
////                        ", right = " + right + ", bottom = " + bottom);
////                imgRectF  = new RectF(x,y,width,height);
////                Xutils.debug("imgRectF->>"+imgRectF);
////                paintView.setImgRectF(imgRectF);
////            }
////        });
//
//        mTextFloatView = (TextFloatView) findViewById(R.id.mTextFloatView);
//        mPDCropImageView = (PDCropImageView) findViewById(R.id.mPDCropImageView);
//        imageLayout();
//
//
//        baseImageView.bringToFront();
//
//
//        bottomOp = (RelativeLayout) findViewById(R.id.bottomOp);
//        bottomOpCrop = (RelativeLayout) findViewById(R.id.bottomOpCrop);
//
//        rlPaint = (RelativeLayout) findViewById(R.id.rlPaint);
//        rlCrop = (RelativeLayout) findViewById(R.id.rlCrop);
//        edit = (ImageView) findViewById(R.id.edit);
//        text = (ImageView) findViewById(R.id.text);
//        crop = (ImageView) findViewById(R.id.crop);
//        undo = (ImageView) findViewById(R.id.undo);
//        btnCancel = (Button) findViewById(R.id.btnCancel);
//        btnSure = (Button) findViewById(R.id.btnSure);
//        mColorSelView = (PDColorSelView) findViewById(R.id.mColorSelView);
//
//
////         EditText mEditText= (EditText) findViewById(R.id.mEditText);
////        ImageView editTextSure = (ImageView) findViewById(R.id.editTextSure);
//
//
//        mTextFloatView.setText("PMS258");
//        //        editTextSure.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String text = mEditText.getText().toString().trim();
////                if (TextUtils.isEmpty(text)){
////                    return;
////                }
////                mTextFloatView.setText(text);
////            }
////        });
//        mColorSelView.setmOnColorSelListener(new PDColorSelView.OnColorSelListener() {
//            @Override
//            public void onColorSelListener(int color) {
//                paintView.setColor(color);
////                mTextFloatView.setColor(color);
//            }
//        });
//
//
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomOp.setVisibility(View.VISIBLE);
//                rlPaint.bringToFront();
//                rlCrop.setVisibility(View.GONE);
//            }
//        });
//
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomOp.setVisibility(View.GONE);
//                mTextFloatView.bringToFront();
//                rlCrop.setVisibility(View.GONE);
//            }
//        });
//
//
//        crop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rlCrop.setVisibility(View.VISIBLE);
//                rlCrop.bringToFront();
//                bottomOp.setVisibility(View.GONE);
//
//            }
//        });
//
//
//        undo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                paintView.undo();
//            }
//        });
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                baseImageView.bringToFront();
//            }
//        });
//        btnSure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                baseBitmap = mClipImageLayout.clip();
//                baseBitmap = mPDCropImageView.cropBitmap(baseBitmap);
//                if (baseBitmap != null) {
//                    baseImageView.setImageBitmap(baseBitmap);
//                    imageLayout();
//                }
//
//            }
//        });
//
//    }
//
//    private void imageLayout() {
//        baseImageView.post(new Runnable() {
//            public void run() {
//                baseImageView.getGlobalVisibleRect(imgRectF);
//                int top = imgRectF.height() / 2 - baseBitmap.getHeight() / 2;
//                imgRectF.top = top;
//                int bottom = top + baseBitmap.getHeight();
//                imgRectF.bottom = bottom;
//                Xutils.debug("imgRectF->>" + imgRectF + " " + imgRectF.height() / 2 + ":" + baseBitmap.getHeight() / 2);
//                paintView.setImgRectF(imgRectF);
//                mTextFloatView.setImgRectF(imgRectF);
//                mPDCropImageView.setImgRectF(new RectF(imgRectF));
//            }
//        });
//    }
//
//    @Override
//    protected int getLayoutResource() {
//        return R.layout.aa_picedit;
//    }
//}
