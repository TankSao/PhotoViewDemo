package com.example.administrator.photoviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/8.
 */

public class MainActivity extends Activity{
    @BindView(R.id.preview)
    TextView preview;
    private ArrayList<String> aList = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhotoViewActivity.class);
                intent.putExtra("index", 1);
                intent.putStringArrayListExtra("imgs", aList);
                startActivity(intent);
            }
        });
    }
    public void initData() {
        aList.add("https://rjwpublic.oss-cn-qingdao.aliyuncs.com/user/avatar/wKeMjaPxHHW4dhwF85z5tJmpG7rTz72N.jpg");
        aList.add("https://rjwpublic.oss-cn-qingdao.aliyuncs.com/user/avatar/xhYcNhm8dA4QWsYwcFWEfB6C3ZZYZDnw.jpg");
        aList.add("https://rjwpublic.oss-cn-qingdao.aliyuncs.com/user/avatar/yzcmPJ5EKTEzhXFhcRhtRyErtsthWS38.png");
        aList.add("https://rjwpublic.oss-cn-qingdao.aliyuncs.com/user/avatar/zjSbFycG8QEQ7jF3PZjMM7ZBmXbB4fRP.jpeg");
    }
}
