package com.imgod.gaokang.testhelp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HelpInfoActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img_cancel;
    private TextView txt_help_info;
    private ImageView img_sound;
    private RecyclerView recyclerview;
    public static void actionStart(Activity activity){
        Intent intent = new Intent(activity,HelpInfoActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_info);
        initView();
        initEvent();
    }

    private void initEvent() {
        img_cancel.setOnClickListener(this);
        img_sound.setOnClickListener(this);
    }

    private void initView() {
        img_cancel = (ImageView) findViewById(R.id.img_cancel);
        txt_help_info = (TextView) findViewById(R.id.txt_help_info);
        img_sound = (ImageView) findViewById(R.id.img_sound);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        txt_help_info.setText("\t\t\t"+txt_help_info.getText());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_cancel:
                finish();
                break;
            case R.id.img_sound:
                Toast.makeText(HelpInfoActivity.this,"Hello Sound",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
