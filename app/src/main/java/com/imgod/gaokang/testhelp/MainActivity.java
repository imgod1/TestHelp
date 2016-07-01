package com.imgod.gaokang.testhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.imgod.gaokang.testhelp.bean.HelpResponse;

public class MainActivity extends AppCompatActivity {

    public String helpContent;
    public HelpResponse helpResponse;

    private ViewGroup parentViewGroup;
    private TextView txt_title;
    private Button btn_newadd;
    private Button btn_newadd_stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initData();
        convert();
    }

    private void convert() {
//        for(HelpResponse.DataBean.HelpListBean bean:helpResponse.getData().getHelpList()){
//            if(bean.getControlName()=="") {
//
//            }
//        }

//getWindow().getDecorView().getRootView();
        parentViewGroup = (ViewGroup) findViewById(R.id.llayout_main);
        Log.e("test", "共有多少view:" + parentViewGroup.getChildCount());
        for (int i = 0; i < parentViewGroup.getChildCount(); i++) {
            View view = parentViewGroup.getChildAt(i);

            if (view instanceof Button) {
                Button button = (Button) view;
                Log.e("test", "当前位置:" + i + "\t这是一个Button:title:" + button.getText() + "\tid:" + button.getId());
            } else if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Log.e("test", "当前位置:" + i + "\t这是一个TextView:title:" + textView.getText() + "\tid:" + textView.getId());
            }

            int[] location = new int[2];
            view.getLocationOnScreen(location);
            Log.e("test", "当前位置:" + i + "坐标:x:" + location[0] + "y:" + location[1]);
        }
    }

    private void initData() {
        Log.e("test", getString(R.string.help_json));
        helpContent = getString(R.string.help_json);
        helpResponse = new Gson().fromJson(helpContent, HelpResponse.class);
    }

    private void initView() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        btn_newadd = (Button) findViewById(R.id.btn_newadd);
        btn_newadd_stock = (Button) findViewById(R.id.btn_newadd_stock);
    }
}
