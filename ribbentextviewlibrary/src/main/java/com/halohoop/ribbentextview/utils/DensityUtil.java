package com.halohoop.ribbentextview.utils;

import android.content.Context;

/**
 * Created by halohoop on 2016/5/28.
 */
public class DensityUtil {
    /**
     *
     */
    public static final int CHINESE = 0x000001;

    /**
     *
     */
    public static final int NUMBER_OR_CHARACTER = 0x000002;

    /**
     *
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     *
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     *
     *
     * @param spValue
     * @param type
     * @return
     */
    public static float sp2px(Context context, float spValue, int type) {
        final float scale = context.getResources().getDisplayMetrics().density;
        switch (type) {
            case CHINESE:
                return spValue * scale;
            case NUMBER_OR_CHARACTER:
                return spValue * scale * 10.0f / 18.0f;
            default:
                return spValue * scale;
        }
    }

    /**
     *
     *
     * @param pxValue
     * @param context
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
