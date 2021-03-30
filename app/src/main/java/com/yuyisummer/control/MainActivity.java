package com.yuyisummer.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yuyisummer.control.api.IKeyDownAction;
import com.yuyisummer.control.api.impl.BaseKeyDownAction;
import com.yuyisummer.control.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_act_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public IKeyDownAction getKeyAction() {
        return new BaseKeyDownAction(){
            @Override
            public boolean back() {
                Toast.makeText(MainActivity.this,"当前界面拦截返回键",Toast.LENGTH_SHORT).show();
                return true;
            }
        };
    }
}