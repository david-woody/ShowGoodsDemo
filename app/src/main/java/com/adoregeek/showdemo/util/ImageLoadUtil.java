package com.adoregeek.showdemo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import static com.squareup.picasso.MemoryPolicy.NO_CACHE;
import static com.squareup.picasso.MemoryPolicy.NO_STORE;

public class ImageLoadUtil {
    /**
     * Load image from source and set it into the imageView. Use Glide now.
     *
     * @param context context.
     * @param source  could be Uri/String/File/ResourceId.
     * @param view    the imageView.
     */
    public static void load(Context context, String source, ImageView view) {
        if (!TextUtils.isEmpty(source))
            Picasso.with(context)
                    .load(source)
                    .into(view);
    }

//    public static void loadImg(Context context, String source, ImageView view) {
//        if (!TextUtils.isEmpty(source))
//            Picasso.with(context)
//                    .load(source)
//                    .into(view);
//        else
//            Picasso.with(context)
//                    .load(R.drawable.bg_no_pic)
//                    .into(view);
//    }

    public static void loadImg(Context context, String source, ImageView view, int width, int height) {
        if (!TextUtils.isEmpty(source))
            Picasso.with(context)
                    .load(source)
                    .resize(width, height)
                    .into(view);
    }

    public static void load(Context context, File source, ImageView view) {
        if (source != null)
            Picasso.with(context)
                    .load(source)
                    .into(view);
    }

    public static void loadWithoutCache(Context context, String source, ImageView view) {
        Picasso.with(context)
                .load(source)
                .memoryPolicy(NO_CACHE, NO_STORE)
                .into(view);
    }
//    http://temp.im/640x260/ff5a5f/fff

    public static void loadWithoutCache(Context context, File source, ImageView view) {
        Picasso.with(context)
                .load(source)
                .memoryPolicy(NO_CACHE, NO_STORE)
                .into(view);
    }

    public static Bitmap createSquaredBitmap(Bitmap srcBmp) {
        int dim = Math.max(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(dstBmp);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(srcBmp, (dim - srcBmp.getWidth()) / 2, (dim - srcBmp.getHeight()) / 2, null);

        return dstBmp;
    }
}
