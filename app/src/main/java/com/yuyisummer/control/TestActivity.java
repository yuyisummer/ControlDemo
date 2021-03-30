package com.yuyisummer.control;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yuyisummer.control.api.IKeyDownAction;
import com.yuyisummer.control.api.impl.BaseKeyDownAction;
import com.yuyisummer.control.base.BaseActivity;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2011-2021, by your Signway, All rights reserved.
 * -----------------------------------------------------------------
 *
 * ProjectName: ControlDemo
 *
 * Author: yuyisummer
 *
 * Email: jh.yu@Signway.cn
 *
 * Description:
 *
 * -----------------------------------------------------------------
 * 2021/3/30 : Create TestActivity.java
 * -----------------------------------------------------------------
 */
public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }


    @Override
    public IKeyDownAction getKeyAction() {
        return new BaseKeyDownAction(){
            @Override
            public boolean back() {
                Toast.makeText(TestActivity.this,"当前界面不拦截返回键",Toast.LENGTH_SHORT).show();
                return false;
            }
        };
    }

}
