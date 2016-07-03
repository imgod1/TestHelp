package com.imgod.gaokang.testhelp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsoluteLayout;

import com.imgod.gaokang.testhelp.R;

/**
 * Created by imgod on 2016/7/3.
 */
public class CustomerAbsoluteLayout extends AbsoluteLayout {
    public static final int ID = 0x7f000000;
    public CustomerAbsoluteLayout(Context context) {
        super(context);
    }

    public CustomerAbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initId(){
//        setId(888888);
    }
}
