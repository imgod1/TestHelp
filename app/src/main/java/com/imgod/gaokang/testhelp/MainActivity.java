package com.imgod.gaokang.testhelp;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.imgod.gaokang.testhelp.bean.HelpResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<View> viewList;
    public String helpContent;
    public HelpResponse helpResponse;

    private AbsoluteLayout parentViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        initView();
        initData();
        convert();
    }

    private void convert() {
//        for(HelpResponse.DataBean.HelpListBean bean:helpResponse.getData().getHelpList()){
//            if(bean.getControlName()=="") {
//
//            }
//        }

//getWindow().getDecorView().getRootView();
//        parentViewGroup = (AbsoluteLayout) findViewById(R.id.llayout_main);

        viewList = getAllViewFromViewGroup(parentViewGroup);
        Log.e("test", "共有多少view:" + viewList.size());
//        for (int i = 0; i <viewList.size(); i++) {
//            View view = viewList.get(i);
//                if (view instanceof Button) {
//                    Button button = (Button) view;
//                    Log.e("test", "当前位置:" + i + "\t这是一个Button:title:" + button.getText() + "\tid:" + button.getId());
//                } else if (view instanceof TextView) {
//                    TextView textView = (TextView) view;
//                    Log.e("test", "当前位置:" + i + "\t这是一个TextView:title:" + textView.getText() + "\tid:" + textView.getId());
//                }
//            int[] location = new int[2];
//            view.getLocationOnScreen(location);
//            Log.e("test", "当前位置:" + i + "坐标:x:" + location[0] + "y:" + location[1]);
//        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            if (view instanceof Button) {
                Button button = (Button) view;
                Log.e("test", "当前位置:" + i + "\t这是一个Button:title:" + button.getText() + "\tid:" + button.getId());
            } else if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Log.e("test", "当前位置:" + i + "\t这是一个TextView:title:" + textView.getText() + "\tid:" + textView.getId());
            }
            int[] location = new int[2];
            view.getLocationOnScreen(location);
            Rect frame = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            int statusBarHeight = frame.top;
            int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
            Log.e("test", "当前位置:状态栏高度:" + statusBarHeight);
            Log.e("test", "当前位置:标题栏高度:" + contentTop);
            Log.e("test", "当前位置:" + i + "坐标:x:" + location[0] + "y:" + location[1]);
            Log.e("test", "当前位置:" + i + "坐标:x:" + view.getX() + "y:" + view.getY());
            Log.e("test", "当前位置:" + i + "width::" + view.getWidth() + "height:" + view.getHeight());
            Log.e("test", "当前位置:" + i + "getPaddingRight::" + view.getPaddingRight() + "getPaddingLeft:" + view.getPaddingLeft() + "getPaddingTop:" + view.getPaddingTop() + "getPaddingBottom:" + view.getPaddingBottom());

            View helpView = new View(this);
            ViewGroup.LayoutParams layoutParams = helpView.getLayoutParams();
            if (layoutParams != null) {
                Log.e("test", "LayoutParams不为空");
                layoutParams.width = view.getWidth();
                layoutParams.height = view.getHeight();
            } else {
                AbsoluteLayout.LayoutParams test = new AbsoluteLayout.LayoutParams(view.getWidth(), view.getHeight(), location[0], location[1] - statusBarHeight - contentTop);
                Log.e("test", "LayoutParams为空");

//                layoutParams= new ViewGroup.LayoutParams(view.getLayoutParams());
//                layoutParams.width = view.getWidth();
//                layoutParams.height = view.getHeight();
                helpView.setLayoutParams(test);
            }
            final int test = i;
            helpView.setBackgroundColor(Color.argb(0x22, 0x00, 0x00, 0x00));
            parentViewGroup.addView(helpView);
            helpView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Hello Click" + test, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private void initData() {
        helpContent = getString(R.string.help_json);
        Log.e("test", helpContent);
        helpResponse = new Gson().fromJson(helpContent, HelpResponse.class);
    }

    private void initView() {
        parentViewGroup = new AbsoluteLayout(this);
        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(0,0, AbsoluteLayout.LayoutParams.MATCH_PARENT,AbsoluteLayout.LayoutParams.MATCH_PARENT);
        parentViewGroup.setLayoutParams(layoutParams);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main,parentViewGroup,false);
        parentViewGroup.addView(view, AbsoluteLayout.LayoutParams.MATCH_PARENT, AbsoluteLayout.LayoutParams.MATCH_PARENT);
  setContentView(parentViewGroup);

    }

    /**
     * 从一个根布局获得所有的view
     *
     * @param rootViewGroup 根布局
     * @return 一个承载所有view的集合
     */
    public List<View> getAllViewFromViewGroup(ViewGroup rootViewGroup) {
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < rootViewGroup.getChildCount(); i++) {
            View view = rootViewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                viewList.addAll(getAllViewFromViewGroup((ViewGroup) view));
            } else {
                viewList.add(view);
            }
        }
        return viewList;
    }

}
