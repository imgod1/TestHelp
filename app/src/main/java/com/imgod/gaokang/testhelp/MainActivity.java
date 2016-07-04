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

    private Button btn_help;
    private Button btn_showhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillParentView();
        getHelpData();
        convert();
    }

    private void convert() {
        viewList = getAllViewFromViewGroup(parentViewGroup);
        Log.e("test", "共有多少view:" + viewList.size());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        for (int i = 0; i < viewList.size()-1; i++) {
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
            Log.e("test", "当前位置:" + i + "坐标:getx:" + view.getX() + "gety:" + view.getY());
            Log.e("test", "当前位置:" + i + "width::" + view.getWidth() + "height:" + view.getHeight());
            Log.e("test", "当前位置:" + i + "getPaddingRight::" + view.getPaddingRight() + "getPaddingLeft:" + view.getPaddingLeft() + "getPaddingTop:" + view.getPaddingTop() + "getPaddingBottom:" + view.getPaddingBottom());
            ViewGroup.MarginLayoutParams testMargin = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            Log.e("test", "当前位置:" + i + "leftMargin::" + testMargin.leftMargin + "rightMargin::" + testMargin.rightMargin + "topMargin::" + testMargin.topMargin + "bottomMargin::" + testMargin.bottomMargin);

            View helpView = new View(this);
            ViewGroup.LayoutParams layoutParams = helpView.getLayoutParams();
            if (layoutParams != null) {
                Log.e("test", "LayoutParams不为空");
                layoutParams.width = view.getWidth();
                layoutParams.height = view.getHeight();
            } else {
                AbsoluteLayout.LayoutParams test = new AbsoluteLayout.LayoutParams(view.getWidth(), view.getHeight(), location[0], location[1] - statusBarHeight - contentTop);
                Log.e("test", "LayoutParams为空");
                helpView.setLayoutParams(test);
            }
            final int testfianlposition = i;
            helpView.setBackgroundColor(Color.argb(0x22, 0x00, 0x00, 0x00));
            addHelpView2List(helpView);
//            parentViewGroup.addView(helpView);
            helpView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Hello Click" + testfianlposition, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    /**
     * 访问网络获得帮助信息
     */
    private void getHelpData() {
        helpContent = getString(R.string.help_json);
        Log.e("test", helpContent);
        resolveHelpData(helpContent);
    }

    /**
     * 解析帮助信息,并和view对号入座
     * @param helpData
     */
    private void resolveHelpData(String helpData){
        helpResponse = new Gson().fromJson(helpContent, HelpResponse.class);
        if(helpResponse!=null) {
           List<HelpResponse.DataBean.HelpListBean> helpList =  helpResponse.getData().getHelpList();
            int helplength = helpList.size();
            for(int i=0; i <helplength;i++) {
                for(int j=0;j<allHelpViewList.size();j++) {
                    View view = allHelpViewList.get(j);
                    HelpResponse.DataBean.HelpListBean helpListBean =  helpList.get(i);
                    //如果help和view匹配
                    View helpView = new View(this);
                    int[] location = new int[2];
                    view.getLocationOnScreen(location);
                    Rect frame = new Rect();
                    getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
                    int statusBarHeight = frame.top;
                    int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
                    AbsoluteLayout.LayoutParams helpViewLayoutParams = new AbsoluteLayout.LayoutParams(view.getWidth(), view.getHeight(), location[0], location[1] - statusBarHeight - contentTop);
                    helpView.setLayoutParams(helpViewLayoutParams);
                    allHelpViewList.add(helpView);
                    break;
                }
            }

        } else {
            Log.e("resolveHelpData","gson解析之后,对象为空");
        }
    }

    private void fillParentView() {
        parentViewGroup = new AbsoluteLayout(this);
        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.MATCH_PARENT, AbsoluteLayout.LayoutParams.MATCH_PARENT, 0, 0);
        parentViewGroup.setLayoutParams(layoutParams);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main, parentViewGroup, false);
        parentViewGroup.addView(view, AbsoluteLayout.LayoutParams.MATCH_PARENT, AbsoluteLayout.LayoutParams.MATCH_PARENT);
        setContentView(parentViewGroup);

        btn_help = (Button) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdd2Screen) {
                    Log.e("test", "已经添加到屏幕之上");
                    if (isHelpViewShowing) {
                        Log.e("test", "当前正在显示,我要隐藏");
                        hideHelpView();
                    } else {
                        Log.e("test", "当前正在隐藏,我要显示");
                        showHelpView();
                    }
                } else {
                    Log.e("test", "还没有添加到屏幕上");
                    addHelpView2Screen();
                }
            }
        });

        btn_showhelp = (Button) findViewById(R.id.btn_showhelp);
        btn_showhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpInfoActivity.actionStart(MainActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearAllHelpViewFromScreen();
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

    public List<View> allHelpViewList = new ArrayList<>();
    public boolean isAdd2Screen = false;
    public boolean isHelpViewShowing = false;
    /**
     * 把helpView添加进集合
     *
     * @param view
     */
    public void addHelpView2List(View view) {
        allHelpViewList.add(view);
    }

    /**
     * 从集合中把helpview都移除
     */
    public void clearHelpViewFromList() {
        allHelpViewList.clear();
    }

    /**
     * 把所有的helpview都添加到屏幕之上
     */
    public void addHelpView2Screen() {
        for (View view : allHelpViewList) {
            parentViewGroup.addView(view);
        }
        isAdd2Screen = true;
        isHelpViewShowing = true;
    }

    /**
     * 清除该界面上所有的帮助view
     */
    public void clearAllHelpViewFromScreen() {
        for (View view : allHelpViewList) {
            view.setVisibility(View.GONE);
            parentViewGroup.removeView(view);
        }
        clearHelpViewFromList();
        allHelpViewList = null;
        isAdd2Screen = false;
        isHelpViewShowing = false;
    }

    /**
     * 显示界面上的helpview
     */
    public void showHelpView() {
        if(!isAdd2Screen) {
            addHelpView2Screen();
        }
        for (View view : allHelpViewList) {
            view.setVisibility(View.VISIBLE);
        }
        isHelpViewShowing = true;
    }

    /**
     * 把界面上的所有的帮助view都隐藏.并没有清除,方便重新显示
     */
    public void hideHelpView() {
        for (View view : allHelpViewList) {
            view.setVisibility(View.GONE);
        }
        isHelpViewShowing = false;
    }


}
